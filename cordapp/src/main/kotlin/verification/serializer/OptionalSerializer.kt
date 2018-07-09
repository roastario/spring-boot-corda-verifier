package verification.serializer

import net.corda.core.serialization.SerializationCustomSerializer
import java.util.*

@Suppress("UNUSED")
class OptionalSerializer : SerializationCustomSerializer<Optional<*>, OptionalSerializer.OptionalProxy> {
    override fun toProxy(obj: Optional<*>): OptionalProxy {
        return if (obj.isPresent) {
            OptionalProxy(obj.get(), obj.get().javaClass)
        } else {
            OptionalProxy(null, Any::class.java)
        }

    }

    override fun fromProxy(proxy: OptionalProxy): Optional<*> {
        return if (proxy.thing == null) {
            Optional.empty<Any>()
        } else {
            Optional.of(proxy.thing)
        }
    }

    data class OptionalProxy(val thing: Any?, val clazz: Class<*>)
}