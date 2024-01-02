package org.mylearnings.user;

import io.grpc.stub.StreamObserver;
import org.mylearnings.grpc.User;
import org.mylearnings.grpc.userGrpc;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login");
        String username=request.getUsername();
        String password=request.getPassword();

        User.APIResponse.Builder response=User.APIResponse.newBuilder();
        if (username.equals(password)) {
            response.setResponseeCode(0).setResponsemessage("Success");
        }else {
            response.setResponseeCode(100).setResponsemessage("Invalid username or password");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
