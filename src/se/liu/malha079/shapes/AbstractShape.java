package se.liu.malha079.shapes;

import java.awt.*;
import java.util.Objects;

/**
 * Abstract class for shapes
 * @param x the x-coordinate for the shape
 * @param y the y-coordinate for the shape
 * @param color the color of the shape
 */
public abstract class AbstractShape implements Shape
{
    protected int x;
    protected int y;
    protected Color color;

    protected AbstractShape(final int x, final int y, final Color color) {
	this.x = x;
	this.y = y;
	this.color = color;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public Color getColor() {
	return color;
    }

    @Override public boolean equals(final Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final AbstractShape that = (AbstractShape) o;
	return x == that.x && y == that.y && Objects.equals(color, that.color);
    }

    @Override public int hashCode() {
	return Objects.hash(x, y, color);
    }
}
