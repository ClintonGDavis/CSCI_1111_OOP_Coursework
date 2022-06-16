/*
Author: Clint Davis
Date: 6/13/22

This is my second attempt at solving Exercise 10-3.

I didn't notice the comment that was left on my previous attempt until today.
*/

public class Exercise10_03 {
	public static void main(String[] args) {
		MyInteger int1 = new MyInteger(32);
		MyInteger int2 = new MyInteger(73);
		MyInteger int3 = new MyInteger(59);
		MyInteger int4 = new MyInteger(84);
		MyInteger int5 = new MyInteger(52);
		
		System.out.printf("Is %d even?  %s%n", int1.getValue(), int1.isEven());
		System.out.printf("Is %d even?  %s%n", int2.getValue(), int2.isEven());
		System.out.printf("Is %d even?  %s%n", int3.getValue(), int3.isEven());
		System.out.printf("Is %d even?  %s%n", int4.getValue(), int4.isEven());
		System.out.printf("Is %d even?  %s%n", int5.getValue(), int5.isEven());
		
		System.out.printf("\nIs %d odd?  %s%n", int1.getValue(), int1.isOdd());
		System.out.printf("Is %d odd?  %s%n", int2.getValue(), int2.isOdd());
		System.out.printf("Is %d odd?  %s%n", int3.getValue(), int3.isOdd());
		System.out.printf("Is %d odd?  %s%n", int4.getValue(), int4.isOdd());
		System.out.printf("Is %d odd?  %s%n", int5.getValue(), int5.isOdd());
		
		System.out.printf("\nIs %d prime?  %s%n", int1.getValue(), int1.isPrime());
		System.out.printf("Is %d prime?  %s%n", int2.getValue(), int2.isPrime());
		System.out.printf("Is %d prime?  %s%n", int3.getValue(), int3.isPrime());
		System.out.printf("Is %d prime?  %s%n", int4.getValue(), int4.isPrime());
		System.out.printf("Is %d prime?  %s%n", int5.getValue(), int5.isPrime());
		
		System.out.printf("\nIs 89 even?  %s%n", MyInteger.isEven(89));
		System.out.printf("Is 89 odd?  %s%n", MyInteger.isOdd(89));
		System.out.printf("Is 89 prime?  %s%n", MyInteger.isPrime(89));
		
		System.out.printf("\nIs %d equal to %d?  %s%n", int1.getValue(), int4.getValue(), int1.equals(int4));
		
		System.out.printf("\n%d%n", MyInteger.parseInt(new char[] {'8', '9', '9', '9', '9', '9', '9', '9', '9'}));
		System.out.printf("%d", MyInteger.parseInt("89"));
	}
}
	
	class MyInteger {
		private int myValue;
		
		MyInteger(int value) {
			myValue = value;
		}
		
		public int getValue() {
			return myValue;
		}
		
		public boolean isEven() {
			return (myValue % 2) == 0;
		}
		
		public boolean isOdd() {
			return (myValue % 2) != 0;
		}
		
		public boolean isPrime() {
			int count = 0;
			boolean isPrime;
			
			for (int i = 2; i < myValue; i++) {
					if (myValue % i == 0) {
						count++;
						}
					}
					if(count == 0) {
						isPrime = true;
					} else {
						isPrime = false;
					}
				return isPrime;
		}
		
		public static boolean isEven(int myInt) {
			return (myInt % 2) == 0;
		}
		
		public static boolean isOdd(int myInt) {
			return (myInt % 2) != 0;
		}
		
		public static boolean isPrime(int myInt) {
			int count = 0;
			boolean isPrime;
			
			for (int i = 2; i < myInt; i++) {
					if (myInt % i == 0) {
						count++;
						}
					}
					if(count == 0) {
						isPrime = true;
					} else {
						isPrime = false;
					}
				return isPrime;
		}
		
		public static boolean isEven(MyInteger myInt) {
			return myInt.isEven();
		}
		
		public static boolean isOdd(MyInteger myInt) {
			return myInt.isOdd();
		}
		
		public static boolean isPrime(MyInteger myInt) {
			return myInt.isPrime();
		}
		
		public boolean equals(int value) {
			if (value == myValue)
				return true;
			return false;
		}
		
		public boolean equals(MyInteger myInt) {
			if (myInt.myValue == this.myValue)
				return true;
			return false;
		}
		
		public static int parseInt(char[] value) {
			String string = new String(value);
			int result = Integer.parseInt(string);
			return result;
		}
		
		public static int parseInt(String value) {
			return Integer.parseInt(value);
		}
	}