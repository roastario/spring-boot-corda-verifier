package com.r3.corda.spring.boot.validation.java;

import net.corda.client.rpc.CordaRPCClient;
import net.corda.core.utilities.NetworkHostAndPort;
import verification.FakeOptionalJava;
import verification.VeryGenericObjectJava;
import verification.flow.ManyGenericsFlow;

import java.util.concurrent.ExecutionException;

public class GoGo {

    public static void main(String[] args) {
        try {
            CordaRPCClient rpcOps = new CordaRPCClient(new NetworkHostAndPort("localhost", 10007));
            rpcOps.use("test", "test", (cordaRPCConnection -> {
                VeryGenericObjectJava thing = null;
                try {
                    thing = cordaRPCConnection.getProxy().startFlowDynamic(ManyGenericsFlow.class, new FakeOptionalJava<>("Aye, Let's go!")).getReturnValue().get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                return thing;
            }));
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

}
