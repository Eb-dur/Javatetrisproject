package se.liu.malha079.tetris;

import javax.swing.*;
import java.awt.*;

/**
 * OLD TetrisViewer!!!
 */

public class TetrisViewerOld
{
    private Board board;
    private JTextArea jTextArea;

    private BoardTextConverter converter;




    public void show(){
	JFrame frame = new JFrame("Tetris");
	frame.setLayout(new BorderLayout());
 	jTextArea = new JTextArea(board.getHeight(), board.getWidth());
	frame.add(jTextArea, BorderLayout.CENTER);
	converter = new BoardTextConverter();
	jTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	jTextArea.setText(converter.convertToText(board));
	frame.pack();
	frame.setVisible(true);




    }

    public BoardTextConverter getConverter() {
	return converter;
    }

    public Board getBoard() {
	return board;
    }

    public JTextArea getjTextArea() {
	return jTextArea;
    }

    public TetrisViewerOld(final Board board) {
	this.board = board;
    }


}
