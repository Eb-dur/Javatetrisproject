package se.liu.malha079.tetris;

/**
 * class that has methods for creating different polys.
 */
public class TetrominoMaker
{
    public TetrominoMaker() {

    }

    public int getNumberOfTypes(){
	return SquareType.values().length;
    }


    public static Poly getPoly(int n){
        if (n > SquareType.values().length-1){
            throw new IllegalArgumentException("Invalid index: " +n);
        }
        SquareType squareType = SquareType.values()[n];
        Poly newPoly = null;
        switch (squareType){
            case I:
                newPoly = generateIPoly();
                break;
            case Z:
                newPoly = generateZPoly();
                break;
            case L:
                newPoly = generateLPoly();
                break;
            case J:
                newPoly = generateJPoly();
                break;
            case T:
                newPoly = generateTPoly();
                break;
            case S:
                newPoly = generateSPoly();
                break;
            case O:
                newPoly = generateOPoly();
                break;
            case EMPTY:
                newPoly = new Poly(1);

        }
        return newPoly;
    }
    private static Poly generateIPoly() {
        Poly newPoly = new Poly(4);             //
        newPoly.setSquare(0, 1, SquareType.I); // XXXX
        newPoly.setSquare(1, 1, SquareType.I); //
        newPoly.setSquare(2, 1, SquareType.I); //
        newPoly.setSquare(3, 1, SquareType.I);
        return newPoly;
    }
    private static Poly generateZPoly(){
        Poly newPoly = new Poly(3);            // XX
        newPoly.setSquare(0,0, SquareType.Z); //  XX
        newPoly.setSquare(1,0, SquareType.Z); //
        newPoly.setSquare(1,1, SquareType.Z);
        newPoly.setSquare(2,1, SquareType.Z);
        return newPoly;
    }

    private static Poly generateJPoly(){
        Poly newPoly = new Poly(3);            // X
        newPoly.setSquare(0,0, SquareType.Z); // XXX
        newPoly.setSquare(0,1, SquareType.Z); //
        newPoly.setSquare(1,1, SquareType.Z);
        newPoly.setSquare(2,1, SquareType.Z);
        return newPoly;
    }

    private static Poly generateLPoly(){
        Poly newPoly = new Poly(3);            //   X
        newPoly.setSquare(2,0, SquareType.L); // XXX
        newPoly.setSquare(0,1, SquareType.L); //
        newPoly.setSquare(1,1, SquareType.L);
        newPoly.setSquare(2,1, SquareType.L);
        return newPoly;
    }
    private static Poly generateSPoly(){
        Poly newPoly = new Poly(3);            //  XX
        newPoly.setSquare(1,0, SquareType.S); // XX
        newPoly.setSquare(2,0, SquareType.S); //
        newPoly.setSquare(1,1, SquareType.S);
        newPoly.setSquare(0,1, SquareType.S);
        return newPoly;
    }
    private static Poly generateTPoly(){
        Poly newPoly = new Poly(3);             //  X
        newPoly.setSquare(1,0, SquareType.T); // XXX
        newPoly.setSquare(0,1, SquareType.T); //
        newPoly.setSquare(1,1, SquareType.T);
        newPoly.setSquare(2,1, SquareType.T);
        return newPoly;
    }
    private static Poly generateOPoly(){
        Poly newPoly = new Poly(2);             // XX
        newPoly.setSquare(0,0, SquareType.O); // XX
        newPoly.setSquare(1,0, SquareType.O);
        newPoly.setSquare(0,1, SquareType.O);
        newPoly.setSquare(1,1, SquareType.O);
        return newPoly;
    }
}
