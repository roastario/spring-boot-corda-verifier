package com.r3.corda.spring.boot.validation

import net.corda.client.rpc.CordaRPCClient
import net.corda.core.utilities.NetworkHostAndPort
import net.corda.core.utilities.getOrThrow
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import verification.*
import java.util.*

@RestController
class Api {
    @RequestMapping(path = ["serialization/optional"], method = [RequestMethod.GET])
    fun testOptional(): String {
        val cordaRPCClient = CordaRPCClient(NetworkHostAndPort("localhost", 10007))
        cordaRPCClient.use("test", "test") {
            return it.proxy.startFlowDynamic(TestCommsWithOptionalFlowInitiator::class.java, Optional.of("This is just a test")).returnValue.getOrThrow()
        }
    }

    @RequestMapping(path = ["serialization/fakeoptional"], method = [RequestMethod.GET])
    fun testFakeOptional(): String {
        val cordaRPCClient = CordaRPCClient(NetworkHostAndPort("localhost", 10007))
        cordaRPCClient.use("test", "test") {
            return it.proxy.startFlowDynamic(KotlinInboundAndOutboundGenericFlow::class.java, FakeOptional("This is just a test")).returnValue.getOrThrow().item.toString()
                    ?: "Empty"
        }
    }

    @RequestMapping(path = ["serialization/javafakeoptional"], method = [RequestMethod.GET])
    fun testJavaFakeOptional(): String {
        val cordaRPCClient = CordaRPCClient(NetworkHostAndPort("localhost", 10007))
        cordaRPCClient.use("test", "test") {
            return it.proxy.startFlowDynamic(JavaInboundAndOutboundGenericFlow::class.java, FakeOptionalJava("This is just a test")).returnValue.getOrThrow().item.joinToString(separator = ", ") { it }
        }
    }
}

data class RpcRequest(val host: String, val port: Int, val user: String = "test", val pass: String = "test")
