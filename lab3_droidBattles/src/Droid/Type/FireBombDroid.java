package Droid.Type;

import java.util.Random;


public class FireBombDroid extends BaseDroid {

    private final int fireBomb = 30;

    public FireBombDroid(String DroidName) {
        super(20, 40, "Fire-" + DroidName);
    }

    public int getFireBomb() {
        return fireBomb;
    }

    @Override
    public int DroidShoot(BaseDroid droid) {
       Random random = new Random();
       int actualDamage = random.nextInt(this.getDamageLevel() - 10) + 10;
       System.out.println(this.getDroidName() + " has made damage " + droid.getDroidName() + " with force "
             + actualDamage);
       int actualBombDamage;
       if ((random.nextInt() % 5) == 0) {
           actualBombDamage = random.nextInt(this.fireBomb - 15) + 15;
           System.out.println(this.getDroidName() + " has additionally shoot " + droid.getDroidName() + " with force "
                 + actualBombDamage + "  of blaster.");
           }
       else actualBombDamage = 0;
       return actualDamage + actualBombDamage;
    }

    @Override
    public void GetAttack(int damage) {
            if (this.getHealth() < damage) this.setHealth(0);
            else this.setHealth(this.getHealth() - damage);
        }

    @Override
    public String toString() {
       return getDroidName() + " (HP: " + getHealth() + ", Dmg: " + getDamageLevel() +
            ", Dmg of fire bomb: " + fireBomb + ")";
    }

        @Override
        public void ShowInfo() {
            System.out.println(this + ", Dmg of fire bomb: " + fireBomb + ")");
        }
}
