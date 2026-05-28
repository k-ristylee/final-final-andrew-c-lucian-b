import greenfoot.*;

public class Shoe extends Actor
{
    private double dx;
    private double dy;

    public Shoe(int dirX, int dirY)
    {
        setImage("shoe.png");
        getImage().scale(40, 40);

        double speed = 6;

        dx = dirX * speed;
        dy = dirY * speed;

        updateRotation();
    }

    public void act()
    {
        setLocation(
            (int)(getX() + dx),
            (int)(getY() + dy)
        );

        updateRotation();
        checkHit();
        checkRemove();
    }

    private void updateRotation()
    {
        double angle = Math.toDegrees(Math.atan2(dy, dx));
    
        // FIX: align sprite (which faces down-right) properly
        setRotation((int)(angle + 45));
    }

    private void checkHit()
    {
        if (isTouching(Fly.class))
        {
            Fly f = (Fly) getOneIntersectingObject(Fly.class);
            if (f != null)
            {
                getWorld().removeObject(f);
            }
            getWorld().removeObject(this);
        }
    }

    private void checkRemove()
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}