package Year_1.Dev02_4;


// Describes a label GUI element

public class Label implements IGUIElement{

    public String content;
    public int size;
    public CustomColor color;
    public Point top_left;

    public Label(String content, Point top_left, int size, CustomColor color) {
        this.size = size;
        this.color = color;
        this.top_left = top_left;
        this.content = content;
    }

    public void draw(IDrawVisitor visitor) {
        //TODO: ADD MISSING CODE HERE
        visitor.drawLabel(this);
    }

    public void update(IUpdateVisitor visitor, float dt) {
        // Label doesn't require any update at this time
    }
}
