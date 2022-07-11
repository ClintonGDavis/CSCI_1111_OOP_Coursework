/*
 Author: Clint Davis
 Date: 7/7/22
 
 This is my attempt at solving Exercise 13-1.
 */

import java.util.Scanner;

public class Exercise13_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter 3 values to correspond with 3 sides of a triangle: ");
		double side1 = input.nextDouble(); double side2 = input.nextDouble(); double side3 = input.nextDouble();
		
		System.out.print("Please enter the color you would like this triangle to be: ");
		String color = input.next();
		System.out.print("Please enter \"true\" if you want your triangle to be filled" +
		" or \"false\" if you want it to be empty: ");
		boolean booltri = input.nextBoolean();
		
		GeometricObject tri1 = new Triangle(side1, side2, side3, color, booltri);
		
		System.out.printf("\nThe area of your triangle is %1.3f and its perimeter is %1.0f.\n\n", tri1.getArea(), tri1.getPerimeter());
		System.out.println(tri1.toString());
	}
}

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
			" and filled: " + filled + "\n\n";
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}

class Triangle extends GeometricObject {
	double side1 = 1;
	double side2 = 1;
	double side3 = 1;
	
	public Triangle() {
		
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		setColor(color);
		setFilled(filled);
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
	double s = (side1 + side2 + side3) / 2;
	double area = Math.sqrt(s * ((s - side1) * (s - side2) * (s - side3)));
	
		return area;
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
	
}
