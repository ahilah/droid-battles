package Droid.List;

import Droid.BaseDroid;
import Droid.BlasterDroid;
import Droid.CivilDroid;
import Droid.LaserDroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfDroids {
    public Scanner in = new Scanner(System.in);

    public List<BaseDroid> droidList = new ArrayList<>();

    public ListOfDroids() {
        FillDroidList();
    }

    public List<BaseDroid> getDroidList() {
        return droidList;
    }

    public void setDroidList(List<BaseDroid> droidList) {
        this.droidList = droidList;
    }

    private void PrintListOfChoices() {
        System.out.println("Choose.. ");
        System.out.print("""
                    1 - to crete a droid with lasers.
                    2 - to crete a droid with blasters.
                    3 - to crete a civil droid.
                    4 - to crete a droid with bombs.
                    5 - to crete a droid with fire.
                    6 - to crete a droid with blasters and shield.
                    0 - to exit.""".indent(1));
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
        switch (choiceOption) {
            case 1:
                droid = new LaserDroid(GetDroidName());
                break;
            case 2:
                droid = new BlasterDroid(GetDroidName());
                break;
            case 3:
                droid = new CivilDroid(GetDroidName());
                break;
            default:
                droid = null;
        }
        return droid;
    }

    private void FillDroidList() {
        System.out.println("Create your list of droids.");

        BaseDroid droid;
        while(true) {
            droid = ChooseDroid();
            if(droid == null) return;
            droidList.add(droid);
        }
    }

}
