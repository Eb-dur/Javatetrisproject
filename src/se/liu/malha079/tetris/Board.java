package se.liu.malha079.tetris;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Board class that handles all game logic.
 * @param width the width of the board
 * @param height the height of the board
 * @param rndGen the random number generator for the board
 *
 */
public class Board
{
    private Random rndGen;
    private SquareType[][] squares;
    private int width;
    private int height;
    private Poly falling;
    private Point fallingPos = new Point(4,0);
    private final static int MARGIN = 2;
    private final static int DOUBLE_MARGIN = 2 * MARGIN;
    private final static int NUMBER_OF_POLYS = 7;
    private List<BoardListener> boardListeners = new ArrayList<>();
    private boolean isGameOver = false;
    private int score = 0;
    private int blocksPlaced = 0;

    private Map<Integer, Integer> pointMap;
    private FallHandler fallHandler = new DefaultHandler();

    public Board(final int width, final int height, final Random rndGen) {
        this.rndGen = rndGen;
        this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
        for (int y = 0; y< height + DOUBLE_MARGIN; y++) {
            for (int x = 0; x < width + DOUBLE_MARGIN; x++) {
                if (x < MARGIN || x > width + MARGIN - 1){
                    this.squares[y][x] = SquareType.OUTSIDE;
                } else if (y < MARGIN || y > height + MARGIN - 1) {
                    this.squares[y][x] = SquareType.OUTSIDE;
                }
                else {
                    this.squares[y][x] = SquareType.EMPTY;
                }
            }
        }
        this.fallingPos = new Point(0,0);
        this.falling = TetrominoMaker.getPoly(rndGen.nextInt(NUMBER_OF_POLYS));

        this.width = width;
        this.height = height;
        this.notifyListeners();
        pointMap = new HashMap<>();
        pointMap.put(0,0);
        pointMap.put(1,100);
        pointMap.put(2,300);
        pointMap.put(3,500);
        pointMap.put(4,800);

    }

    // Resets the board to empty
    public void restartBoard(){
        this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
        for (int y = 0; y< height + DOUBLE_MARGIN; y++) {
            for (int x = 0; x < width + DOUBLE_MARGIN; x++) {
                if (x < MARGIN || x > width + MARGIN - 1){
                    this.squares[y][x] = SquareType.OUTSIDE;
                } else if (y < MARGIN || y > height + MARGIN - 1) {
                    this.squares[y][x] = SquareType.OUTSIDE;
                }
                else {
                    this.squares[y][x] = SquareType.EMPTY;
                }
            }
        }
        this.score = 0;
        this.falling = null;
        this.setFallingPos(0,0);
        this.isGameOver = false;
        this.notifyListeners();

    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getScore() {
        return score;
    }

    public SquareType getSquareType(int x, int y){
        return squares[y + MARGIN][x + MARGIN];
    }
    public void setSquareType(int x, int y, SquareType squareType){
        squares[y + MARGIN][x + MARGIN] = squareType;
    }
    public SquareType getVisibleSquareAt(int x, int y){
        SquareType visibleSquare = SquareType.EMPTY;
        if (falling != null){
            int fallingX1 = fallingPos.x;
            int fallingX2 = fallingPos.x + falling.getSize() - 1;
            int fallingY1 = fallingPos.y;
            int fallingY2 = fallingPos.y + falling.getSize() - 1;


            if (fallingX1 <= x && x <= fallingX2){
                if (fallingY1 <= y && y <= fallingY2){
                    int relativeX = x - fallingX1;
                    int relativeY = y - fallingY1;
                    visibleSquare = falling.getSquare(relativeX, relativeY);
                }
            }
        }

        if (visibleSquare == SquareType.EMPTY){
            visibleSquare = this.getSquareType(x,y);
        }
        return visibleSquare;
    }

    public void randomizeBoard(){
        for (int x = 0; x < this.getWidth(); x++ ){
            for (int y = 0; y < this.getHeight(); y++ ){
                squares[y][x] = SquareType.values()[rndGen.nextInt(8)];
            }
        }
        this.notifyListeners();
    }
    public void addBoardListener(BoardListener boardListener){
        this.boardListeners.add(boardListener);
    }
    // Functions that triggers listeners in listener list
    private void notifyListeners(){
        if(!boardListeners.isEmpty()) {
            for (BoardListener listener : boardListeners) {
                listener.boardChanged();
            }
        }
    }
    private void setFalling(final Poly falling) {
        this.falling = falling;
    }
    private void setFallingPos(int x, int y) {
        this.fallingPos.setLocation(x,y);
    }


    public Poly getFalling() {
        return falling;
    }

    public Point getFallingPos() {
        return fallingPos;
    }

    // Returns -1 if it sticks out to the left
    // Returns 0 if rotation is legal
    // Returns 1 if illegal rotation out to the right
    private int hasDoneIllegalRotation(){
        for (int y = 0; y < falling.getSize(); y++){
            for (int x = 0; x < falling.getSize(); x++){
                SquareType fallingBlock = falling.getSquare(x,y);
                SquareType boardBlock = getSquareType(fallingPos.x + x, fallingPos.y + y);
                if (fallingBlock != SquareType.EMPTY && boardBlock == SquareType.OUTSIDE) {
                    System.out.println(fallingPos.x + x);
                    if (fallingPos.x + x < MARGIN + 1){
                        return -1;
                    } else if (fallingPos.x + x > this.width - 1) {
                        System.out.println(1);
                        return 1;
                    }



                }

            }
        }
        return 0;
    }

    //Places down falling block on board
    private void placeFallingBlock(){
        for (int y = 0; y < falling.getSize(); y++){
            for (int x = 0; x < falling.getSize(); x++){
                SquareType fallingBlock = falling.getSquare(x,y);
                SquareType boardBlock = getSquareType(fallingPos.x + x, fallingPos.y + y);
                if (fallingBlock != SquareType.EMPTY){
                    setSquareType(fallingPos.x + x,fallingPos.y + y,fallingBlock);
                }
            }
        }
        falling = null;
    }

    /* Under one in-game tick board those this:
    Save old pos for collision test
    Check if new positions is illegal with collision handler
    if last collison was illegal then move back to old pos and place block
    if no block is falling then generate new block
    if no block is falling then calculate if rows should be deleted, then remove that amount of rows
    If rows are removed, then add that amount of ponts
    Then notify listeners
     */

    public void tick() {

        if (!isGameOver) {
            Point oldPos = new Point(fallingPos.x, fallingPos.y);
            if (falling != null) {
                setFallingPos(fallingPos.x, fallingPos.y + 1);
                if (fallHandler.hasCollision(this, oldPos) ) {
                    setFallingPos(fallingPos.x, fallingPos.y - 1);
                    placeFallingBlock();

                }

            }
            else {

                setFalling(TetrominoMaker.getPoly(rndGen.nextInt(NUMBER_OF_POLYS)));
                blocksPlaced++;
                //Every 10 blocks a fall through handler is enabled
                if (blocksPlaced%10 == 0){
                    fallHandler = new FallThroughHandler();
                }
                else{
                    fallHandler = new DefaultHandler();
                }
                setFallingPos(this.width / 2 - falling.getSize() + MARGIN, 0);
                if (fallHandler.hasCollision(this, oldPos)) {
                    isGameOver = true;

                }
                else {
                    int pointCounter = 0;
                    for (int y = 2; y < this.height + MARGIN; y++){
                        SquareType[] row = squares[y];
                        boolean rowIsFull = true;
                        for(SquareType squareType: row){
                            if (squareType == SquareType.EMPTY){
                                rowIsFull = false;
                                break;
                            }
                        }
                        if (rowIsFull){
                            forceDownBoard(y);
                            pointCounter++;
                        }
                    }
                    if (pointCounter > 0){
                        System.out.println(pointCounter);
                        addToScore(pointCounter);
                    }
                }
            }
            notifyListeners();
        }

    }
    /*
    Forces down board to index
     */
    private void forceDownBoard(int toIndex){
        for (int y = toIndex - MARGIN; y != 0; y--){
            for (int x = 0; x < this.width; x++){
                this.setSquareType(x,y, this.getSquareType(x,y-1));
            }
        }
        for (int x = 0; x < this.width; x++){
            this.setSquareType(x, 0, SquareType.EMPTY);
        }
    }
    //NOT implemented
    public void forceDownPartOFBoard(int fromY, int toY, int fromX, int toX){
        for (int y = toY - MARGIN; y != 0; y--){
            for (int x = fromX; x < toX + 1; x++){
                this.setSquareType(x,y, this.getSquareType(x,y-1));
            }
        }
        for (int x = fromX; x < toX + 1; x++){
            this.setSquareType(x, fromY, SquareType.EMPTY);
        }
    }
    // MOVES falling to direction and checks if move is illegal
    public void  move(Direction direction){
        if (falling != null){
            int status = 0;
            Point oldPos = new Point(fallingPos.x, fallingPos.y);
            switch (direction){
                case LEFT:
                    setFallingPos(fallingPos.x - 1, fallingPos.y);
                    if (fallHandler.hasCollision(this, oldPos)){
                        setFallingPos(fallingPos.x + 1, fallingPos.y);
                    }
                    break;
                case RIGHT:
                    setFallingPos(fallingPos.x + 1, fallingPos.y);
                    if (fallHandler.hasCollision(this, oldPos)){
                        setFallingPos(fallingPos.x - 1, fallingPos.y);
                    }
                    break;
                case DOWN:
                    setFallingPos(fallingPos.x, fallingPos.y + 1);
                    if (fallHandler.hasCollision(this, oldPos)){
                        setFallingPos(fallingPos.x, fallingPos.y - 1);
                    }
                    break;
                case ROTATE_LEFT:
                    falling = falling.rotate(false);
                    status = hasDoneIllegalRotation();
                    break;
                case ROTATE_RIGHT:
                    falling = falling.rotate(true);
                    status = hasDoneIllegalRotation();
                    break;

                }
                while(status != 0){
                    if (status == 1){
                        setFallingPos(fallingPos.x - 1, fallingPos.y);
                    } else if (status == -1) {
                        setFallingPos(fallingPos.x + 1, fallingPos.y);

                    }
                    status = hasDoneIllegalRotation();
            }
        }
        notifyListeners();
    }
    // Adds to score according to pointmap
    public void addToScore(int amountOfRowsCleared){
        this.score += pointMap.get(amountOfRowsCleared);
    }
    public static void main(String[] args) {
        Board brade = new Board(8,8, new Random());
        brade.squares[3][3] = SquareType.S;
        brade.falling = TetrominoMaker.getPoly(1);
        brade.fallingPos = new Point(1,1);
        BoardTextConverter conv = new BoardTextConverter();
        System.out.println(conv.convertToText(brade));
        brade.fallingPos = new Point(1,2);
        System.out.println(conv.convertToText(brade));
    }
}
