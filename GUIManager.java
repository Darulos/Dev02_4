package Year_1.Dev02_4;

/*
 Describes a class controlling the update and
 draw behaviour all GUI elements
 */

public class GUIManager implements IUpdateable, IDrawable{

    public ListIterator<GUIElement> elements;

    public void draw (IDrawVisitor visitor) {
        visitor.drawGUI(this);
    }

    public void update(IUpdateVisitor visitor, float dt) {
        //TODO: ADD MISSING CODE HERE
        visitor.updateGUI(this, dt);
    }
}
