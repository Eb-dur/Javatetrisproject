package se.liu.malha079.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumMap;

/**
 * Component repsonsible for drawing the board.
 * @param board: The board the TertrisComponent are supposed to draw.
 * @see JComponent
 * @see BoardListener
 */
public class TetrisComponent extends JComponent implements BoardListener
{
    private final static EnumMap<SquareType, Color> SQUARE_TYPE_COLOR_ENUM_MAP = createColorMap();
    private final static int SQUARE_SIZE = 20;
    final private Board board;
    public TetrisComponent(final Board board) {
        this.board = board;
    }



    public Board getBoard() {
        return board;
    }

    // Each block should be 4x4 px -> Array consists of a 10x20 blocks of 4 px each
    @Override public Dimension getPreferredSize() {
        return new Dimension(board.getWidth()*SQUARE_SIZE,board.getHeight()*SQUARE_SIZE);
    }

    private static EnumMap<SquareType, Color> createColorMap() {
        EnumMap<SquareType, Color> map = new EnumMap<>(SquareType.class);
        map.put(SquareType.S, Color.RED);
        map.put(SquareType.EMPTY, Color.DARK_GRAY);
        map.put(SquareType.I, Color.GREEN);
        map.put(SquareType.L, Color.BLUE);
        map.put(SquareType.J, Color.YELLOW);
        map.put(SquareType.Z, Color.CYAN);
        map.put(SquareType.O, Color.ORANGE);
        map.put(SquareType.T, Color.BLACK);
        return map;

    }

    @Override public void boardChanged() {
        this.repaint();
    }

    @Override protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final double sizeDouble = SQUARE_SIZE;
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int xMax = board.getWidth() * SQUARE_SIZE;
        int yMax = board.getHeight() * SQUARE_SIZE;
        for (int y = 0; y < yMax; y += SQUARE_SIZE){
            for (int x = 0;x < xMax; x += SQUARE_SIZE ){
                SquareType squareType = board.getVisibleSquareAt(x/SQUARE_SIZE, y/SQUARE_SIZE);
                Color colorOfSquare = SQUARE_TYPE_COLOR_ENUM_MAP.get(squareType);
                double xDouble = x;
                double yDouble = y;
                Shape rect = new Rectangle2D.Double(xDouble,yDouble,sizeDouble,sizeDouble);
                g2d.setColor(colorOfSquare);
                g2d.draw(rect);
                g2d.fill(rect);
            }
        }
    }
}


