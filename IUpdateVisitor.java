package Year_1.Dev02_4;

/*
 This interface may be used for describing the specifics
 of how each GUI element should be updated
 */

public interface IUpdateVisitor {
    //TODO: ADD MISSING CODE

    void updateButton(Button element, float dt);

    void updateLabel(Label element, float dt);

    void updateGUI(GUIManager gui, float dt);
}
