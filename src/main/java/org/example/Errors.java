package org.example;

public class Errors {

    private static final String Key_not_found = "Key not found. Please Enter key",
            Text_not_found = "Text not found. Please enter text",
            Incorrect_action = "Incorrect action. Try again";

    public Errors(){}

    public static String Get_error(int num_err) {
        return switch (num_err) {
            case 101 -> Key_not_found;
            case 102 -> Text_not_found;
            case 103 -> Incorrect_action;
            default -> null;
        };
    }
}
