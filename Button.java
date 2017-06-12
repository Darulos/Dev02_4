package Year_1.Dev02_4;


// Describes a button GUI element

public class Button implements IGUIElement{

    public float width;
    public float height;
    public CustomColor color;
    public Label label;
    public Point top_left;
    public Runnable action;

    public Button(String text, Point top_left, int size, CustomColor color) {
        this.color = color;
        this.top_left = top_left;
        this.label = new LabelConstructor().instantiate(text, top_left, size, color);
    }

    public Button(String text, Point top_left, int size, CustomColor color, float width, float height, Runnable action) {
        this(text, top_left, size, color);
        this.width = width;
        this.height = height;
        this.action = action;
    }

    @Override
    public void draw(IDrawVisitor visitor) {
        //TODO: ADD MISSING CODE
        visitor.drawButton(this);
    }

    // Used to check if a point is inside of the bounds of this button
    public boolean contains(Point point) {
        return point.getX() > this.top_left.getX()
                && point.getY() > this.top_left.getY()
                && point.getX() < this.top_left.getX() + this.width
                && point.getY() < this.top_left.getY() + this.height;
    }

    @Override
    public void update(IUpdateVisitor visitor, float dt) {
        //TODO: ADD MISSING CODE
        visitor.updateButton(this, dt);
    }
}
