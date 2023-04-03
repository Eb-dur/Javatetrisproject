package se.liu.malha079.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Randomizes and displays different shapes and colors
 */
public class DiagramViewer
{
    private final static List<Color> COLORS =
	    List.of(Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
		    Color.CYAN, Color.YELLOW, Color.MAGENTA);

    // Set a fixed seed 0 so you always get the same
    // shapes (for debugging)
    private final static Random RANDOM = new Random(0);

    private static Color getRandomColor() {
	return COLORS.get(RANDOM.nextInt(COLORS.size()));
    }

    private static Circle getRandomCircle() {
	return new Circle(RANDOM.nextInt(400), RANDOM.nextInt(400),
			  RANDOM.nextInt(200), getRandomColor());
    }

    private static Rectangle getRandomRectangle() {
	return new Rectangle(RANDOM.nextInt(400), RANDOM.nextInt(400),
			     RANDOM.nextInt(200), RANDOM.nextInt(200),
			     getRandomColor());
    }

    private static Text getRandomText() {
	return new Text(RANDOM.nextInt(400), RANDOM.nextInt(400),
			RANDOM.nextInt(400), "Hello", new Color(200, 200, 200));
    }

    public static void main(String[] args) {

	DiagramComponent comp = new DiagramComponent();

	final Random rnd = new Random(0);

	for (int i = 0; i < 10; i++) {
	    switch (rnd.nextInt(3)) {
		case 0:
		    comp.addShape(getRandomCircle());
		    break;
		case 1:
		    comp.addShape(getRandomRectangle());
		    break;
		case 2:
		    comp.addShape(getRandomText());
		    break;
	    }
	}

	JFrame frame = new JFrame("Mitt fönster");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
}