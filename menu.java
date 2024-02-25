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
                    --> \s""");
            try {
                action_choice = input.nextInt();
            } catch (Exception e){
                action_choice = 0;
            }
            input.skip(".*\n");
            switch (action_choice) {
                case 1:
                    System.out.print("Enter text:\n--> ");
                    action.setText(input.nextLine());
                    break;
                case 2:
                    do {
                        input.skip(".*\n");
                        System.out.print("""
                                1 - Show key
                                2 - Set my key
                                3 - Generate key
                                4 - Cancel
                                --> \s""");
                        try {
                            action_choice = input.nextInt();
                        } catch (Exception e){
                            action_choice = 0;
                        }
                        switch (action_choice) {
                            case 1: System.out.println("Key: " + action.getKey()); break;
                            case 2:
                                System.out.print("Enter new key: ");
                                input.skip(".*\n");
                                try {
                                    action.setKey(input.nextLine());
                                } catch (Exception e){
                                    System.out.print(e.getMessage());
                                }
                                break;
                            case 3:
                                System.out.print("Enter the key length\n--> ");
                                try {
                                    action.keyGen(input.nextInt());
                                } catch (Exception e){
                                    System.out.println("Please enter a number!");
                                    break;
                                }
                                System.out.println("Key generating done!");
                                break;
                            case 4: break;
                            default: System.out.println(Errors.Get_error(103));
                            System.out.println("Press ENTER");
                        }} while (action_choice != 4);
                    break;
                case 3:
                    String enc = action.encrypt();
                    if (enc==null) break;
                    System.out.println("Encrypted message: " + enc);
                    break;
                case 4:
                    String dec = action.decrypt();
                    if (dec==null) break;
                    System.out.println("The decrypted message: " + dec);
                    break;
                case 5:
                    System.out.print("Goodbye!");
                    input.close();
                    return;
                default:
                    System.out.println(Errors.Get_error(103));
                    break;
            }
            System.out.println("Press ENTER");
            input.skip(".*\n");
        } while (true);
    }


}
