import java.awt.Point;

public abstract class Character {
    protected int attack;
    protected int defense;
    protected int shots;
    protected int damage;
    protected int health;
    protected int speed;
    protected int delivery;
    protected int magic;
    protected int arrows;
    protected Point position;

    public Character(String name, int attack, int defense, int shots, int damage, int health, int speed, int delivery, int magic, int arrows, Point position) {
        this.attack = attack;
        this.defense = defense;
        this.shots = shots;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.arrows = arrows;
        this.position = position;
    }

    public String getDescription() {
        return  this.getClass().getSimpleName() + ": " +
                "attack: " + attack +
                ", defense: " + defense +
                ", shots: " + shots +
                ", damage: " + damage +
                ", health: " + health +
                ", speed: " + speed +
                ", delivery: " + delivery +
                ", magic: " + magic;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getShots() {
        return shots;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getMagic() {
        return magic;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

}
