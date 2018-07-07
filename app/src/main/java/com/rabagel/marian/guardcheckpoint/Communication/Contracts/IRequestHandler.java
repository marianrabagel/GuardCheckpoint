package com.rabagel.marian.guardcheckpoint.Communication.Contracts;

public interface IRequestHandler {
    boolean isUserNameAndPasswordValid(String username, String password);
}
