package Year_1.Dev02_4;


public abstract class GUIDecorator extends GUIElement implements IDrawable, IUpdateable// TODO: Missing code
{
    public Point top_left;
    public GUIElement label;

    public GUIDecorator(Point top_left, String text, int size, CustomColor color) {
        super(top_left);
        this.top_left = top_left;
        this.label = new LabelConstructor().instantiate(text, top_left, size, color);
    }

    @Override
    public abstract void draw(IDrawVisitor visitor);

    @Override
    public abstract void update(IUpdateVisitor visitor, float dt);
}
