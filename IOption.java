package Year_1.Dev02_4;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

// Allows an object to either contain data or not
public interface IOption<T> {

    <U> U visit(Supplier<U> onNone, Function<T, U> onSome);
    void visit(Runnable onNone, Consumer<T> onSome);
}
