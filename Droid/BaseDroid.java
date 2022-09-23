package Droid;

public abstract class BaseDroid  {

    private final int damageLevel;
    private int health;
    private final String droidName;

    protected BaseDroid(String droidName) {
        this.damageLevel = 0;
        this.health = 25;
        this.droidName = droidName;
    }

    protected BaseDroid(int damageLevel, int health, String droidName) {
        this.damageLevel = damageLevel;
        this.health = health;
        this.droidName = droidName;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }
    public int getDamageLevel() {
        return damageLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getDroidName() {
        return droidName;
    }

    public abstract void DroidShoot(BaseDroid droid);

    public abstract void GetAttack(int damage);

    public abstract void DroidInfo();

    @Override
    public String toString() {
        return getDroidName() + "(HP: " + getHealth() + ", Dmg: " + getDamageLevel() + ", ";
    }
}
