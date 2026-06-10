import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot)

/**
 * Instruction screen.
 * 
 * @Lucian and Andrew
 * @June 9, 2026
 */
public class DeathScreen extends World
{
    //scales and set up death screen
    public DeathScreen()
    {    
        super(900, 600, 1); 
        
        GreenfootImage bg = new GreenfootImage("DeathScreen.png");
        bg.scale(900, 600);
        setBackground(bg);
    }

    public void act()
    {
        // If they press space, send them back to the main game world to try again
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new GameWorld()); 
        }
    }
}