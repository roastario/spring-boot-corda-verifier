package com.r3.corda.spring.boot.validation.java;

import net.corda.client.rpc.CordaRPCClient;
import net.corda.core.utilities.NetworkHostAndPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import verification.OtherGenericThing;
import verification.flow.ManyGenericsFlow;

import java.util.concurrent.ExecutionException;

@RestController
public class JavaApi {
    @RequestMapping(path = "javaserialization/madness", method = RequestMethod.GET)
    public final int testJavaRPC() {

        try {
            CordaRPCClient rpcOps = new CordaRPCClient(new NetworkHostAndPort("localhost", 10007));
            return rpcOps.use("test", "test", (cordaRPCConnection -> {
                OtherGenericThing<String> thing = null;
                try {
                    thing = cordaRPCConnection.getProxy().startFlowDynamic(ManyGenericsFlow.class).getReturnValue().get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                return thing.getItems().size();
            }));
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

}
