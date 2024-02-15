package org.example;

import java.util.Scanner;

public class menu {
    void display(Scanner input){
        String text;
        System.out.println("Hello and welcome!");
        Action action = new Action();
        int action_choice;
        do {
            System.out.print("Select an action:\n" +
                    "1 - Enter text\n2 - Set key\n3 - Encrypt\n4 - Decrypt\n5 - Exit\n--> ");
            action_choice = input.nextInt();
            input.skip(".*\n");
            switch (action_choice) {
                case 1:
                    System.out.println("Enter text:\n--> ");
                    try {
                        action.setText(input.nextLine());
                    } catch (Exception e){
                        System.out.print(e.getMessage());
                    }
                    System.out.println("Press ENTER");
                    break;
                case 2:
                    System.out.println("Old key: " + action.getKey());
                    System.out.print("New key: ");
                    try {
                        action.setKey(input.nextLine());
                    } catch (Exception e){
                        System.out.print(e.getMessage());
                    }
                    System.out.println("Press ENTER");
                    break;
                case 3:
                    String enc = action.encrypt();
                    System.out.println("Encrypted message: " + enc + "\nPress ENTER");
                    break;
                case 4:
                    String dec = action.decrypt();
                    System.out.println("The decrypted message: " + dec + "\nPress ENTER");
                    break;
                case 5:
                    System.out.print("Goodbye!");
                    return;
                default:
                    System.out.println("Incorrect action. Try again");
                    break;
            }
            input.skip(".*\n");
        } while (action_choice != 4);
    }


}
