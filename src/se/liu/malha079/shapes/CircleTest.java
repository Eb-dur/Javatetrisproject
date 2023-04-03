package se.liu.malha079.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CircleTest
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	circles.add(new Circle(3, 2, 3, new Color(1,200,3)));
	circles.add(new Circle(4, 1, 8, new Color(120,200,255)));
	circles.add(new Circle(0, 0, 5, new Color(100,50,100)));
	circles.add(new Circle(8, 8, 1, new Color(1,20,3)));
	for (Circle circle : circles) {
	    System.out.println(circle.getX());
	    System.out.println(circle.getY());
	}
    }

}
