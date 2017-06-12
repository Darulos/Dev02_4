package Year_1.Dev02_4;

import java.util.ArrayList;

// Describes a concrete iterator for array lists
public class ListIterator<T> implements IIterator<T> {
    //TODO: ADD MISSING CODE

    private ArrayList<T> list;
    private int current;

    public ListIterator() {
        this.list = new ArrayList<>();
        reset();
    }

    public void add(T item) {
        this.list.add(item);
    }

    @Override
    public IOption<T> getNext() {
        this.current++;
        if (this.current >= this.list.size())
            return new None<>();
        else
            return new Some<>(this.list.get(this.current));
    }

    @Override
    public IOption<T> getCurrent() {
        return new Some<>(this.list.get(current));
    }

    @Override
    public void reset() {
        this.current = -1;
    }
}
