import greenfoot.*; 
 
public class scoreCounter extends Actor
{
    int score = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Score: "+score+" /50",25,Color.RED,Color.BLACK));
    }    
    public void addScore(){
       score = score + 10;
    }
    public void addScoreFish(){
       score = score + 20;
    }
    public void re(){
       score = 0;
    }
}
