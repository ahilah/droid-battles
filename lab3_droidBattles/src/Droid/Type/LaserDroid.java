package Droid.Type;
import Droid.Type.BaseDroid;

import java.util.Random;

public class LaserDroid extends BaseDroid {

    private final int laserEyesDamage = 20;

    public LaserDroid(String DroidName) {
        super(10, 70, "Lasr-" + DroidName);
    }

    @Override
    public int DroidShoot(BaseDroid droid) {
        Random random = new Random();
        int actualDamage = random.nextInt(this.getDamageLevel() + 1);
        System.out.println(this.getDroidName() + " has made damage "
                + droid.getDroidName() + " with force " + actualDamage);
        int additionalDamage;
        if((random.nextInt() % 3) == 0) {
            additionalDamage = random.nextInt(this.laserEyesDamage + 1);
            System.out.println(this.getDroidName() + " has additionally shot "
                    + droid.getDroidName()+ " with force " + additionalDamage + " by its laser eyes!");
        } else {
            System.out.println("Unlucky, " + this.getDroidName() + " has missed its target and hasn't shoot :(");
            additionalDamage = 0;
        }
        return actualDamage + additionalDamage;
    }

    @Override
    public void GetAttack(int damage) {
        Random random = new Random();
        if((random.nextInt()) % 5 == 0) {
            System.out.println(this.getDroidName() + " has run and avoid attack!");
            return;
        }
        if (this.getHealth() < damage) this.setHealth(0);
        else this.setHealth(this.getHealth() - damage);

    }

    @Override
    public String toString() {
        return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() +
                ", Dmg of laser eyes: " + laserEyesDamage + ")";
    }

    @Override
    public void ShowInfo() {
        System.out.println(this + ", Dmg of blaster: " +", force of regeneration: " + ")");
    }
}
