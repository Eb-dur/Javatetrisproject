package se.liu.malha079.tetris;

public class BoardTextConverter
{
    public BoardTextConverter() {
    }

    public String convertToText(Board board){
	StringBuilder workingString = new StringBuilder();
	int yMax = board.getHeight();
	int xMax = board.getWidth();
	for (int y = 0; y < yMax; y++ ){
	    for (int x = 0; x < xMax; x++){
		    switch (board.getVisibleSquareAt(x,y)){
		    case S:
			workingString.append("S");
			break;
		    case I:
			workingString.append("I");
			break;
		    case J:
			workingString.append("J");
			break;
		    case L:
			workingString.append("L");
		    	break;
		    case O:
			workingString.append("O");
			break;
		    case T:
			workingString.append("T");
			break;
		    case Z:
			workingString.append("Z");
		    	break;
		    case EMPTY:
			workingString.append("#");
			break;
		}

		if (x == xMax - 1 ){
		    workingString.append("\n");
		}


	    }
	}
	return workingString.toString();
    }
}
