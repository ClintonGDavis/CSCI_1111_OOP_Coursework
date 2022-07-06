import java.util.*;
import java.util.Random;
import java.util.Scanner;


public class Exercise12_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		int[] array = new int[100];
		boolean done = false;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
		}
		
		do {
			try {
				System.out.print("You are about to access an array of 100 integers."
					+ "\nPlease enter an index point which you would like to access: ");
				int index = input.nextInt();
				
				System.out.print("\nThe value of " + index + " is " + array[index]);
				break;
			} catch (java.lang.ArrayIndexOutOfBoundsException ime) {
				System.out.print("\nMake sure to input a number within the limits of 0 - 100.\n\n");
				input.nextLine();
			}
		} while (!done);
	}
}