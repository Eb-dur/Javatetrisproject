package se.liu.malha079.tetris;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * List of Highscores
 * Are able to save to JSON and turn into string
 * @method: addNewHigh: adds new highscore
 * @method: save ToJson: Saves the HighscoreList to JSON
 */
public class HighscoreList
{
    private ArrayList<Highscore> highScores = new ArrayList<>();
    private final static String SAVE_PATH = "resources" + File.separator + "highscores.json";

    public HighscoreList() {
    }

    public void addNewHigh(int score, String name){
	Highscore highScore = new Highscore(score, name);
	highScores.add(highScore);
	highScores.sort(new HighscoreComparator());




    }
    public void saveToJSON() throws IOException{
	Gson gson = new Gson();
	FileWriter fileWriter = new FileWriter(SAVE_PATH + ".temp");
    	gson.toJson(this, fileWriter);
	fileWriter.close();
	Files.delete(Paths.get(SAVE_PATH));
	Files.move(Paths.get(SAVE_PATH + ".temp"),
		   Paths.get(SAVE_PATH));
    }



    @Override public String toString() {
	StringBuilder workingString = new StringBuilder();
	for (Highscore highscore: highScores){
	    workingString.append(highscore);
	    workingString.append("\n");
	}
	return workingString.toString();
    }

    public ArrayList<Highscore> getHighScores() {
	return highScores;
    }
}
