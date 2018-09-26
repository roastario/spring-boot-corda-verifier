package verification

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.utilities.ProgressTracker
import java.util.*


@StartableByRPC
@InitiatingFlow
class JavaInboundAndOutboundGenericFlow(val inbound: FakeOptionalJava<String>) : FlowLogic<FakeOptionalJava<List<String>>>() {

    object UNPACKING : ProgressTracker.Step("UNPACKING")
    object RESPONDING : ProgressTracker.Step("RESPONDING")

    override val progressTracker: ProgressTracker = ProgressTracker(UNPACKING, RESPONDING)

    @Suspendable
    override fun call(): FakeOptionalJava<List<String>> {
        progressTracker.currentStep = UNPACKING
        progressTracker.currentStep = RESPONDING
        val outBound = FakeOptionalJava<List<String>>(listOf("yes I returned", inbound.item))
        return outBound
    }

}
