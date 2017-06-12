package Year_1.Dev02_4;


// Describes a input GUI element

public class Input implements IGUIElement{

    public String content;
    public int size;
    public CustomColor color;
    public Point top_left;
    public float width;
    public float height;

    public Input(String content, Point top_left, int size, CustomColor color) {
        this.size = size;
        this.content = content;
        this.top_left = top_left;
        this.color = color;
    }

    public Input(String content, Point top_left, int size, CustomColor color, float width, float height) {
        this(content, top_left, size, color);
        this.width = width;
        this.height = height;
    }

    public void draw(IDrawVisitor visitor) {
        //TODO: ADD MISSING CODE HERE
        visitor.drawInput(this);
    }

    public void update(IUpdateVisitor visitor, float dt) {
        // TODO: VOEG KEY CODE TOE
        visitor.updateInput(this, dt);
    }
}

