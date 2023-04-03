package se.liu.malha079.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();
	shapes.add(new Circle(3, 2, 3, new Color(1,200,3)));
	shapes.add(new Circle(4, 1, 8, new Color(120,200,255)));
	shapes.add(new Circle(0, 0, 5, new Color(100,50,100)));
	shapes.add(new Circle(8, 8, 1, new Color(1,20,3)));
	shapes.add(new Rectangle(3,4,10,3,new Color(100,100,100)));
	shapes.add(new Rectangle(2,1,3,8,new Color(200,150,1)));
	shapes.add(new Text(10,12,24,"Tjenixen", new Color(1,13,23)));
	shapes.add(new Text(2,1,3,"Hello World",new Color(200,150,1)));
	for (Shape shape : shapes) {
	    //shape.draw();
	}
    }

}
