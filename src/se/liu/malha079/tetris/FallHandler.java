package se.liu.malha079.tetris;

import java.awt.*;

public interface FallHandler
{
    boolean hasCollision(Board board, Point oldPosition);

}
