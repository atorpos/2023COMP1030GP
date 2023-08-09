package org.trail_01;
import java.util.*;

public class InputChecker {

    public int inputInt(String output_statement) {
        int input_number;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(output_statement);
                input_number = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input_number;
    }

    public String inputString(String output_statement) {
        String input_text;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(output_statement);
                input_text = scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter an Sting.");
            }
        }
        return input_text;
    }
}
