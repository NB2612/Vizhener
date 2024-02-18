package org.example;

import java.util.Scanner;

public class menu {
    void display(Scanner input){
        System.out.println("Hello and welcome!");
        Action action = new Action();
        int action_choice;
        do {
            System.out.print("""
                    Select an action:
                    1 - Enter text
                    2 - Set key
                    3 - Encrypt
                    4 - Decrypt
                    5 - Exit
                    -->\s""");
            action_choice = input.nextInt();
            input.skip(".*\n");
            switch (action_choice) {
                case 1:
                    System.out.print("Enter text:\n--> ");
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
                    if (enc==null){ System.out.println("Press ENTER"); break; }
                    System.out.println("Encrypted message: " + enc + "\nPress ENTER");
                    break;
                case 4:
                    String dec = action.decrypt();
                    if (dec==null){ System.out.println("Press ENTER"); break; }
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
        } while (true);
    }


}
