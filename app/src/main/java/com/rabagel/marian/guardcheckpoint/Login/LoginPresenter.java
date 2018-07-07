package com.rabagel.marian.guardcheckpoint.Login;

import com.rabagel.marian.guardcheckpoint.Login.Contracts.ILoginView;

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final ILoginView loginView;
    private int loginAttempt;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }

    public int incrementLoginAttempt(){
        return ++loginAttempt;
    }

    public boolean isLoginAttemptExceeded(){
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }

    public boolean isLoginSuccessFull(String userName, String password) {
        if(isLoginAttemptExceeded()){
            return false;
        }

        incrementLoginAttempt();

        return hasRights(userName, password);

    }

    private boolean hasRights(String userName, String password) {
        return userName.equals("marian") && password.equals("android");
    }

    public void doLogin(String userName, String password) {
        if(isLoginAttemptExceeded()){
            loginView.showErrorMessageForMaxLoginAttempts();
        }

        if(hasRights(userName, password)){
            loginView.showLoginSuccessMessage();
            return;
        }

        incrementLoginAttempt();
        loginView.showErrorMessageForIncorrectUser();
    }
}
