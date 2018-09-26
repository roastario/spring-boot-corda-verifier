package verification

import net.corda.core.serialization.CordaSerializable

@CordaSerializable
class VeryGenericObjectKotlin<S, T, V>(private val items1: List<S>, private val items2: List<T>, private val items3: List<V>) {

    override fun toString(): String {
        return "VeryGenericObjectJava{" +
                "items1=" + items1 +
                ", items2=" + items2 +
                ", items3=" + items3 +
                '}'.toString()
    }
}
