package ConsoleControle;
import Droid.BaseDroid;
import Droid.List.ListOfDroids;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static Input instance = null;
    static Scanner in = new Scanner(System.in);

    // TODO: WHAT FOR ???
    public String str;

    private Input() { }

    public static Input getInstance() {
        if (instance == null) {
            instance = new Input();
        }
        return instance;
    }


    private void ShowChoices() {
        System.out.println("Choose.. ");
        System.out.print("""
                1 - to crete new droid.
                2 - to show list of created droids.
                3 - to start single fight.
                4 - to start team fight.
                5 - to write battle in file.
                6 - to read battle from file.
                0 - to exit.""".indent(1));
    }

    public void StartProgram() {
        List<BaseDroid> droidList = null;
        int choiceOption;
        while(true) {
            ShowChoices();

            System.out.print("\nType here: ");
            choiceOption = in.nextInt();
            switch (choiceOption) {
                case 1: {
                    droidList = new ListOfDroids().getDroidList();
                    break;
                }
                case 2: {
                    if (droidList != null) {
                            for(int i = 0; i < droidList.size(); i++) {
                                System.out.println(i + 1 + ". " + droidList.get(i));
                        }
                    }
                    break;
                }
                default:
                   return;
            }
        }
    }

}
