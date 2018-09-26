package verification.flow;

import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.StartableByRPC;
import verification.OtherGenericThing;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@StartableByRPC
public class ManyGenericsFlow extends FlowLogic<OtherGenericThing<String>> {


    private final OtherGenericThing<String> input;

    public ManyGenericsFlow(OtherGenericThing<String> input) {
        this.input = input;
    }

    @Override
    public OtherGenericThing<String> call() {
        return new OtherGenericThing<>(IntStream.of(100).mapToObj((i) -> input.toString() + "" + i).collect(Collectors.toList()));
    }
}
