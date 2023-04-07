package grpc.one.dailyfarm;

import java.io.IOException;

import grpc.one.dailyfarm.GreeterGrpc.GreeterImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;

public class dailyFarmServer extends GreeterImplBase{
	
	public static void main(String[] args) {
		
		dailyFarmServer greeterServer = new dailyFarmServer();
		
		int port = 50051;
	
		Server server;
		
		try {
			server = ServerBuilder.forPort(port).addService(greeterServer).build().start();
			System.out.println("This server is working...");
			server.awaitTermination();
			
		} catch (IOException e){
			e.printStackTrace();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		// TODO Auto-generated method stub
		
		System.out.println("----- Is working receiving Hello request from client");
		
		HelloReply reply = HelloReply.newBuilder().setMymessage("Hello there anyone..." + request.getMyname()).build();
		
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
		
		super.sayHello(request, responseObserver);
	
	}
	
	
}
