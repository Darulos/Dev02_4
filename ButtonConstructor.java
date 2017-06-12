package Year_1.Dev02_4;


// Describes a concrete GUIElementCreator that makes buttons

public class ButtonConstructor extends GUIElementCreator {

    @Override
    public Button instantiate(String text, Point top_left, int size, CustomColor color) {
        return new Button(text, top_left, size, color);
    }

    @Override
    public Button instantiate(String text, Point top_left, int size, CustomColor color, float width, float height, Runnable action) {
        return new Button(text, top_left, size, color, width, height, action);
    }
}
