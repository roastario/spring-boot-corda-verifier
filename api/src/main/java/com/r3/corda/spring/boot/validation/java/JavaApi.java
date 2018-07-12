package com.r3.corda.spring.boot.validation.java;

import net.corda.client.rpc.CordaRPCClient;
import net.corda.core.utilities.NetworkHostAndPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import verification.FakeOptional;
import verification.flow.ManyGenericsFlow;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class JavaApi {
    @RequestMapping(path = "javaserialization/madness", method = RequestMethod.GET)
    public final void testJavaRPC() {

        CordaRPCClient rpcOps = new CordaRPCClient(new NetworkHostAndPort("localhost", 10007));

        rpcOps.use("test", "test", (cordaRPCConnection -> {

            List<Optional<List<FakeOptional<List<String>>>>> optionalMess = IntStream.of(10).mapToObj((k) -> {
                return Optional.of(IntStream.of(10).mapToObj((j) -> {
                    return new FakeOptional<>(IntStream.of(10).mapToObj((i) -> {
                        return "this is element" + i;
                    }).collect(Collectors.toList()));

                }).collect(Collectors.toList()));
            }).collect(Collectors.toList());


            return cordaRPCConnection.getProxy().startFlowDynamic(ManyGenericsFlow.class, "this is the first string ", new FakeOptional<>("this is the fake optional "), optionalMess);

        }));

    }

}
