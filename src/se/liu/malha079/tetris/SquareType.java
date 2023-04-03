package se.liu.malha079.tetris;

import java.util.Random;

public enum SquareType
{
    I, O, T, S, Z, J, L, EMPTY, OUTSIDE;

    public static void main(String[] args) {
	SquareType[] squareTypeValues = SquareType.values();
	int numberOfDifferentBlocks = squareTypeValues.length;
	Random rnd = new Random();

	for (int i = 0; i < 25; i++){
	    int randomNumber = rnd.nextInt(numberOfDifferentBlocks);
	    System.out.println(squareTypeValues[randomNumber]);
	}
    }

}

