package verification

import net.corda.core.flows.FlowLogic
import net.corda.core.flows.StartableByRPC

@StartableByRPC
class ManyGenericsFlowKotlin(private val input: FakeOptional<String>) : FlowLogic<VeryGenericObjectKotlin<String, FakeOptional<List<String>>, VeryGenericObjectKotlin<Int, Float, String>>>() {

    override fun call(): VeryGenericObjectKotlin<String, FakeOptional<List<String>>, VeryGenericObjectKotlin<Int, Float, String>> {

        val innerGeneric = VeryGenericObjectKotlin(
                listOf(1),
                listOf(1.0f),
                listOf("One")
        )

        val veryGenericObjectKotlin = VeryGenericObjectKotlin(
                listOf("hello", "from", "kotlin", "my", "old", "friend"),
                listOf(FakeOptional(listOf("yessir")), FakeOptional(listOf("whosir", "is this"))),
                listOf(innerGeneric)
        )
        return veryGenericObjectKotlin
    }
}
