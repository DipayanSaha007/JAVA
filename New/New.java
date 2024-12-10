import java.util.*;
interface Shape {
    void display();
    double getArea();
}
class circle implements Shape {
    double radius;
    circle (double radius) {this.radius=radius;}
    public void display() {System.out.println("The area of Circle is: ");}
    public double getArea() { return Math.PI*radius*radius;}
}
class rectangle implements Shape {
    double length,breadth;
    rectangle (double length, double breadth) {this.length=length;this.breadth=breadth;}
    public void display() {System.out.println("The area of Rectangle is: ");}
    public double getArea() {return length*breadth;}
}
class triangle implements Shape {
    double hight,base;
    triangle (double hight, double base) {this.hight=hight;this.base=base;}
    public void display() {System.out.println("The area of Triangle is: ");}
    public double getArea() {return 0.5*hight*base;}
}
public class New {
    public static void main(String[] args) {
        int type;
        Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.printf("\nArea Compute:\nInsert 1: Circle\nInsert 2: Rectangle\nInsert 3: Triangle\nInsert 4: Exit\nChoice:");
            type = sc.nextInt();
            switch (type) {
                case 1:
                    circle c = new circle(sc.nextDouble());c.display();
                    System.out.printf("%.2f\n",c.getArea());
                    break;
                case 2:
                    rectangle r = new rectangle(sc.nextDouble(),sc.nextDouble());r.display();
                    System.out.printf("%.2f\n",r.getArea());
                    break;
                case 3:
                    triangle t = new triangle(sc.nextDouble(),sc.nextDouble());t.display();
                    System.out.printf("%.2f\n",t.getArea());
                    break;
                case 4:
                    System.out.println("\nExiting...");
                    System.exit(0);
                    break;
                default:
                    System.err.println("\nInvalid Input\n");
                    break;
            }
        }
    }
}