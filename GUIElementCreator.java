package Year_1.Dev02_4;


public abstract class GUIElementCreator {
    //TODO: ADD MISSING CODE HERE
    public abstract IGUIElement instantiate(String text, Point top_left, int size, CustomColor color);
    public abstract IGUIElement instantiate(String text, Point top_left, int size, CustomColor color, float width, float height, Runnable action);
}
