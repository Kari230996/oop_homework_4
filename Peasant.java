import java.awt.Point;

public class Peasant extends Character {
    public Peasant(String name, int x, int y) {
        super(name, 1, 1, 0, 1, 1, 3, 1, 0, 0, new Point(x, y));
    }
}
