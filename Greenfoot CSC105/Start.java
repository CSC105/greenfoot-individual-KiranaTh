import greenfoot.*;  
public class Start extends World
{
    static GreenfootSound myMusic = new GreenfootSound("(Free No Copyright Music) A New Day - Gaming Music Copyright Free.mp3");
    public Start()
    {    
        super(1024, 600, 1, false);
        addObject(new startbtn(),520,400);
    }
    public void act(){
      myMusic.playLoop();
    }
}
