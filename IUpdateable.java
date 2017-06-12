package Year_1.Dev02_4;

// Any updatable GUI element should implement this interface

public interface IUpdateable {
    // TODO: ADD MISSING CODE HERE

    void update(IUpdateVisitor visitor, float dt);
}
