package hil.main;

import ConsoleControle.MenuInput;

import java.io.IOException;

public class StartPoint {
    public static void main(String[] args) throws IOException {
        MenuInput instanceStart = MenuInput.getInstance();
        instanceStart.StartProgram();
    }
}
