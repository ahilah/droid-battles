package Droid;

import java.util.Random;

public class CivilDroid extends BaseDroid {

    private final int regenerationOtherDroids = 50;

    public CivilDroid(String droidName) {
        super("CvD-"+ droidName);
    }

    @Override
    public void DroidShoot(BaseDroid droid) {
        System.out.println(getDroidName() + "is a peaceful civil droid. It does not attack.");
    }

    @Override
    public void GetAttack(int damage) {
        this.setHealth(getHealth() - damage);
        if (!isAlive()) setHealth(0);
    }

    public void RegenerateHealthOtherDroid(BaseDroid otherDroid) {
        int actualForceOfOtherDroidRegeneration = new Random(regenerationOtherDroids).nextInt();
        otherDroid.setHealth(otherDroid.getHealth() + actualForceOfOtherDroidRegeneration);
        System.out.println(getDroidName() + "has regenerated the health of " + otherDroid.getDroidName()
                + " with force of " + actualForceOfOtherDroidRegeneration +
                ". Now its HP is " + otherDroid.getHealth());
    }

    @Override
    public void DroidInfo() {
        System.out.println(this + "force of regeneration other droids: " + regenerationOtherDroids +" )");
    }
}
