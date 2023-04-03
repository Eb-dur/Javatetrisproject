package se.liu.malha079.lab1;

import javax.swing.*;

public class Exercise2
{
    public static void main(String[] args) {
	String forOrWhile = JOptionPane.showInputDialog("for or while?");

	int sum = 42;
	for (int i = 0; i < 10; i++) {
	    sum += 20;
	    System.out.println("Nu är summan värdet " + sum);
	}
	final int min = 10;
	final int max = 20;
	switch (forOrWhile) {
	    case "for":

		System.out.println((sumFor(min, max)));
		break;
	    case "while":

		System.out.println((sumWhile(min, max)));
		break;
	    default:
		System.out.println("Error you did not write for or while!");
	    	break;
	}
    }
    public static int sumFor(int min, int max) {
	int sum = 0;
	for ( int i = min; i < max + 1; i++){
	    sum += i;
	}
	return sum;

    }
    public static int sumWhile(int min, int max) {
	int sum = 0;
	while (min <= max){
	    sum += min;
	    min++;

	}
	return sum;
    }
}