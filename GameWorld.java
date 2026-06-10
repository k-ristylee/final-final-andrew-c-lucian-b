import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world.
 * 
 * @Lucian and Andrew
 * @May 20, 2026
 */

public class GameWorld extends World
{
    //define instance variables
    private boolean gameOver = false;

    private int collected = 0;
    private int level = 1;

    private static int highScore = 0;

    private Grandma grandma;

    //set up game world
    public GameWorld()
    {
        super(900, 600, 1, false);
        setBackground("background.png");

        grandma = new Grandma();
        addObject(grandma, 200, 200);

        Fly fly = new Fly();
        addObject(fly, 400, 300);

        spawnItem();
        updateHUD();
    }
    //runs main game, checks if game is over
    public void act()
    {
        if (!gameOver)
        {
            checkGameOver();
        }
    }
    // checks number of cakes collected, updates high score, updates difficulty
    public void itemCollected()
    {
        collected++;

        if (collected > highScore)
        {
            highScore = collected;
        }

        int newLevel = (collected / 5) + 1;

        if (newLevel > level)
        {
            level = newLevel;
            grandma.setLevel(level);
        }

        spawnItem();
        updateHUD();
    }
    //spawns cakes in at random places
    private void spawnItem()
    {
        int x = Greenfoot.getRandomNumber(getWidth() - 100) + 50;
        int y = Greenfoot.getRandomNumber(getHeight() - 100) + 50;

        int chance = Greenfoot.getRandomNumber(100);

        if (chance < 65)
        {
            // 65% Chance (Numbers 0 to 64)
            addObject(new Cake(), x, y);
        }
        else if (chance < 90)
        {
            // 25% Chance (Numbers 65 to 89)
            addObject(new Heart(), x, y);
        }
        else
        {
            // 10% Chance (Numbers 90 to 99)
            addObject(new Frozen(), x, y);
        }
    }
    //updates text at corner of screen
    private void updateHUD()
    {
        showText("Collected: " + collected, 98, 30);
        showText("Level: " + level, 80, 60);
        showText("High Score: " + highScore, 105, 90);
    }
    // checks if the fly has run out of health, sets screen as death screen if true
    private void checkGameOver()
    {
        if (getObjects(Fly.class).isEmpty())
        {
            gameOver = true;
            Greenfoot.setWorld(new DeathScreen());
        }
    }
}