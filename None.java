package Year_1.Dev02_4;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Consumer;

// Class of a type T that does not hold any concrete data
public class None<T> implements IOption<T> {

    @Override
    public <U> U visit(Supplier<U> onNone, Function<T, U> onSome) {
        return onNone.get();
    }

    @Override
    public void visit(Runnable onNone, Consumer<T> onSome) {
        onNone.run();
    }
}
