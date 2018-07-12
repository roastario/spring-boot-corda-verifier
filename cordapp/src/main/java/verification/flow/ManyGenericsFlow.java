package verification.flow;

import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.StartableByRPC;
import verification.FakeOptional;
import verification.OtherGenericThing;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@StartableByRPC
public class ManyGenericsFlow extends FlowLogic<String> {

    private final String string1;
    private final FakeOptional<String> fakeOptional;
    private final List<Optional<List<FakeOptional<List<OtherGenericThing<String, BigInteger>>>>>> realOptionalMess;

    public ManyGenericsFlow(String string1, FakeOptional<String> fakeOptional, List<Optional<List<FakeOptional<List<OtherGenericThing<String, BigInteger>>>>>> realOptionalMess) {
        this.string1 = string1;
        this.fakeOptional = fakeOptional;
        this.realOptionalMess = realOptionalMess;
    }


    @Override
    public String call() throws FlowException {
        return string1 + fakeOptional.getItem() + realOptionalMess.stream().flatMap((it) -> it.get().stream()).flatMap((it) -> Objects.requireNonNull(it.getItem()).stream()).flatMap((it) -> it.getItems().stream());
    }
}
