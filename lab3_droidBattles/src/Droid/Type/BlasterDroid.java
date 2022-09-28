package Droid.Type;

import Droid.Type.BaseDroid;

import java.util.Random;

public class BlasterDroid extends BaseDroid {
    private final int blaster = 10;
    private final int regeneration = 5;

    public BlasterDroid(String DroidName) {
        super(16, 51, "Blast-" + DroidName);
    }

    @Override
    public int DroidShoot(BaseDroid droid) {
        Random random = new Random();
        int actualDamage = random.nextInt(this.getDamageLevel() + 1);
        System.out.println(this.getDroidName() + " has made damage " + droid.getDroidName() + " with force " + actualDamage);
        int actualBlasterDamage;
        if ((random.nextInt() % 2) == 0) {
            actualBlasterDamage = random.nextInt(this.blaster + 1);
            System.out.println(this.getDroidName() + " has additionally shoot " + droid.getDroidName() + " with force "
                    + actualBlasterDamage + "  of blaster.");
        }
        else actualBlasterDamage = 0;

        return actualDamage + actualBlasterDamage;
    }

    @Override
    public void GetAttack(int damage) {
        Random random = new Random();
        int actualRegenerationForce = random.nextInt(this.regeneration + 1);

        if (getHealth() + actualRegenerationForce < damage) {
            this.setHealth(0);
            System.out.println("\n\n" + getDroidName() + " tried to generate, but its health anyway is low.");
            return;
        }

        if (actualRegenerationForce + getHealth() - damage > getHealthClone()) {
            this.setHealth(getHealth() - damage);
            System.out.println("\n\n" + getDroidName() + " tried to generate, but something went wrong...");
        } else {
            this.setHealth(getHealth() - damage + actualRegenerationForce);
            System.out.println(getDroidName() + " has regenerated with force of " + actualRegenerationForce);
        }
    }

    @Override
    public String toString() {
        return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() +
                ", Dmg of blaster: " + blaster + ", force of regeneration: " + regeneration +")";
    }

    @Override
    public void ShowInfo() {
        System.out.println(this + ", Dmg of blaster: " + blaster + ", force of regeneration: " + regeneration +")");
    }
}
