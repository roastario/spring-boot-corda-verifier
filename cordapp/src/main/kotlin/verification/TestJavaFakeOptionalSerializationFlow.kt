package verification

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.utilities.ProgressTracker
import java.util.*


@StartableByRPC
@InitiatingFlow
class TestJavaFakeCommsWithOptionalFlowInitiator(val item: FakeOptionalJava<String>) : FlowLogic<String>() {

    object UNPACKING : ProgressTracker.Step("UNPACKING")
    object RESPONDING : ProgressTracker.Step("RESPONDING")

    override val progressTracker: ProgressTracker = ProgressTracker(UNPACKING, RESPONDING)

    @Suspendable
    override fun call(): String {
        progressTracker.currentStep = UNPACKING
        progressTracker.currentStep = RESPONDING
        return if (item.isPresent()) {
            item.item!!
        } else {
            "empty"
        }
    }

}
