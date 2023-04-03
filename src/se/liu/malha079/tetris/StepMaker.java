package se.liu.malha079.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StepMaker
{
    final private TetrisViewer viewer;
    private int delay = 1000;
    private final Action doOneStep;
    private final static int MAX_SPEED = 250;
    public void startTimer(){
	final Timer clockTimer = new Timer(delay, doOneStep);
	final Timer speedTimer = new Timer(30000, new AbstractAction()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
		if (delay > MAX_SPEED){
		    delay -= 50;
		    clockTimer.setDelay(delay);
		}


	    }
	});
	clockTimer.setCoalesce(true);
	clockTimer.start();
	speedTimer.setCoalesce(true);
	speedTimer.start();
    }

    public StepMaker(final TetrisViewer viewer, Board board) {
	this.viewer = viewer;
	doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    // Gå ett steg i spelet!
		if (!viewer.isPaused()){
		    board.tick();
		}
	    }
	};

    }
}


