package com.rabagel.marian.guardcheckpoint.Login;

import com.rabagel.marian.guardcheckpoint.Login.Contracts.ILoginView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class LoginPresenterTest {
    ILoginView loginView;
    @Before
    public void setUp() {
        loginView = mock(ILoginView.class);
    }

    @Test
    public void isLoginAttemptIsExceededAfterThreeAttemptsReturnsTrue(){

        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void isLoginAttemptIsExceededAfterOneAttemptsReturnsFalse(){
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertTrue(!loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void isLoginSuccessFullForAnExistingUserReturnsTrue(){
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        loginPresenter.isLoginSuccessFull("marian", "android");
    }

    @Test
    public void doLoginWithTheCorrectCredentialsCallsLoginViewShowLoginSuccessMessage(){
        ILoginView loginView = mock(ILoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("marian", "android");

        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void doLoginWithIncorrectCredentialsCallsLoginViewshowErrorMessageForIncorrectUser(){
        ILoginView loginView = mock(ILoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz", "xyz");

        verify(loginView).showErrorMessageForIncorrectUser();
    }

    @Test
    public void doLoginWith3IncorrectCredentialsCallsLoginViewShowErrorMessageForMaxLoginAttempts(){
        ILoginView loginView = mock(ILoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz", "xyz");
        loginPresenter.doLogin("xyz", "xyz");
        loginPresenter.doLogin("xyz", "xyz");
        loginPresenter.doLogin("xyz", "xyz");

        verify(loginView).showErrorMessageForMaxLoginAttempts();
    }

    @After
    public void tearDown() {
    }
}