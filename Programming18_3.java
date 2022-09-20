/**
 * Author: Clint Davis
 * Date: 9/20/22
 *
 * This is my attempt at solving Programming 18-3.
 */

import java.util.Scanner;

public class Programming18_3 {
  public static int gcd(int m, int n) {

    if (m % n == 0) {
      return n;
    }
    else {
      return gcd(n, m % n);
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int m = input.nextInt();
    System.out.print("Enter a second integer: ");
    int n = input.nextInt();
    
    System.out.println("The greatest common divisor for " + m +
      " and " + n + " is: " + gcd(m, n));
  }
}