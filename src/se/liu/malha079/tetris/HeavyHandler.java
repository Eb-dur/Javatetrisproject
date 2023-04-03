package se.liu.malha079.tetris;

import java.awt.*;
import java.util.ArrayList;

/**
 * NOT IMPLEMENTED
 */
public class HeavyHandler implements FallHandler
{
    @Override public boolean hasCollision(final Board board, Point oldPos) {
	if (oldPos.y == board.getFallingPos().y-1){
	    ArrayList<Integer> forceDown = new ArrayList<>();
	    for (int y = board.getFalling().getSize() - 1; y > -1; y-- ){
		for (int x = board.getFalling().getSize() - 1; x > -1; x-- ){
		    SquareType fallingBlock = board.getFalling().getSquare(x,y);
		    SquareType boardBlock = board.getSquareType( board.getFallingPos().x + x, board.getFallingPos().y + y);
		    if (fallingBlock != SquareType.EMPTY && boardBlock == SquareType.OUTSIDE) {
			return true;

		    }
		    else if(fallingBlock != SquareType.EMPTY && boardBlock != SquareType.EMPTY){
			for (int boardY = board.getHeight(); boardY > y - 1; y --){
			    if (board.getSquareType(x,boardY) == SquareType.EMPTY){
				forceDown.add(boardY);
				break;
			    }
			}
		    }

		}
	    }


	}
	else {
	    return DefaultHandler.defaultCollision(board);
	}
	return false;
    }


}
