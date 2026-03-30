package punic;

public interface Warrior {
    void info();
    int getStrength();
    int getHealth();
    String getType();
    String getSpecialization();
    void setPosition(int x, int y);
    void attack(Warrior target);
    void takeDamage(int damage);
    boolean isAlive();

}