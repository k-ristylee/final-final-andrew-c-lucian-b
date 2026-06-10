import greenfoot.*;  // (World, Actor, Greenfoot)

/**
 * Instruction screen.
 * 
 * @Lucian and Andrew
 * @June 9, 2026
 */
public class InstructionScreen extends World
{
    // scale and set up instruction screen
    public InstructionScreen()
    {    
        super(900, 600, 1); 

        GreenfootImage bg = new GreenfootImage("Instructions.png");
        bg.scale(900, 600);
        setBackground(bg);
    }
    //changes world to the main game world
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        {
            Greenfoot.setWorld(new GameWorld());
        }
    }
}