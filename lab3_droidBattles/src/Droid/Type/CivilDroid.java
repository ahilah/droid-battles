package Droid.Type;

import Droid.Type.BaseDroid;

import java.util.Random;

public class CivilDroid extends BaseDroid {

    private final int regenerationOtherDroids = 22;

    public CivilDroid(String droidName) {
        super("Civ-"+ droidName);
    }

    @Override
    public int DroidShoot(BaseDroid droid) {
        System.out.println("\n" + getDroidName() + " is a peaceful civil droid. It does not attack.");
        return 0;
    }

    @Override
    public void GetAttack(int damage) {
        this.setHealth(getHealth() - damage);
        if (!isAlive()) setHealth(0);
    }

    public void RegenerateHealthOtherDroid(BaseDroid otherDroid) {
        Random random = new Random();
        int actualForceOfOtherDroidRegeneration = random.nextInt(regenerationOtherDroids);
        int newHealth = otherDroid.getHealth() + actualForceOfOtherDroidRegeneration;
        if (newHealth > otherDroid.getHealthClone()) {
            System.out.println("\n\n" + getDroidName() + " is busy now." +
                    " It trying to run from battle and can`t regenerate health of other droid!");
            return;
        }
        otherDroid.setHealth(newHealth);
        System.out.println(getDroidName() + "has regenerated the health of " + otherDroid.getDroidName()
                + " with force of " + actualForceOfOtherDroidRegeneration +
                ". Now its HP is " + otherDroid.getHealth());
    }

    @Override
    public String toString() {
        return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() +
                ", force of regeneration other droids: " + regenerationOtherDroids +" )";
    }

    @Override
    public void ShowInfo() {
        System.out.println(this + ", Dmg of blaster: " + ", force of regeneration: " + " )");
    }
}
