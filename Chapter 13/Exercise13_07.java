/*
 Author: Clint Davis
 Date: 7/8/22
 
 This is my attempt at solving Exercise 13-7.
 */

interface Colorable {
	
	public abstract String howToColor();
}

public class Exercise13_07 {
	public static void main(String[] args) {
		
		GeometricObject[] triTri = new GeometricObject[5];
		triTri[0] = new Triangle(50, 40, 30, "red", true);
		triTri[1] = new Triangle(20, 15, 14, "purple", true);
		triTri[2] = new Triangle(30, 15, 27, "pink", true);
		triTri[3] = new Triangle(45, 16, 54, "white", true);
		triTri[4] = new Triangle(50, 15, 40, "black", true);
	
		for (int i = 0; i < triTri.length; i++) {
			
			System.out.println("Triangle #" + (i + 1) + " area = " + triTri[i].getArea());
			if (triTri[i] instanceof Colorable)
				System.out.println(((Colorable)triTri[i]).howToColor() + "\n");
		}
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

class Triangle extends GeometricObject implements Colorable {
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
	
	@Override
	public String howToColor() {
		return "Color all three sides ";
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
