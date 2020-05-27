package com.springboot.docker.service;

import org.lognet.springboot.grpc.GRpcService;

import com.springboot.docker.grpc.GreeterGrpc;
import com.springboot.docker.grpc.GreeterOuterClass.HelloReply;
import com.springboot.docker.grpc.GreeterOuterClass.HelloRequest;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@GRpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        log.info("grpc callled");
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
