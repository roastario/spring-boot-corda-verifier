package verification

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.utilities.ProgressTracker
import java.util.*


@StartableByRPC
@InitiatingFlow
class KotlinInboundAndOutboundGenericFlow(val inbound: FakeOptional<String>) : FlowLogic<FakeOptional<Map<String?, Int>>>() {

    object UNPACKING : ProgressTracker.Step("UNPACKING")
    object RESPONDING : ProgressTracker.Step("RESPONDING")

    override val progressTracker: ProgressTracker = ProgressTracker(UNPACKING, RESPONDING)

    @Suspendable
    override fun call(): FakeOptional<Map<String?, Int>> {
        progressTracker.currentStep = UNPACKING
        progressTracker.currentStep = RESPONDING
        val outBound = FakeOptional(mapOf(inbound.item to Random().nextInt()))
        return outBound
    }

}
