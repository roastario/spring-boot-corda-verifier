package verification;

import net.corda.core.serialization.CordaSerializable;

import java.util.List;

@CordaSerializable
public class OtherGenericThing<T, S> {

    private final T item;
    private final List<S> items;

    public boolean isPresent() {
        return item != null;
    }

    public T get() {
        return item;
    }

    public T getItem() {
        return item;
    }

    public OtherGenericThing(T item, List<S> items) {
        this.item = item;
        this.items = items;
    }

    public List<S> getItems() {
        return items;
    }
}
