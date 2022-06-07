/*
Author: Clint Davis
Date: 6/3/22

This is my attempt at solving Exercise 9-1.
*/

public class Rectangle {
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(4, 40);
		System.out.println("The width of this rectangle is " + rec1.width + " and the height is " + rec1.height
			+ "\nThe area is " + rec1.getArea() + " and the perimeter is " + rec1.getPerimeter());
		
		Rectangle rec2 = new Rectangle(3.5, 35.9);
		System.out.printf("\nThe width of this rectangle is %1.1f and the height is %1.1f"
			+ "\nThe area is %1.1f and the perimeter is %1.1f", rec2.width, rec2.height, rec2.getArea(), rec2.getPerimeter());
	}
	
double width;
double height;

Rectangle() {
width = 1;
height = 1;
}
	
Rectangle(double newWidth, double newHeight) {
width = newWidth;
height = newHeight;
}
	
double getArea() {
return width * height;
}
	
double getPerimeter() {
return 2 * (width + height);
}
}