/**
 * Author: Clint Davis
 * Date: 9/19/22
 *
 * This is my attempt at solving Programming 18-09.
 */

import java.util.Scanner;

public class Programming18_09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a string: ");
        String value = input.nextLine();

        System.out.println("The reverse of the string you entered is: ");
        reverseDisplay(value);
    }

    public static void reverseDisplay(String value) {
        if (value.length() == 1)
            System.out.print(value);
        else {
            System.out.print(value.charAt(value.length() - 1));

            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}
