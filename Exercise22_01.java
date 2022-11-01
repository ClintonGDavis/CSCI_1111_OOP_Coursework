/**
 * Author: Clint Davis
 * Date: 10/31/22
 *
 * This is my attempt at solving Exercise 22-01.
 * The order of approximation for this program is O(n^2) Quadratic Time.
 */

import java.util.*;

public class Exercise22_01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = input.next();

        System.out.println("The maximum consecutive substring of your string is: " + returnMax(string));
    }

    public static String returnMax(String string) {
        List<Character> stringList = new LinkedList<>();
        List<Character> stringMax = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            while (stringList.size() > 1 && (stringList.get(stringList.size() - 1) >= string.charAt(i))) {
                stringList.removeAll(stringList);
            }

            stringList.add(string.charAt(i));

            while (stringList.size() > stringMax.size()) {
                stringMax.removeAll(stringMax);
                stringMax.addAll(stringList);
            }
        }

        string = stringMax.toString();

        return string;
    }
}