package ConsoleControle.IOFile;

import java.io.*;
import java.util.Scanner;

public class MainAndFileStream {

    private final String filePath;

    public MainAndFileStream() {
        Scanner in = new Scanner(System.in);
        System.out.print("\n Write your file path: ");
        this.filePath = in.nextLine();
    }

    public void StreamMainAndFile() {

        FileOutputStream file = null;
        System.out.println();
        try {
            file = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        TeePrintStream tee = new TeePrintStream(file, System.out);
        System.setOut(tee);

    }

    /***
     * another ok method to print from file, bt did not work here
     * @throws FileNotFoundException
     */
    public void ReadUsingScanner() throws FileNotFoundException {
        String fileName = filePath;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        //"D:\321.txt";
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }

}
