package verification

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.utilities.ProgressTracker
import java.util.*


@StartableByRPC
@InitiatingFlow
class EmptyTrackerFlow : FlowLogic<String>() {
    override val progressTracker: ProgressTracker = ProgressTracker()
    @Suspendable
    override fun call(): String {
        return "Finished"
    }
}
