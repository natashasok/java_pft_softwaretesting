package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Natasha");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);

    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(1, 1);
    Point p2 = new Point(5, 4);


    System.out.println("Вычисление с помощью метода: Расстояние между точками " + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + p1.distanceToPoint(p2));
    System.out.println("Вычисление с помощью функции: Расстояние между точками " + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + distance(p1,p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");

  }
  public static double distance( Point p1, Point p2){
    return  Math.sqrt(Math.pow((p2.x -p1.x),2) + Math.pow((p2.y - p1.y),2));
  }
}