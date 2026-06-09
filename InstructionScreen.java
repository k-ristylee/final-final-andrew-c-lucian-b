import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot)

public class InstructionScreen extends World
{
    private long startTime;

    public InstructionScreen()
    {    
        // Set to your 900x600 resolution
        super(900, 600, 1); 
        
        // Load and scale your new instructions image
        GreenfootImage bg = new GreenfootImage("Instructions.png");
        bg.scale(900, 600);
        setBackground(bg);
        
        // Record the exact time (in milliseconds) when this screen opens
        startTime = System.currentTimeMillis();
    }

    public void act()
    {
        // 4000 milliseconds = 4 seconds
        // This ensures it lasts exactly 4 seconds regardless of the Greenfoot speed slider
        if (System.currentTimeMillis() - startTime >= 4000)
        {
            // Change "MyWorld" to match your actual gameplay world class name
            Greenfoot.setWorld(new MyWorld()); 
        }
    }
}