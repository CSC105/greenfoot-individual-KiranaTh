import greenfoot.*;  
/** 
 * @Kirana Thanasuttiwat 60130500205
 * @ March 2018
 */
public class MyWorld extends World
{
    public static scoreCounter scorecounter = new scoreCounter();
    public MyWorld()
    {   
        super(1024, 600, 1, false); 

        addObject(new flamingo(),80,530);

        addObject(new wood(),400,580);
        addObject(new wood(),100,600);
        addObject(new wood(),500,500);
        addObject(new wood(),200,500);
        addObject(new wood(),350,400);
        addObject(new wood(),50,400);
        addObject(new wood(),490,300);
        addObject(new wood(),200,300);
        addObject(new wood(),50,200);
        addObject(new wood(),350,200);
        addObject(new wood(),180,20);
        addObject(new wood(),500,100);
        addObject(new wood(),700,40);
        addObject(new wood(),860,180);
        addObject(new wood(),700,270);
        addObject(new wood(),830,370);
        addObject(new wood(),600,400);
        addObject(new wood(),720,480);
        addObject(new wood(),940,520);
        addObject(new wood(),830,600);

        addObject(new bonus(),836,530);
        addObject(new bonus(),356,125);
        addObject(new bonus(),506,430);

        addObject(new fish(),860,140);
        prepare();
    }
    public static scoreCounter getCounter(){
       return scorecounter;
    }
    private void prepare()
    {
        addObject(scorecounter,54,32);
        scorecounter.setLocation(74,41);
    }
}