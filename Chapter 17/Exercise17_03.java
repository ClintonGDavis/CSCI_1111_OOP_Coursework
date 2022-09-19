/**
 * Author: Clint Davis
 * Date: 9/15/22
 *
 * This is my attempt at solving Exercise 17-03.
 */

import java.io.*;
import java.util.Random;

public class Exercise17_03 {
    public static void main(String[] args) throws IOException {
        try (
              DataOutputStream output =
                      new DataOutputStream(new BufferedOutputStream(new FileOutputStream
                              ("Exercise17_03.dat", true)));
        ) {
            Random rand = new Random();
            for (int i = 0; i < 100; i++)
                output.writeInt(rand.nextInt(100));
        }
        readInputStream();
    }

    public static void readInputStream() throws IOException {
        try (
              DataInputStream input =
                      new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise17_03.dat")));
        ) {
            int sum = 0;
            int count = input.available() / 4;

            while (count > -1) {
                sum += input.readInt();
                count--;
                if (count <= 0)
                    System.out.println("The sum of all these integers is: " + sum);
            }
        }
        catch (EOFException ex) {
            System.out.println("\n---All data were read---");
        }
    }
}
