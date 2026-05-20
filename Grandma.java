import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grandma here.
 * 
 * @Lucian and Andrew
 * @May 20, 2026
 */
public class Grandma extends Actor
{
    /**
     * Act - do whatever the Grandma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - 3, getY());
        }
        else if(Greenfoot.isKeyDown("right")){
            setLocation(getX() + 3, getY());
        }
        else if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 3);
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + 3);
        }
    }
}
