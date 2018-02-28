import greenfoot.*;  
public class startbtn extends Actor
{
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
           Greenfoot.setWorld(new how());
        }
    }    
}
