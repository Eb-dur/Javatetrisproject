package se.liu.malha079.tetris;

import java.util.Arrays;

/**
Poly class that handles all shapes of the game
@param size: the width and height of Poly
 */
public class Poly
{
    private SquareType[][] squares;
    private int size;


    public Poly(final int size) {
	this.size = size;
	this.squares = new SquareType[size][size];
	this.squares = new SquareType[size][size];
	for (int y = 0; y<size; y++) {
	    Arrays.fill(squares[y], SquareType.EMPTY);
	    /*for (int x = 0; x < size; x++) {
		this.squares[y][x] = SquareType.EMPTY;
		//this.squares[y][x] = SquareType.values()[rnd.nextInt(8)];
	    }*/
	}
    }

    public int getSize() {
	return size;
    }

    public SquareType getSquare(int x, int y) {
	return squares[y][x];
    }
    public void setSquare(int x, int y, SquareType squareType) {
	this.squares[y][x] = squareType;
    }

    //Returns rotated poly depending on bool: True -> right
    public Poly rotate(boolean right) {
	Poly rotatedPoly = new Poly(this.size);
	if (right) {
	    for (int y = 0; y < this.size; y++) {
		for (int x = 0; x < this.size; x++) {
		    rotatedPoly.setSquare(this.size - 1 - y, x , this.getSquare(x, y));
		}

	    }
	} else {


	    for (int y = 0; y < this.size; y++) {
		for (int x = 0; x < this.size; x++) {
		    rotatedPoly.setSquare(y,this.size - 1 - x, this.getSquare(x, y));
		}
	    }


	}
	return rotatedPoly;
    }
}
