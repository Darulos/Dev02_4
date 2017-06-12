package Year_1.Dev02_4;


// Describes a concrete visitor containing methods for updating each GUI element

public class DefaultUpdateVisitor implements IUpdateVisitor {

    IInputManager inputManager;

    public DefaultUpdateVisitor(IInputManager inputManager) {
        this.inputManager = inputManager;
    }

    public void updateButton(Button element, float dt) {
        inputManager.click().visit(() -> element.color = CustomColor.WHITE, position -> {//TODO: ADD MISSING CODE HERE
            //TODO: ADD MISSING CODE HERE
            if (element.contains(position)) {
                element.color = CustomColor.BLUE;
                element.action.run();
            }
        });
    }

    @Override
    public void updateLabel(Label element, float dt) {
        // Label doesn't require any update logic at this time
    }

    public void updateInput(Input element, float dt) {

    }

    @Override
    public void updateGUI(GUIManager guiManager, float dt) {
        //TODO: ADD MISSING CODE HERE
        guiManager.elements.reset();
        while (guiManager.elements.getNext().visit(() -> false, element -> true)) {
            guiManager.elements.getCurrent().visit(() -> {}, element -> element.update(this, dt));
        }
    }
}
