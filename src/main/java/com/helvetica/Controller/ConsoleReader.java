package com.helvetica.Controller;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public int getInt() {
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

    public String getLine(){
        return scanner.nextLine();
    }
//    public int getInt(){ return scanner.nextInt(); }
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
}
