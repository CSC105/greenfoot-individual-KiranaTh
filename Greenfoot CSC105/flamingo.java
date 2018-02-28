import greenfoot.*;

public class flamingo extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[36];
    private int speed = 3, vspeed = 0, acc=2, jumpStrength = 25, count = 0;
    private int frame = 1, frameL = images.length-1;
    private boolean jumping,onWood,counter;
    
    
    public void addedToWorld(World myWorld){
        for(int i=1;i<images.length;i++){
          images[i]=new GreenfootImage("Flamingo"+i+".png");
          int NewHeight = (int)images[i].getHeight()/6;
          int NewWidth = (int)images[i].getWidth()/6;
          images[i].scale(NewWidth,NewHeight);
        }
        setImage(images[1]);
    }
    public void animateR(){
        for(int i=1;i<images.length;i++){
          if(frame == i){
            setImage(images[i]);
            if(frame == images.length-1){
              frame = 1;
              return;
            }
          }
        }
        frame++;
    }
    public void animateL(){
        for(int i=images.length-1;i>0;i--){
           if(frameL == i){
            setImage(images[i]);
             if(frameL == 1){
              frameL = images.length-1;
              return;
            }
          }
        }
        frameL--;
    }
    public void act() 
    { 
        checkfall();
        checkKeys();
        Ceiling();
        fall();
        stopAtEdge();
        
        
        Actor bonus = getOneIntersectingObject(bonus.class);
        Actor fish = getOneIntersectingObject(fish.class);
        if(bonus != null){
           getWorld().removeObject(bonus);
           count++;
           scoreCounter scorecounter = MyWorld.getCounter();
           scorecounter.addScore();
           if(count == 3){
              counter = true;
           }
        }else{ 
           if(counter == true && fish !=null ){
              getWorld().removeObject(fish);
              scoreCounter scorecounter = MyWorld.getCounter();
              scorecounter.addScoreFish();
              finish();
            }
        }
         if(getY()>getWorld().getHeight()+100){
            outOfWorld();
        }
    } 
    private void checkKeys(){
        if(Greenfoot.isKeyDown("left")){
           moveLeft();
        }
        if(Greenfoot.isKeyDown("Right") ){
           moveRight();
        }
        if(Greenfoot.isKeyDown("space") && jumping == false){
           jump();
        }
    }
    public boolean onGround(){
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int)(spriteHeight/2)+2;
       
        Actor ground = getOneObjectAtOffset(0,lookForGround,wood.class);
      
        if(ground==null){
           jumping = true; 
           return false;
        }else{
           moveToGround(ground);
           return true;
        }
     }
     public boolean Ceiling(){
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/(-2)+2);
       
        Actor ceiling = getOneObjectAtOffset(0,yDistance,wood.class);
      
        if(ceiling!=null){
           vspeed = -1;
           bopHead(ceiling);
           return true;
        }else{
           return false;
        }
    }
     public void bopHead(Actor ceiling){
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight+getImage().getHeight()/2);
      
        setLocation(getX(),newY);
    }
    public void checkfall(){
        if(onGround()){
          vspeed = 0;
          onWood = true;
        }
        else{
          fall();
        }
    }
    public void moveToGround(Actor ground){
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight+getImage().getHeight())/2;
      
        setLocation(getX(),newY);
        jumping = false;
    }
    public void fall(){
        setLocation(getX(),getY()+vspeed);
        if(vspeed<3){
            vspeed = vspeed + acc;
        }
        jumping = true;
    }
    public void jump(){
        vspeed = vspeed - jumpStrength;
        jumping = true;
        fall();
    }
    public void moveRight(){
        setLocation(getX()+speed,getY());
        animateR();
    }
    public void moveLeft(){
        setLocation(getX()-speed,getY());
        animateL();
    }
    public void outOfWorld(){
        World myWorld = getWorld();
        GameOver gameover = new GameOver();
        
        myWorld.addObject(gameover,myWorld.getWidth()/2,(myWorld.getHeight()/2)-100);
        myWorld.removeObject(this);
        myWorld.addObject(new returnbtn(),500,400);
    }
    public void finish(){
        World myWorld = getWorld();
        Win win = new Win();
        
        myWorld.addObject(win,myWorld.getWidth()/2,(myWorld.getHeight()/2)-100);
        myWorld.addObject(new returnbtn(),500,400);
    }
    public void stopAtEdge()
    {
        if (getX() >= getWorld().getWidth()-1){
          setLocation(getWorld().getWidth()-1,getY());
        }else{
          if (getX()<=0 ){
           setLocation(0,getY());
          }
        }
    }
}