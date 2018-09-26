package verification;

import net.corda.core.serialization.CordaSerializable;

import java.util.List;

@CordaSerializable
public class OtherGenericThing<S> {
    private final List<S> items;
    public OtherGenericThing(List<S> items) {
        this.items = items;
    }
    public List<S> getItems() {
        return items;
    }
}
