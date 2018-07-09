package verification

import net.corda.core.serialization.SerializationWhitelist
import java.util.*


class SerializationWhitelistConfig : SerializationWhitelist {

    /** {@inheritDoc}  */
    override val whitelist: List<Class<*>>
        get() = listOf(
                HashSet::class.java,
                MutableSet::class.java,
                Optional::class.java
        )

}
