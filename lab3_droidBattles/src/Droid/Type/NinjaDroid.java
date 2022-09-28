package Droid.Type;

import java.util.Random;

public class NinjaDroid extends BaseDroid{

    private final int sushiPower = 15;

    public NinjaDroid(String droidName) {
        super(21, 55, "Ninja-" + droidName);
    }

    @Override
    public int DroidShoot(BaseDroid droid) {
        Random random = new Random();
        int actualDamage = random.nextInt(this.getDamageLevel() - 5) + 5;
        System.out.println(this.getDroidName() + " has made damage " + droid.getDroidName() + " with force "
                + actualDamage);
        int actualSushiPower;
        if ((random.nextInt() % 3) == 0) {
            actualSushiPower = random.nextInt(this.sushiPower - 3) + 3;
            System.out.println(this.getDroidName() + " has additionally shoot " +
                    droid.getDroidName() + " with sushi power " + actualSushiPower);
        }
        else actualSushiPower = 0;
        return actualDamage + actualSushiPower;
    }

    @Override
    public void GetAttack(int damage) {
        if (this.getHealth() < damage) this.setHealth(0);
        else this.setHealth(this.getHealth() - damage);
    }

    @Override
    public String toString() {
        return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() +
                ", Dmg of sushi power: " + sushiPower + ")";
    }

    @Override
    public void ShowInfo() {
        System.out.println(this + ", Dmg of sushi power: " + sushiPower + ")");
    }
}
