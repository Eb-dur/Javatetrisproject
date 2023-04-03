package se.liu.malha079.tetris;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * PrePicture class that loads and shows the pre picture of the game
 */
public class PrePicture
{
    private ImageIcon image;

    public  void showPreGamePicture(JFrame frame){
	URL url = ClassLoader.getSystemResource("images/bONZAI.jpg");
	image = new ImageIcon(url);
	Container contentPane = frame.getContentPane();
	JLabel label = new JLabel();
	label.setIcon(image);
	frame.add(label);
	frame.pack();
	frame.setVisible(true);
	try{
	    TimeUnit.SECONDS.sleep(2);
	}
	catch (InterruptedException ignored){
		Thread.currentThread().interrupt();
	}
	frame.setVisible(false);
	frame.remove(label);


    }
}
