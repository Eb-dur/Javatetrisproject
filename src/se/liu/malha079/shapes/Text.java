package se.liu.malha079.shapes;

import java.awt.*;
import java.util.Objects;

public class Text extends AbstractShape
{
    private int size;
    private String text;

    public Text(final int x, final int y, final int size, final String text, final Color color) {
        super(x,y,color);
        this.size = size;
        this.text = text;
    }

    @Override public void draw(final Graphics g) {
        g.setColor(color);
        g.setFont(new Font("serif", Font.PLAIN, size));
        g.drawString(text, x, y);
    }

    @Override public String toString() {
        return "Text{" + "x=" + x + ", y=" + y + ", size=" + size + ", text='" + text + '\'' + ", color=" + color + '}';
    }



    public int getSize() {
        return size;
    }

    public String getText() {
        return text;
    }


    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Text text1 = (Text) o;
        return size == text1.size && Objects.equals(text, text1.text);
    }

    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), size, text);
    }
}
