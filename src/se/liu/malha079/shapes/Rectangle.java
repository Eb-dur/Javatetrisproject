package se.liu.malha079.shapes;

import java.awt.*;
import java.util.Objects;
/**
 * Circle class extending the AbstractShape class
 * @see AbstractShape for params
 * @param height The height of the Rect
 * @param width  The width of the Rect
 */
public class Rectangle extends AbstractShape
{
    private int height;
    private int width;

    public Rectangle(final int x, final int y, final int height, final int width, final Color color) {
	super(x,y,color);
	this.height = height;
	this.width = width;
    }


    @Override public void draw(final Graphics g) {
	g.setColor(color);
	g.drawRect(x, y, width, height);

    }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + ", color=" + color + '}';
    }

    @Override public boolean equals(final Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	if (!super.equals(o)) {
	    return false;
	}
	final Rectangle rectangle = (Rectangle) o;
	return height == rectangle.height && width == rectangle.width;
    }

    @Override public int hashCode() {
	return Objects.hash(super.hashCode(), height, width);
    }
}
