package Year_1.Dev02_4;

/*
 A concrete implementation of IInputManager
 Contains specific input logic of JavaFX
 */

public class FXMouse implements IInputManager {
    public IOption<Point> click() {
        //TODO: ADD MISSING CODE HERE
        if (Mouse.isPressedLeft()) {
            return new Some<>(new Point(Mouse.getX(), Mouse.getY()));
        } else {
            return new None<>();
        }
    }
}
