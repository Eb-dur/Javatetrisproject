package se.liu.malha079.tetris;

/**
 * Highscore class
 * @param name the name of highscore haver
 * @param score the value of score
 */
public class Highscore
{
    private int score;
    private String name = "noname";

    public int getScore() {
	return score;
    }

    public String getName() {
	return name;
    }

    public Highscore() {
    }

    @Override public String toString() {
	return score + " "  + name;
    }

    public Highscore(final int score, final String name) {
	this.score = score;
	this.name = name;
    }

}
