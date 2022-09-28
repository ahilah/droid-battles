package Droid.Battle;

import Droid.MainList.ListAllDroids;
import Droid.Team.Team;
import Droid.Type.BaseDroid;
import Droid.Type.CivilDroid;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    Random random = new Random();

    Scanner scanner = new Scanner(System.in);

    private Team userTeam;

    private Team computerTeam;

    public Arena(ListAllDroids listDroids) {
        userTeam = new Team(listDroids);
        computerTeam = new Team(userTeam.GetNumberOfDroids());
    }

    public void TeamBattle() {
        BaseDroid attackerUser, attackerComputer, defenderUser, defenderComputer;
        while(!userTeam.getTeam().isEmpty() && !computerTeam.getTeam().isEmpty()) {
            // дроїд користувача, який буде атакувати
            attackerUser = GetDroidUserToAttack();
            // дроїд комп'ютера, який буде атакувати
            attackerComputer = GetAttackerDroidFromComputer();
            // дроїд комп'ютера, який буде атакований користувачем (обирає юзер)
            defenderComputer = UserChooseComputerDefender();
            // дроїд користувача, який буде атакований ком'ютером
            defenderUser = GetDefenderDroidFromComputer();
            ShowRoundOpponents(attackerUser, attackerComputer, defenderUser, defenderComputer);

            if (random.nextBoolean()) {
               UsersTurn(attackerUser, attackerComputer, defenderUser, defenderComputer);
           }
           else {
               ComputersTurn(attackerUser, attackerComputer, defenderUser, defenderComputer);
           }

           if (random.nextInt() % 5 == 0) {
               FindUserCivilToRegenerateDroid();
           }

            if (random.nextInt() % 5 == 0) {
                FindComputerCivilToRegenerateDroid();
            }

            ShowInfoAfterRound(defenderUser, defenderComputer);

           RemoveDeadDroids(userTeam.getTeam());
           RemoveDeadDroids(computerTeam.getTeam());
        }
        ChooseWinner();
    }

    private void ShowInfoAfterRound(BaseDroid computerDefender, BaseDroid userDefender) {
        System.out.println("\n\t\t\t There are info after attack:");
        System.out.println("User`s defender: " + userDefender);
        System.out.println("Computer`s defender: " + computerDefender + "\n");
    }

    private void ComputersTurn(BaseDroid attackerUser, BaseDroid attackerComputer,
                               BaseDroid defenderUser, BaseDroid defenderComputer) {
        System.out.println("\n\n\t\t It`s computer`s turn!");
        defenderUser.GetAttack(attackerComputer.DroidShoot(defenderUser));
        defenderComputer.GetAttack(attackerUser.DroidShoot(defenderComputer));
        System.out.println("\n----------------------------------------------------------" +
                "---------------------------------------------------------------------------" +
                "---------------------------------------------------------------");
    }

    private void UsersTurn(BaseDroid attackerUser, BaseDroid attackerComputer,
                           BaseDroid defenderUser, BaseDroid defenderComputer) {
        System.out.println("\n\n\t\t It`s user`s turn!");
        defenderComputer.GetAttack(attackerUser.DroidShoot(defenderComputer));
        defenderUser.GetAttack(attackerComputer.DroidShoot(defenderUser));
        System.out.println("\n----------------------------------------------------------" +
                "---------------------------------------------------------------------------" +
                "---------------------------------------------------------------");
    }

    private BaseDroid UserChooseComputerDefender() {
        int droidNo;
        System.out.println("\n\n\t\tChoose defender from computer`s team:  ");
        computerTeam.ShowTeam();
        System.out.print("\n\tType here: ");
        droidNo = scanner.nextInt();
        return computerTeam.getTeam().get(--droidNo);
    }

    private BaseDroid GetDroidUserToAttack () {
        int droidNo;
        System.out.println("\n\n\n\t\tChoose droid-attacker from your team: ");
        userTeam.ShowTeam();
        System.out.print("\n\tType here: ");
        droidNo = scanner.nextInt();
        return userTeam.getTeam().get(--droidNo);
    }

    private void ShowRoundOpponents(BaseDroid attackerUser, BaseDroid attackerComputer,
                                    BaseDroid defenderUser, BaseDroid defenderComputer) {
        System.out.println("\n\n----------------------------------------------------------" +
                "---------------------------------------------------------------------------" +
                "---------------------------------------------------------------");
        System.out.println("User`s droid " + attackerUser + " is about to attack computer`s droid " + defenderComputer);
        System.out.println("Computer`s droid " + attackerComputer + " is about to attack user`s droid " + defenderUser);
        System.out.println("-------------------------------------------------------------" +
                "------------------------------------------------------------------------------" +
                "---------------------------------------------------------\n");
    }

    private void FindComputerCivilToRegenerateDroid() {
        BaseDroid droidRandom;
        for (int i = 0; i < computerTeam.GetNumberOfDroids(); i++) {
            droidRandom = computerTeam.getTeam().get(i);
            if (droidRandom instanceof CivilDroid) {
                System.out.println("\n\n\t----------------------------------------------------------" +
                        "--------------------------------------");
                System.out.println("Droid " + droidRandom + " is about to regenerate somebody`s health.");
                computerTeam.ShowTeam();
                CivilDroid droidToRegenerate = (CivilDroid) (droidRandom);
                int droidNoToRegenerate = random.nextInt(computerTeam.GetNumberOfDroids());
                droidToRegenerate.RegenerateHealthOtherDroid(computerTeam.getTeam().get(droidNoToRegenerate));
                System.out.println("-----------------------------------------------------------" +
                        "-------------------------------------\n");
            }
        }
    }

    private void FindUserCivilToRegenerateDroid() {
        BaseDroid droidRandom;
        int droidNoToRegenerate;
        for (int i = 0; i < userTeam.GetNumberOfDroids(); i++) {
            droidRandom = userTeam.getTeam().get(i);
            if (droidRandom instanceof CivilDroid) {
                System.out.println("\n\n\t----------------------------------------------------------" +
                        "--------------------------------------");
                System.out.println("User, droid " + droidRandom + " can regenerate somebody`s health." +
                        " Choose the lucky one: " );
                userTeam.ShowTeam();
                System.out.print("Type here: ");
                droidNoToRegenerate = scanner.nextInt();
                CivilDroid droidToRegenerate = (CivilDroid)(droidRandom);
                droidToRegenerate.RegenerateHealthOtherDroid(userTeam.getTeam().get(--droidNoToRegenerate));
                System.out.println("-----------------------------------------------------------" +
                        "-------------------------------------");
            }
        }
    }

    private void RemoveDeadDroids(List<BaseDroid> listDroids) {
        for (int i = 0; i < listDroids.size(); i++) {
            if (listDroids.get(i).getHealth() == 0) {
                System.out.println("\n\t Droid " + listDroids.get(i).getDroidName() + " is dead. It leaves the team.\n");
                listDroids.remove(i);
            }
        }
    }

    private void ChooseWinner() {
        if(userTeam.getTeam().isEmpty()) System.out.println("\n\n\t\t\t COMPUTERS TEAM "
                + computerTeam.getTeamName() +  " WINS");
        else System.out.println("\n\n\t USER TEAM " + userTeam.getTeamName() + " WINS");
    }

    private BaseDroid GetAttackerDroidFromComputer() {
        BaseDroid droid = computerTeam.getTeam().get(random.nextInt(computerTeam.GetNumberOfDroids()));
        while(droid instanceof CivilDroid) {
            droid = computerTeam.getTeam().get(random.nextInt(computerTeam.GetNumberOfDroids()));
        }
        System.out.println("\n\nComputer has chose its droid!");
        return droid;
    }

    private BaseDroid GetDefenderDroidFromComputer() {
        int droidNo = 0;
        if(random.nextBoolean()) {
            int droidMinHealth = userTeam.getTeam().get(0).getHealth(), healthRandomDroid;
            for (int i = 0; i < userTeam.GetNumberOfDroids(); i++) {
                healthRandomDroid = userTeam.getTeam().get(i).getHealth();
                if (healthRandomDroid < droidMinHealth) {
                    droidNo = i;
                    droidMinHealth = healthRandomDroid;
                }
            }
        }
        else {
            droidNo = random.nextInt(userTeam.GetNumberOfDroids());
        }
        return userTeam.getTeam().get(droidNo);
    }

}
