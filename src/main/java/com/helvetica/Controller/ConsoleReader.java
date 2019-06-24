package com.helvetica.Controller;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;

    /**
     * Default constructor for ConsoleReader
     */
    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    /**
     * Method getInt
     * @return (int)
     */
    int getInt() {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    /**
     * Delegated method from Scanner.nextLine()
     * @return (String)
     */
    String getLine(){
        return scanner.nextLine();
    }

    /**
     * Delegated method from Scanner.hasNextLine()
     * @return (boolean)
     */
    boolean hasNextLine(){
        return scanner.hasNextLine();
    }
}
