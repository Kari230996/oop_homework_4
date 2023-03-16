import java.awt.Point;


public class Bandit extends Character {
    public Bandit(String name, int x, int y) {
        
        super(name, 8, 3, 0, 4, 10, 6, 0, 0, 0, new Point(x, y));
    }
}