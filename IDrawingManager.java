package Year_1.Dev02_4;


public interface IDrawingManager {

    void drawRectangle(Point top_left, float width, float height, CustomColor color);

    void drawString(String text, Point top_left, int size, CustomColor color);
}
