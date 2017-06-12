package Year_1.Dev02_4;

/*
 This interface may be used for describing the specifics
 of how each GUI element should be drawn
 */

interface IDrawVisitor {

    void drawButton(Button element);

    void drawLabel(Label element);

    void drawInput(Input element);

    void drawGUI(GUIManager gui);
}
