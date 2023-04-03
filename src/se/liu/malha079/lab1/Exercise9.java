package se.liu.malha079.lab1;

import javax.swing.*;

public class Exercise9
{
    public static void main(String[] args) {
	String x = JOptionPane.showInputDialog("Please input value");
	System.out.println("Roten ur " + x + " är " + findRoot(Double.parseDouble(x)));
    }
    public static double findRoot(double x){
	double guess = x;
	for (int  i = 0; i < 10; i++) {
	    guess -= (guess * guess - x) / (2 * guess);
	}
	return guess;
    }
}
