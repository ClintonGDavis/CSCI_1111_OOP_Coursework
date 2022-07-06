/*
Author: Clint Davis
Date: 7/6/22

This is my attempt at solving Exercise 12-15.
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise12_15 {

	public static void main(String[] args) throws Exception {
		Random r = new Random();
		int[] array = new int[100];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
		}
			
		java.io.File file = new java.io.File("Exercise12_15.txt");
		
		try (java.io.PrintWriter output = new java.io.PrintWriter(file);
		) {
			Arrays.sort(array);
			System.out.println();
			output.println(Arrays.toString(array));
		}
		
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			String num = input.next();
			System.out.print(
			num + " ");
		}

		input.close();
	}
}
