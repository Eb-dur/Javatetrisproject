package se.liu.malha079.tetris;

import javax.swing.*;

/**
 * The JMenuItem responsible of showing score
 * @param board: the board the componenet are responsible to show the score of
 */
public class ScoreComponent extends JMenuItem implements BoardListener
{
    private Board board;
    @Override public void boardChanged() {
	setText(Integer.toString(board.getScore()));
    }

    public ScoreComponent(final Board board) {
	super("0");
	this.board = board;
    }
}
