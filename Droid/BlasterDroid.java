package Droid;

import java.util.Random;

public class BlasterDroid extends BaseDroid{

    private final int blaster = 20;
    private final int regeneration = 20;

    public BlasterDroid(String DroidName) {
        super(18, 80, "BtD-" + DroidName);
    }

    @Override
    public void DroidShoot(BaseDroid droid) {
        int actualDamage = new Random(this.getDamageLevel()).nextInt();
        droid.setHealth(droid.getHealth() - actualDamage);
        System.out.println(this.getDroidName() + "has attacked" + droid.getDroidName() + "with force"
                + actualDamage + "  of blaster.");

        if(System.currentTimeMillis() % 2 == 0) {
            int actualBlasterDamage = new Random(blaster).nextInt();
            System.out.println(this.getDroidName() + "has additionally shoot" + "with force"
                    + actualBlasterDamage + "  of blaster.");
            droid.setHealth(droid.getHealth() - actualBlasterDamage);
        }
    }

    @Override
    public void GetAttack(int damage) {
        int actualRegenerationForce = new Random(regeneration).nextInt();
        this.setHealth(getHealth() - damage + actualRegenerationForce);
        System.out.println(getDroidName() + "has regenerated wit force of " + actualRegenerationForce
                + "\n Now its health is " + getHealth());
        if (!isAlive()) setHealth(0);
    }

    @Override
    public void DroidInfo() {
        System.out.println(this + "Dmg of blaster: " + blaster + ", force of regeneration: " + regeneration +" )");
    }
}
