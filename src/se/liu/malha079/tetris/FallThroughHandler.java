package se.liu.malha079.tetris;

import java.awt.*;
/**
Special collisionhandler that lets block fall through other blocks
@see DefaultHandler
 */
public class FallThroughHandler implements FallHandler
{
    public FallThroughHandler() {
    }

    @Override public boolean hasCollision(final Board board, Point oldPos) {
	for (int y = 0; y < board.getFalling().getSize(); y++){
	    for (int x = 0; x < board.getFalling().getSize(); x++){
		SquareType fallingBlock = board.getFalling().getSquare(x,y);
		SquareType boardBlock = board.getSquareType( board.getFallingPos().x + x, board.getFallingPos().y + y);
		if (fallingBlock != SquareType.EMPTY && boardBlock == SquareType.OUTSIDE) {
		    return true;

		}

	    }
	}
	return false;
    }
}

