package se.liu.malha079.tetris;

import javax.swing.*;

public class HighscoreComponent extends JTextArea
{

    public HighscoreComponent(final HighscoreList highscores) {

	this.setText(highscores.toString());
    }

}
