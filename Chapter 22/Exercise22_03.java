/**
 * Author: Clint Davis
 * Date: 11/01/22
 *
 * This is my attempt at solving Exercise 22-03.
 * The order of approximation for this program is O(n) Linear Time.
 */

import java.util.Scanner;

public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string #1: ");
        String s1 = input.nextLine();
        System.out.println("Enter string #2: ");
        String s2 = input.nextLine();

        boolean match = s1.matches(".*" + s2 + ".*");

        if (match) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(0) && s1.charAt(i + 1) == s2.charAt(1)) {
                    System.out.println("matched at index " + i);
                    break;
                }
            }
        } else {
            System.out.println("Your 2 strings do not match.");
        }
    }
}