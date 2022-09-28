package Droid.Type;

public abstract class BaseDroid  {
    private final int damageLevel;
    private int health;
    private int healthClone;

    private final String droidName;

    protected BaseDroid(String droidName) {
        this.damageLevel = 0;
        this.health = 15;
        this.healthClone = this.health;
        this.droidName = droidName;
    }

    protected BaseDroid(int damageLevel, int health, String droidName) {
        this.damageLevel = damageLevel;
        this.health = health;
        this.healthClone = this.health;
        this.droidName = droidName;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }
    public int getDamageLevel() {
        return damageLevel;
    }

    public int getHealthClone() {
        return healthClone;
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

    public abstract int DroidShoot(BaseDroid droid);

    public abstract void GetAttack(int damage);

    @Override
    public String toString() {
        return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() + ", ";
    }

    public abstract void ShowInfo();
}


