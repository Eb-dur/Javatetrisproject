package se.liu.malha079.tetris;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Class responsible of constructing window, gui parts and managing keyActions
 * @param board: tetris board of the game
 * @param highscoreList: List of highscores
 */
public class TetrisViewer
{
    private TetrisComponent tetrisComponent;
    private JMenuBar menuBar;
    private JFrame frame = null;
    private Board board;
    private ScoreComponent pointShower;
    private HighscoreComponent highscoreComponent = null;

    private HighscoreList highScores;

    private boolean isPaused = false;

    public boolean isPaused() {
	return isPaused;
    }

    private JMenuBar createMenuBar(){
	final JMenuBar bar    = new JMenuBar();
	final JMenuItem quit  = new JMenuItem("Quit");
	final JMenuItem score = new JMenuItem("Score:");
	final JMenuItem retry = new JMenuItem("Retry");
	pointShower = new ScoreComponent(board);
	quit.addActionListener(new ActionListener() {
	    @Override public void actionPerformed(final ActionEvent e) {
		if (JOptionPane.showConfirmDialog(frame, "Quit","", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
		    frame.dispose();
		    System.exit(0);
		}

	    }
	});
	retry.addActionListener(new ActionListener() {
	@Override public void actionPerformed(final ActionEvent e) {
	    if (JOptionPane.showConfirmDialog(frame, "Retry?","", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		showHighscores();
	    }
	}
	});

	bar.add(quit);
	bar.add(score);
	bar.add(pointShower);
	bar.add(retry);
	return  bar;
    }

    public boolean errorOccurred(){
	if (JOptionPane.showConfirmDialog(frame, "Failed to save/load file want to retry?",
					  "Error!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
	    return true;
	}
	else {
	    return false;
	}
    }

    public void showHighscores(){
	String name =
		(String) JOptionPane.showInputDialog(frame, "Enter your name", "Highscore!", JOptionPane.PLAIN_MESSAGE, null, null,
						     null);
	boolean attempt = true;
	highScores.addNewHigh(board.getScore(), name);
	while (attempt) {
	    try {
		highScores.saveToJSON();
		attempt = false;
	    } catch (IOException ex) {
		attempt = errorOccurred();
	    }
	}
	frame.setVisible(false);
	frame.remove(tetrisComponent);
	highscoreComponent = new HighscoreComponent(highScores);
	frame.add(highscoreComponent);
	frame.setVisible(true);
    }
    public void restartGame(){
	frame.setVisible(false);
	frame.remove(highscoreComponent);
	board.restartBoard();
	frame.add(tetrisComponent);
	frame.setVisible(true);

    }
    public void show(){
	frame = new JFrame("Tetris");
	PrePicture prePicture = new PrePicture();
	JComponent rootPane = frame.getRootPane();
	frame.setLayout(new BorderLayout());
	frame.add(menuBar, BorderLayout.NORTH);
	prePicture.showPreGamePicture(frame);
	frame.add(tetrisComponent);
	frame.pack();
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setVisible(true);

	final InputMap in = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "left");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "right");
	in.put(KeyStroke.getKeyStroke("SPACE"),"down");
	in.put(KeyStroke.getKeyStroke("UP"), "rotateLeft");
	in.put(KeyStroke.getKeyStroke("DOWN"),"rotateRight");
	in.put(KeyStroke.getKeyStroke("ENTER"),"continue");
	in.put(KeyStroke.getKeyStroke("P"),"pause");

	final ActionMap act = rootPane.getActionMap();
	act.put("down", new KeyAction("down"));
	act.put("left", new KeyAction("left"));
	act.put("right", new KeyAction("right"));
	act.put("rotateLeft", new KeyAction("rotateLeft"));
	act.put("rotateRight", new KeyAction("rotateRight"));
	act.put("continue", new KeyAction("continue"));
	act.put("pause", new KeyAction("pause"));

    }

    private class KeyAction extends AbstractAction{
	private String action;
	private KeyAction(String s){
		this.action = s;
	}
	@Override public void actionPerformed(final ActionEvent e){
	    if (action.equals("pause")) {
		if (isPaused) {
		    isPaused = false;
		} else {
		    isPaused = true;
		}
	    }
	    if (!isPaused){
		switch (action){
		    case "right":
			board.move(Direction.RIGHT);
			break;
		    case "left":
			board.move(Direction.LEFT);
			break;
		    case "down":
			board.move(Direction.DOWN);
			break;
		    case "rotateRight":
			board.move(Direction.ROTATE_RIGHT);
			break;
		    case "rotateLeft":
			board.move(Direction.ROTATE_LEFT);
			break;
		    case "continue":
			restartGame();
			break;


		}

	    }

	}
    }

    public void setHighScores(final HighscoreList highScores) {
	this.highScores = highScores;
    }

    public void repaint(){
	tetrisComponent.repaint();
    }
    public Board getBoard() {
	return board;
    }

    public TetrisViewer(final Board board, final HighscoreList highScores) {
	this.board = board;
	this.tetrisComponent = new TetrisComponent(board);
	this.highScores = highScores;
	menuBar = createMenuBar();
	board.addBoardListener(this.tetrisComponent);
	board.addBoardListener(this.pointShower);
	board.addBoardListener(new GameOverListener(this));
    }

}
