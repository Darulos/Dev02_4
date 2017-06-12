package Year_1.Dev02_4;


// Describes a concrete visitor containing methods for drawing each GUI element

public class DefaultDrawVisitor implements IDrawVisitor //TODO: MISSING CODE HERE
{
    private IDrawingManager drawingManager;

    public DefaultDrawVisitor(IDrawingManager drawingManager) {
        this.drawingManager = drawingManager;
    }

    public void drawButton(Button element) {
        //TODO: ADD MISSING CODE HERE
        drawingManager.drawRectangle(element.top_left, element.width, element.height, element.color);
        element.label.draw(this);
    }

    public void drawLabel(Label element) {
        drawingManager.drawString(element.content, element.top_left, element.size, element.color);
    }

    public void drawInput(Input element) {
        drawingManager.drawRectangle(element.top_left, element.width, element.height, element.color);
    }

    public void drawGUI(GUIManager guiManager) {
        //TODO: ADD MISSING CODE HERE
        guiManager.elements.reset();
        while (guiManager.elements.getNext().visit(() -> false, element -> true)) {
            guiManager.elements.getCurrent().visit(() -> {}, element -> element.draw(this));
        }
    }
}
