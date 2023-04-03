package se.liu.malha079.tetris;

public class GameOverListener implements BoardListener
{
    private TetrisViewer viewer;
    public GameOverListener(TetrisViewer viewer) {
        this.viewer = viewer;
    }


    @Override public void boardChanged() {
        if (viewer.getBoard().isGameOver()){
            viewer.showHighscores();
        }
    }
}
