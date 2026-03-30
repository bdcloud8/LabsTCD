package punic;

public abstract class WarriorImpl implements Warrior {
    protected int health;
    protected int strength;
    protected int x, y;
    protected String type;

    @Override
    public void info() {
        System.out.println(type + " [Здоровье: " + health + ", Сила: " + strength +
                ", Позиция: (" + x + "," + y + ")]");
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    @Override
    public void attack(Warrior target) {
        target.takeDamage(this.strength);
    }

}