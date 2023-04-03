package se.liu.malha079.tetris;

import java.awt.*;

/**
 * Default collisionhandler
 * Handles falling down, and side. Returns false if move was legal.
 */
public class DefaultHandler implements FallHandler
{
    public DefaultHandler() {
    }

    public static boolean defaultCollision(Board board){
	for (int y = 0; y < board.getFalling().getSize(); y++){
	    for (int x = 0; x < board.getFalling().getSize(); x++){
		SquareType fallingBlock = board.getFalling().getSquare(x,y);
		SquareType boardBlock = board.getSquareType( board.getFallingPos().x + x, board.getFallingPos().y + y);
		if (fallingBlock != SquareType.EMPTY && boardBlock != SquareType.EMPTY){
		    return true;
		}
		/*
		else if (fallingBlock != SquareType.EMPTY && boardBlock == SquareType.OUTSIDE) {
		    return true;

		}*/

	    }
	}
	return false;
    }

    	@Override public boolean hasCollision(final Board board, Point oldPos) {
	    return DefaultHandler.defaultCollision(board);
    	}
}
