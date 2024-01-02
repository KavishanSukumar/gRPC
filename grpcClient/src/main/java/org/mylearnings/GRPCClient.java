package org.mylearnings;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.mylearnings.grpc.User;
import org.mylearnings.grpc.userGrpc;

/*
Stubs- sould be generated through proto files
 */
public class GRPCClient {
    public static void main(String[] args) {
      ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        userGrpc.userBlockingStub userStub=userGrpc.newBlockingStub(managedChannel);
        User.LoginRequest request= User.LoginRequest.newBuilder().setUsername("Kavishan").setPassword("Kavishan").build();
        User.APIResponse response= userStub.login(request);
        System.out.println(response.getResponsemessage());
    }
}
