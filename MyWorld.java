import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1, false);
        
        Grandma grandma = new Grandma();
        addObject(grandma, 300, 200);
    }
}
