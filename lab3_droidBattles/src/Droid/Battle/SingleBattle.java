package Droid.Battle;
import Droid.MainList.ListAllDroids;
import Droid.Type.*;

import java.util.*;

public class SingleBattle {
    private BaseDroid userDroid;
    private BaseDroid computerDroid;

    static Scanner in = new Scanner(System.in);

    public SingleBattle(ListAllDroids listDroids) {
        userDroid = getDroidFromUser(listDroids);
        computerDroid = getDroidFromComputer();
        StartSingleBattle();
    }

    private BaseDroid getDroidFromComputer() {
        Random random = new Random();

        int kindOfDroid = random.nextInt(6 - 1) + 1;
        String droidName = String.valueOf((new Random().nextInt(99999 - 10000) + 10000));
        switch (kindOfDroid){
            case 1: return new LaserDroid(droidName);
            case 2: return new BlasterDroid(droidName);
            case 3: return new CivilDroid(droidName);
            case 4: return new FireBombDroid(droidName);
            case 5: return new NinjaDroid(droidName);
            default: return new LaserDroid(droidName);
        }
    }

    private BaseDroid getDroidFromUser(ListAllDroids listDroids) {
        System.out.println("\n\n\t\tChoose droid from list to fight: ");
        listDroids.PrintList();
        System.out.print("Type here: ");
        int numberOfDroid = in.nextInt();
        return listDroids.getDroidList().get(--numberOfDroid);
    }

    private void ShowInfo() {
        System.out.println("\n\t\t\t There are info after attack:");
        System.out.println("Users droid: " + userDroid);
        System.out.println("Computers droid: " + computerDroid + "\n");
    }

    public void Battle(BaseDroid droid1, BaseDroid droid2) {
        int damage;
        while(droid1.getHealth() != 0 && droid2.getHealth() != 0) {
            damage = droid2.DroidShoot(droid1);
            droid1.GetAttack(damage);
            damage = droid1.DroidShoot(droid2);
            droid2.GetAttack(damage);
            ShowInfo();
            System.out.println("-------------------------------------" +
                    "---------------------------------------------------" +
                    "----------------------------------------------------" +
                    "--------------------------------------------------------\n");
        }
    }

    private void FindWinner() {
        BaseDroid droidtmp;
        if (userDroid.getHealth() != 0) droidtmp = userDroid;
        else droidtmp = computerDroid;
        System.out.println("");
        System.out.println("\n\t\t\tWINNER IS " + droidtmp);
        System.out.println("");
    }

    public void StartSingleBattle() {
        System.out.println("\nComputer has choose its droid. It`s " + computerDroid);
        System.out.println("Your droid: " + userDroid);
        System.out.println("\n\n\t  "+ userDroid.getDroidName() + " vs " + computerDroid.getDroidName());
        System.out.println("\n\n ------------------- Start Battle." +
                " Lets win the strongest or luckiest --------------------------\n");

        Random random = new Random();
        boolean userTurn = (random.nextInt() % 2) == 0;
        // user attack first
        if (userTurn) Battle(computerDroid, userDroid);
        else Battle(userDroid, computerDroid);
        FindWinner();
        ShowInfo();
    }
}
