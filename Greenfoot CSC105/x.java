import greenfoot.*; 

public class x extends Actor
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
           Greenfoot.setWorld(new MyWorld());
        }
    }    
}
