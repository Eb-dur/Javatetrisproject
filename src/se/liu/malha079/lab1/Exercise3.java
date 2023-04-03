package se.liu.malha079.lab1;

import javax.swing.*;

public class Exercise3
{
    private final static int TABELL = 5;

    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Enter a number");
	boolean statement = true;
	int tabell = 0;
	while (statement) {
	    statement = false;
	    try {
		tabell = Integer.parseInt(input);
	    } catch (NumberFormatException nfe) {
		input = JOptionPane.showInputDialog("That was not a number, enter a number");
		statement = true;
	    }
	}
	for (int i = 1; i < 13; i++) {
	    System.out.println(i + "*" + tabell + " = " + tabell * i);
	}
    }
}
