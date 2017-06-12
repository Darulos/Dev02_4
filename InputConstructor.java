package Year_1.Dev02_4;


public class InputConstructor extends GUIElementCreator {

    @Override
    public Input instantiate(String text, Point top_left, int size, CustomColor color) {
        return new Input(text, top_left, size, color);
    }

    @Override
    public Input instantiate(String text, Point top_left, int size, CustomColor color, float width, float height, Runnable action) {
        return new Input(text, top_left, size, color, width, height);
    }
}