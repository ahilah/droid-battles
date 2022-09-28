package Droid.MainList;

import Droid.Type.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListAllDroids {
    public Scanner in = new Scanner(System.in);

    private List<BaseDroid> droidList = new ArrayList<>();

    public ListAllDroids() {
        droidList = new ArrayList<>();
    }

    public List<BaseDroid> getDroidList() {
        return droidList;
    }

    private void PrintListOfChoices() {
        System.out.println("Choose.. ");
        System.out.print("""
                    1 - to crete a droid with lasers.
                    2 - to crete a droid with blasters.
                    3 - to crete a civil droid.
                    4 - to crete a droid with fire bombs.
                    5 - to crete a ninja droid.
                    0 - to exit.""".indent(0));
    }

    private int GetChoice() {
        PrintListOfChoices();
        System.out.print("Type here: ");
        return in.nextInt();
    }

    private String GetDroidName() {
        System.out.print("Enter name of the droid: ");
        in.nextLine();
        return in.nextLine();
    }

    private BaseDroid ChooseDroid() {
        BaseDroid droid;
        int choiceOption = GetChoice();
        droid = switch (choiceOption) {
            case 1 -> new LaserDroid(GetDroidName());
            case 2 -> new BlasterDroid(GetDroidName());
            case 3 -> new CivilDroid(GetDroidName());
            case 4 -> new FireBombDroid(GetDroidName());
            case 5 -> new NinjaDroid(GetDroidName());
            default -> null;
        };
        return droid;
    }

    public void PrintList() {
        System.out.println("\n\t\t\t List of your droids: ");
        for(int i = 0; i < getDroidList().size(); i++) {
            System.out.println(i + 1 + ". " + getDroidList().get(i));
        }
    }

    public void FillDroidList() {
        System.out.println("\nCreate your list of droids.");
        BaseDroid droid;
        while(true) {
            droid = ChooseDroid();
            if(droid == null) return;
            droidList.add(droid);
        }
    }
}
