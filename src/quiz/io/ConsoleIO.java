package quiz.io;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        print(prompt);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException ex) {
                println("Entrada invalida. Intente nuevamente.");
            }
        }
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
}
