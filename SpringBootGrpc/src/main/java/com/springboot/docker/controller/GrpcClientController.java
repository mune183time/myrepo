package com.springboot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.docker.grpc.GreeterGrpc;
import com.springboot.docker.grpc.GreeterOuterClass.HelloReply;
import com.springboot.docker.grpc.GreeterOuterClass.HelloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/grpcclient")
@RestController
public class GrpcClientController {

    @GetMapping
    public String get(String name) {
        log.info("grpcclient called");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext()
                //.usePlaintext(true)
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .setCommon(HelloRequest.newBuilder().getCommonBuilder().setAtt1("att1").build())
                .build();

        HelloReply reply = stub.sayHello(request);

        System.out.println("Reply: " + reply);

        return reply.getMessage();
    }

}
