package se.liu.malha079.tetris;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Main class for the tetris game.
 */
public class TetrisMain
{
    public static void main(String[] args) {
	Gson gson = new Gson();
	HighscoreList highscoreList = new HighscoreList();
	Random rndGen = new Random();
	Board board = new Board(10,20, rndGen);
	TetrisViewer viewer = new TetrisViewer(board, highscoreList);
	StepMaker stepMaker = new StepMaker(viewer, board);
	boolean attempt = true;
	while (attempt){
	    try (FileReader fileReader = new FileReader("resources/highscores.json")) {
		highscoreList = gson.fromJson(fileReader, HighscoreList.class);
		viewer.setHighScores(highscoreList);
		attempt = false;

	    }
	    catch (IOException e) {
		attempt = viewer.errorOccurred();

	    }

	}

	viewer.show();
	stepMaker.startTimer();

    }
}