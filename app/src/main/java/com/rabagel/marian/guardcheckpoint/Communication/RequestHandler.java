package com.rabagel.marian.guardcheckpoint.Communication;

import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;

public class RequestHandler implements IRequestHandler {
    @Override
    public boolean isUserNameAndPasswordValid(String username, String password) {

        if(username == null || username.trim().isEmpty()){
            throw new IllegalArgumentException("username or password is null");
        }
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("username or password is null");
        }
        //volley
        return false;
    }
}
