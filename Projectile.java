import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectiles for Grandma attacks.
 * 
 * @Lucian and Andrew
 * @May 20, 2026
 */
public class Projectile extends Actor
{
    private double dx;
    private double dy;

    private int damage;
    private int speed;

    public Projectile(double dirX, double dirY, String imageName, int damage, int speed)
    {
        this.damage = damage;
        this.speed = speed;

        setImage(imageName + ".png");
        getImage().scale(60, 60);

        dx = dirX * speed;
        dy = dirY * speed;

        updateRotation();
    }

    public void act()
    {
        move();
        updateRotation();
        checkHit();
        checkBounds();
    }

    private void move()
    {
        setLocation((int)(getX() + dx), (int)(getY() + dy));
    }

    private void updateRotation()
    {
        setRotation((int)Math.toDegrees(Math.atan2(dy, dx)) + 45);
    }

    private void checkHit()
    {
        if (getWorld() == null)
        {
            return;
        }

        Fly fly = (Fly)getOneIntersectingObject(Fly.class);

        if (fly != null)
        {
            fly.takeDamage(damage);
            getWorld().removeObject(this);
        }
    }

    private void checkBounds()
    {
        if (getWorld() == null)
        {
            return;
        }

        if (getX() < 0 || getX() > getWorld().getWidth() ||
            getY() < 0 || getY() > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }

    public void setScale(int size)
    {
        GreenfootImage img = getImage();
        img.scale(size, size);
        setImage(img);
    }
}