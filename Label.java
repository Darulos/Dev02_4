package Year_1.Dev02_4;


// Describes a label GUI element

public class Label extends GUIElement{

    public String content;
    public int size;
    public CustomColor color;

    public Label(String content, Point top_left, int size, CustomColor color) {
        super(top_left);
        this.size = size;
        this.color = color;
        this.content = content;
    }

    @Override
    public void draw(IDrawVisitor visitor) {
        //TODO: ADD MISSING CODE HERE
        visitor.drawLabel(this);
    }

    @Override
    public void update(IUpdateVisitor visitor, float dt) {
        // Label doesn't require any update at this time
    }
}
