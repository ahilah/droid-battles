package Droid.Team;
import java.util.*;

import Droid.MainList.ListAllDroids;
import Droid.Type.*;

import java.util.List;

public class Team{

    private String teamName;

    private List<BaseDroid> Team;

    public List<BaseDroid> getTeam() {
        return Team;
    }

    static Scanner in = new Scanner(System.in);

    public Team(ListAllDroids listDroids) {
        Team = GetUserDroidTeam(listDroids);
        System.out.println("\n\n\t\tYour created team " + teamName);
        ShowTeam();
    }

    public Team(int numberDroids) {
        Team = GetComputerTeam(numberDroids);
        System.out.println("\n\n\n\t\tComputer team " + teamName);
        ShowTeam();
    }

    public String getTeamName() {
        return teamName;
    }

    private String GetComputerTeamName() {
        return "LEGION-" + String.valueOf((new Random().nextInt(99999 - 10000) + 10000));
    }

    private BaseDroid getDroidFromComputer() {
        Random random = new Random();
        int kindOfDroid = random.nextInt(6 - 1) + 1;
        String droidName = String.valueOf((new Random().nextInt(99999 - 10000) + 10000));
        return switch (kindOfDroid) {
            case 1 -> new LaserDroid(droidName);
            case 2 -> new BlasterDroid(droidName);
            case 3 -> new CivilDroid(droidName);
            case 4 -> new FireBombDroid(droidName);
            case 5 -> new NinjaDroid(droidName);
            default -> new FireBombDroid(droidName);
        };
    }

    private List<BaseDroid> GetComputerTeam(int numberDroids) {
        teamName = GetComputerTeamName();
        List<BaseDroid> computerTeam = new ArrayList<>();
        for (int i = 0; i < numberDroids; i++) {
            computerTeam.add(getDroidFromComputer());
        }
        return computerTeam;
    }

    private String GetUserTeamName () {
        System.out.print("Choose name for your team: ");
        return in.nextLine();
    }

    public int GetNumberOfDroids() {
        return Team.size();
    }

    private List<BaseDroid> GetUserDroidTeam(ListAllDroids generalListDroids) {
        teamName = GetUserTeamName();
        List<BaseDroid> userTeam = new ArrayList<>();
        System.out.println("\n\n\tChoose droids for your team " + teamName + " from list to fight: ");
        int droidNo = 0;
        while (true) {
            generalListDroids.PrintList();
            System.out.print("Type here: ");
            droidNo = in.nextInt();
            if (--droidNo == -1) return userTeam;
            userTeam.add(generalListDroids.getDroidList().get(droidNo));
        }

    }

    public void ShowTeam() {
        for(int i = 0; i < getTeam().size(); i++) {
            System.out.println(i + 1 + ". " + getTeam().get(i));
        }
    }
}
