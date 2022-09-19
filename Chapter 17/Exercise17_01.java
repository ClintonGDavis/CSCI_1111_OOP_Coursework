/**
 * Author: Clint Davis
 * Date: 9/15/22
 *
 * This is my attempt at solving Exercise 17-01.
 */

import java.util.Random;

public class Exercise17_01 {
    public static void main(String[] args) throws Exception {
        java.io.FileWriter file = new java.io.FileWriter("Exercise17_01.txt", true);

        try (
                java.io.PrintWriter output = new java.io.PrintWriter(file);
        ) {
            Random rand = new Random();
            for (int i = 0; i < 100; i++)
                output.print(rand.nextInt(100) + " ");
        }
    }
}
