package Year_1.Dev02_4;


// The base class of each GUI element
public abstract class GUIElement implements IDrawable, IUpdateable {
    public Point top_left;

    public GUIElement(Point top_left) {
        this.top_left = top_left;
    }

    @Override
    public abstract void draw(IDrawVisitor visitor);

    @Override
    public abstract void update(IUpdateVisitor visitor, float dt);
}