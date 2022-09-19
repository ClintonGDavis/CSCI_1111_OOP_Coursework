/**
 * Author: Clint Davis
 * Date: 9/19/22
 *
 * This is my attempt at solving Exercise 17-14.
 */

import java.io.*;
import java.util.Scanner;

public class Exercise17_14 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name/path of the file you would like to copy: ");
        String inFile = input.next();
        System.out.print("Enter the name/path of the file you would like to create: ");
        String outFile = input.next();

        try (
              RandomAccessFile source = new RandomAccessFile(inFile, "r");
              RandomAccessFile target = new RandomAccessFile(outFile, "rw")
        ) {
            int r = 0;
            source.seek(0);
            while ((r = source.read()) != -1) {
                target.write(((byte)r) + 5);
            }
        }
    }
}