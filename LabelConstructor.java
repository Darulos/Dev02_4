package Year_1.Dev02_4;


// Describes a concrete GUIElementCreator that makes labels

public class LabelConstructor extends GUIElementCreator {
    //TODO: ADD MISSING CODE HERE
    @Override
    public GUIElement instantiate(String text, Point top_left, int size, CustomColor color) {
        return new Label(text, top_left, size, color);

    }

    @Override
    public GUIElement instantiate(String text, Point top_left, int size, CustomColor color, float width, float height, Runnable action) {
        return new Label(text, top_left, size, color);
    }
}
