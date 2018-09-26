package verification;

import net.corda.core.serialization.CordaSerializable;

import java.util.List;

@CordaSerializable
public class VeryGenericObjectJava<S, T, V> {
    private final List<S> items1;
    private final List<T> items2;
    private final List<V> items3;

    public VeryGenericObjectJava(List<S> items1, List<T> items2, List<V> items3) {
        this.items1 = items1;
        this.items2 = items2;
        this.items3 = items3;
    }

    @Override
    public String toString() {
        return "VeryGenericObjectJava{" +
                "items1=" + items1 +
                ", items2=" + items2 +
                ", items3=" + items3 +
                '}';
    }
}
