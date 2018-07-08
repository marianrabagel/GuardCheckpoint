package com.rabagel.marian.guardcheckpoint.Login;

import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;
import com.rabagel.marian.guardcheckpoint.Login.Contracts.ILoginView;

public class LoginPresenter {

    private final ILoginView loginView;
    private final IRequestHandler requestHandler;
    private int loginAttempt;

    public LoginPresenter(ILoginView loginView, IRequestHandler requestHandler){
        this.loginView = loginView;
        this.requestHandler = requestHandler;
    }

    private int incrementLoginAttempt(){
        return ++loginAttempt;
    }

    private boolean hasRights(String userName, String password) {
        if(userName == null || userName.trim().isEmpty()){
            throw new IllegalArgumentException("username or password is null");
        }
        if(password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("username or password is null");
        }

        return requestHandler.getPostResponse(userName, password);
    }

    public void doLogin(String userName, String password) {
        incrementLoginAttempt();

        if (!hasRights(userName, password)) {
            loginView.showErrorMessageForIncorrectUser();
            return;
        }

        loginView.showLoginSuccessMessage();
    }
}
