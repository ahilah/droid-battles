package ConsoleControle;

import ConsoleControle.IOFile.MainAndFileStream;
import ConsoleControle.IOFile.PrintFromFile;
import Droid.Battle.Arena;
import Droid.MainList.ListAllDroids;
import Droid.Battle.SingleBattle;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MenuInput {
    private static MenuInput instance = null;

    //private List<BaseDroid> droidList = new ArrayList<>();
    /*public List<BaseDroid> getDroidList() {
        return droidList;
    }*/

    static Scanner in = new Scanner(System.in);

    private MenuInput() { }

    public static MenuInput getInstance() {
        if (instance == null) {
            instance = new MenuInput();
        }
        return instance;
    }

    private void ShowChoices() {
        System.out.println("\n\nChoose.. ");
        System.out.print("""
                1 - to crete new droid.
                2 - to show list of created droids.
                3 - to start single fight.
                4 - to start team fight.
                5 - to write battle in file.
                6 - to read battle from file.
                0 - to exit.""".indent(0));
    }

    public void StartProgram() throws IOException {
        int choiceOption;
        ListAllDroids listDroids = new ListAllDroids();
        PrintStream originalPrintStream = System.out;
        boolean writeToFile = false;
        while(true) {
            ShowChoices();
            System.out.print("Type here: ");
            choiceOption = in.nextInt();
            switch (choiceOption) {
                case 1: {
                    listDroids.FillDroidList();
                    break;
                }

                case 2: {
                    if (!(listDroids.getDroidList().isEmpty())) listDroids.PrintList();
                    else System.out.println("\n\t Create at least one droid!");
                    break;
                }

                case 3: {
                    if (listDroids.getDroidList().isEmpty()) {
                        System.out.println("\n\t Create at least one droid!");
                        break;
                    }
                    if (writeToFile)  {
                        writeToFile = false;
                        MainAndFileStream file = new MainAndFileStream();
                        file.StreamMainAndFile();
                    }
                    SingleBattle newSingleBattle = new SingleBattle(listDroids);
                    System.setOut(originalPrintStream);
                    break;
                }

                case 4: {
                    if (listDroids.getDroidList().isEmpty()) {
                        System.out.println("\n\t Create at least one droid!");
                        break;
                    }
                    if (writeToFile)  {
                        writeToFile = false;
                        System.out.println("\n\t\t\t This battle is going to be written in file.");
                        MainAndFileStream file = new MainAndFileStream();
                        file.StreamMainAndFile();
                    }

                    Arena battleArena = new Arena(listDroids);
                    battleArena.TeamBattle();
                    System.out.println("\n\n\tСписок дроїдів користувача після бою: ");
                    listDroids.PrintList();
                    break;
                }

                case 5: {
                    writeToFile = true;
                    System.out.println("\n\t\t\t Next battle will be written to file");
                    break;
                }

                case 6: {
                    PrintFromFile fileReader = new PrintFromFile();
                    System.out.println("\n\n\t\t\t Battle from file");
                    fileReader.PrintFight();
                    System.out.println("\n\t\t\t This is the end of file.");
                    // D:\programming\appliedProgramming\lab3_droidBattles\src\TestFile
                    break;
                }

                default: {
                    System.out.println("\n\n\t Droid Battles were successfully over.");
                    return;
                }
            }
        }
    }

}
