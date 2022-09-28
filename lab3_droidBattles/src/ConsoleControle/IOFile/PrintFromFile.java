package ConsoleControle.IOFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintFromFile {
    public String filePath;

    private void GetFilePath() {
        Scanner in = new Scanner(System.in);
        System.out.print("\n Write your file path: ");
        this.filePath = in.nextLine();
    }

    public void PrintFight() {
        GetFilePath();
        try { // open file
            BufferedReader buff = new BufferedReader(new FileReader(filePath));

            while (true) {
                String line = buff.readLine();
                if (line != null) {
                    System.out.println(line);
                } else break;
            }

            buff.close();
        }
        catch (IOException e) {
            System.out.println("Can't open: " + filePath);
        }
    }
}