import java.util.List;
import java.awt.Point;

public class Crossbowman extends Character {
    public Crossbowman(String name, int x, int y) {
        super(name, 6, 3, 16, 3, 10, 4, 0, 0, 30, new Point(x, y));
    }

    private double calculateDistance(Point p1, Point p2) {
        double xDiff = p1.getX() - p2.getX();
        double yDiff = p1.getY() - p2.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public int calculateAverageDamage() {
        int minDamage = getAttack() - 1;
        int maxDamage = getAttack() + 1;

        double averageDamage = (minDamage + maxDamage) / 2.0;
        int roundedDamage = (int) Math.round(averageDamage);

        return roundedDamage;
    }

    public void step(List<Character> allies, List<Character> enemies) {
        // Если жизнь равна нулю или стрел нет, завершить обработку.
        if (health <= 0 || arrows == 0) {
            return;
        }

        // Поиск среди противников наиболее приближённого.
        Character closestEnemy = null;
        double closestDistance = Double.MAX_VALUE;
        for (Character enemy : enemies) {
            double distance = calculateDistance(enemy.getPosition(), position);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestEnemy = enemy;
            }
        }

        // 3. Нанести среднее повреждение найденному противнику.
        if (closestEnemy != null) {
            int damage = calculateAverageDamage();
            closestEnemy.takeDamage(damage);
        }

        // 4. Найти среди своих крестьянина.
        Peasant closestPeasant = null;
        closestDistance = Double.MAX_VALUE;
        for (Character ally : allies) {
            if (ally instanceof Peasant) {
                double distance = calculateDistance(ally.getPosition(), position);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestPeasant = (Peasant) ally;
                }
            }
        }

        // 5. Если найден, завершить метод. Иначе уменьшить запас стрел на одну.
        if (closestPeasant != null) {
            return;
        } else {
            arrows--;
        }
    }
}
