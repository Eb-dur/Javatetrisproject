package se.liu.malha079.tetris;

import java.util.Comparator;

public class HighscoreComparator implements Comparator<Highscore>
{
    public HighscoreComparator() {
    }

    @Override public int compare(final Highscore o1, final Highscore o2) {
	if (o1.getScore() > o2.getScore()){
	    return -1;
	} else if (o1.getScore() == o2.getScore()) {
	    return 0;
	} else {
	    return 1;
	}
    }
}
