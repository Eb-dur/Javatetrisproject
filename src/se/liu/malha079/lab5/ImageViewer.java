package se.liu.malha079.lab5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageViewer
{
    public static ImageIcon image;
    public final static URL PICTURE_URL = ClassLoader.getSystemResource("images/bONZAI.jpg");;

    public static void main(String[] args) {
	image = new ImageIcon(PICTURE_URL);
	JFrame frame = new JFrame("Bild");
	JComponent rootPane = frame.getRootPane();
	frame.setLayout(new BorderLayout());
	Container contentPane = frame.getContentPane();
	JLabel label = new JLabel();
	label.setIcon(image);
	frame.add(label);
	frame.pack();
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setVisible(true);

    }

}
