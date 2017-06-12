package Year_1.Dev02_4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FXDrawingAdapter implements IDrawingManager {

    private GraphicsContext gc;
    private Font font;

    public FXDrawingAdapter (GraphicsContext gc) {
        this.gc = gc;
        this.font = new Font("Arial", 30);
    }

    // Converts a framework-agnostic color into a JavaFX color
    private Color convertColor(CustomColor color) {
        switch (color) {
            case BLACK:
                return Color.BLACK;
            case WHITE:
                return Color.WHITE;
            case BLUE:
                return Color.BLUE;
            default:
                return Color.YELLOW;
        }
    }

    public void drawRectangle(Point top_left, float width, float height, CustomColor color) {
        gc.setFill(convertColor(color));
        gc.fillRect(top_left.getX(), top_left.getY(), width, height);
    }

    public void drawString(String text, Point top_left, int size, CustomColor color) {
        gc.setFont(new Font(font.getName(), size));
        gc.setFill(convertColor(color));
        gc.fillText(text, top_left.getX(), top_left.getY() + gc.getFont().getSize());
    }
}
