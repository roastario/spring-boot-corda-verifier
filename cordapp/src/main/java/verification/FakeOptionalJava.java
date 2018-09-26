package verification;

import net.corda.core.serialization.CordaSerializable;

@CordaSerializable
public class FakeOptionalJava<T> {

    private final T item;

    public boolean isPresent() {
        return item != null;
    }

    public T get() {
        return item;
    }

    public T getItem() {
        return item;
    }

    public FakeOptionalJava(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "FakeOptionalJava{" +
                "item=" + item +
                '}';
    }
}
