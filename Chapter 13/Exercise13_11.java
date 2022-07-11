/*
 Author: Clint Davis
 Date: 7/7/22
 
 This is my attempt at solving Exercise 13-11.
 
 I wasn't sure if it was necessary for me to initialize variables for all 8 sides of an octagon (rather than just 1 variable),
 but I decided to err on the side of "checking all my boxes", so to speak.
 */


import java.lang.Cloneable;
import java.lang.Comparable;

public class Exercise13_11 {
	public static void main(String[] args) throws Exception {
		Octagon octo1 = new Octagon(8, 8, 8, 8, 8, 8, 8, 8, "Blue", true);
		Octagon octo2 = (Octagon)octo1.clone();
		
		System.out.print(octo1.compareTo(octo2));
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
}

class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	double side1 = 1;
	double side2 = 1;
	double side3 = 1;
	double side4 = 1;
	double side5 = 1;
	double side6 = 1;
	double side7 = 1;
	double side8 = 1;
	
	public Octagon() {
		
	}
	
	public Octagon(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.side4 = side4;
		this.side5 = side5;
		this.side6 = side6;
		this.side7 = side7;
		this.side8 = side8;
	}

	public Octagon(double side1, double side2, double side3, double side4, double side5, double side6, double side7, double side8, String color, boolean filled) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.side4 = side4;
		this.side5 = side5;
		this.side6 = side6;
		this.side7 = side7;
		this.side8 = side8;
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
	
	public double getSide4() {
		return side3;
	}
	
	public double getSide5() {
		return side3;
	}
	
	public double getSide6() {
		return side3;
	}
	
	public double getSide7() {
		return side3;
	}
	
	public double getSide8() {
		return side3;
	}
	
	public double getArea() {
	double area = (2 + (4 / Math.sqrt(2)) * side1 * side1);
	
		return area;
	}
	
	@Override /** Override the protected clone method defined in 
		the Object class, and strengthen its accessibility */
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	@Override
	public int compareTo(Octagon o) {
		if (side1 > o.side1)
			return 1;
		else if (side1 < o.side1)
			return -1;
		else
			return 0;
	}
}