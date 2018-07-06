package com.rabagel.marian.guardcheckpoint.Login.Contracts;

public interface ILoginView {
    void showErrorMessageForMaxLoginAttempts();
    void showLoginSuccessMessage();
    void showErrorMessageForIncorrectUser();
}
