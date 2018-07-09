package verification

import net.corda.core.serialization.CordaSerializable

@CordaSerializable
class FakeOptional<T : Any>(val item: T?) {


    fun isPresent(): Boolean {
        return item != null
    }

    fun get(): T? {
        return item
    }

}