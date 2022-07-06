import java.util.Scanner;

abstract class GeometricObject
{
	String color;
	boolean filled;
	public GeometricObject() {
	   this.color="white";
	   this.filled=false;
	}
	
	GeometricObject(String color,boolean filled)
	{
		this.color=color;
		this.filled=filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean getFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	
}
  
class Triangle extends GeometricObject
{
	double side1=1.0,side2=1.0,side3=1.0;
    public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public Triangle() {
	    
	}	
	Triangle(double side1,double side2,double side3,String color,boolean filled)
	{
		super(color,filled);
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	public double getArea()
	{
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public double getPerimeter()
	{
		return (side1+side2+side3);
	}
	public String toString()
	{
		return "Area :"+this.getArea()+"\nPerimeter: "+this.getPerimeter()+"\nColor: "+this.getColor()+"\nFilled: "+this.getFilled();
	}
}

public class Test {  
    public static void main(String s[]) 
    {  
       Triangle t1=new Triangle(10,12,11,"RED",true);
       System.out.println(t1);
       
       System.out.println("-----------------------------------------------------");
       Triangle t=new Triangle();
       System.out.println("Enter the sides of triangle: ");
       Scanner sc=new Scanner(System.in);
       t.side1=sc.nextDouble();
       t.side2=sc.nextDouble();
       t.side2=sc.nextDouble();
       System.out.print("Enter the color: ");
       t.color=sc.next();
       System.out.print("Triangle Filled or Not: ");
       t.filled=sc.nextBoolean();
       
       System.out.println(t);
    }  
}  