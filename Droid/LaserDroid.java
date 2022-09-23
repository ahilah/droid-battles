package Droid;
import java.util.Random;

public class LaserDroid extends BaseDroid {

    private final int laserEyesDamage = 10;

    // демедж дуже малий але вміє тікати + велике здоров'я
    public LaserDroid(String DroidName) {
        super(9, 90, "LsD-" + DroidName);
    }

    // демедж завжди максималочька + може стрілять очима
    @Override
    public void DroidShoot(BaseDroid droid) {
        droid.setHealth(droid.getHealth() - this.getDamageLevel());
        System.out.println(this.getDroidName() + "has attacked" + droid.getDroidName() + "with force"
        + this.getDamageLevel());
        if(new Random().nextInt() % 3 == 0) {
            System.out.println(this.getDroidName() + "has additionally shoot"
                    + droid.getDroidName() + "by its laser eyes!");
            droid.setHealth(droid.getHealth() - new Random(this.laserEyesDamage).nextInt());
        } else System.out.println("Unlucky, " + this.getDroidName() + "has missed its target and hasn't shoot :(");
    }

    // бєгун - вміє тікати легко поділити рандомне число на 2
    @Override
    public void GetAttack(int damage) {
        if(new Random(this.laserEyesDamage).nextInt() % 2 == 0) {
            System.out.println(this.getDroidName() + "has run and avoid attack!");
            return;
        }
        this.setHealth(this.getHealth() - damage);
        if (!isAlive()) setHealth(0);
    }

    @Override
    public void DroidInfo() {
        System.out.println(this.toString() + "Dmg of laser eyes: " + laserEyesDamage + ")");
    }
}
