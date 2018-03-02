import greenfoot.*;  
public class score extends Actor
{
       public score(){
           scoreCounter scorecounter = MyWorld.getCounter();
           setImage(new GreenfootImage("Score: "+scorecounter.score+" /50",40,Color.RED,Color.BLACK));       
    }
}
