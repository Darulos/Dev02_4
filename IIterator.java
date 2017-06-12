package Year_1.Dev02_4;

// Describes a common interface for iterating over collections

interface IIterator<T> {//TODO: ADD MISSING CODE
    IOption<T> getNext();
    IOption<T> getCurrent();
    void reset();
}
