package verification.flow;

import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.StartableByRPC;
import verification.FakeOptional;
import verification.FakeOptionalJava;
import verification.VeryGenericObjectJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@StartableByRPC
public class ManyGenericsFlow extends FlowLogic<VeryGenericObjectJava<String, FakeOptionalJava<List<String>>,
        VeryGenericObjectJava<Integer, Float, String>>> {

    private final FakeOptional<String> input;

    public ManyGenericsFlow(FakeOptional<String> input) {
        this.input = input;
    }

    @Override
    public VeryGenericObjectJava<String, FakeOptionalJava<List<String>>, VeryGenericObjectJava<Integer, Float, String>> call() {

        VeryGenericObjectJava<Integer, Float, String> innerGeneric = new VeryGenericObjectJava<>(
                Collections.singletonList(1),
                Collections.singletonList(1.0f),
                Collections.singletonList("One")
        );

        VeryGenericObjectJava<String, FakeOptionalJava<List<String>>, VeryGenericObjectJava<Integer, Float, String>> outerGeneric = new VeryGenericObjectJava<>(
                listOfStrings("hello", "my", "old", "friend"),
                Collections.singletonList(new FakeOptionalJava<>(Collections.singletonList("yessir"))),
                Collections.singletonList(innerGeneric)
        );

        return outerGeneric;
    }


    private List<String> listOfStrings(String... things) {
        return new ArrayList<String>(Arrays.asList(things));
    }
}
