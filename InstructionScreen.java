import greenfoot.*;  // (World, Actor, Greenfoot)

/**
 * Instruction screen.
 * 
 * @Lucian and Andrew
 * @June 9, 2026
 */
public class InstructionScreen extends World
{
    public InstructionScreen()
    {    
        super(900, 600, 1); 

        GreenfootImage bg = new GreenfootImage("Instructions.png");
        bg.scale(900, 600);
        setBackground(bg);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("Enter"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}