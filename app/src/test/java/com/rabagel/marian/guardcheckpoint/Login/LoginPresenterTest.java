package com.rabagel.marian.guardcheckpoint.Login;

import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;
import com.rabagel.marian.guardcheckpoint.Login.Contracts.ILoginView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class LoginPresenterTest {
    ILoginView loginViewMock;
    IRequestHandler requestHandlerMock;
    LoginPresenter loginPresenter;

    @Before
    public void setUp() {

        loginViewMock = mock(ILoginView.class);
        requestHandlerMock = mock(IRequestHandler.class);
        loginPresenter = new LoginPresenter(loginViewMock, requestHandlerMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsNullThrowsIllegalArgumentException(){
        loginPresenter.doLogin(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsNullThrowsIllegalArgumentException(){
        loginPresenter.doLogin(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsEmptyStringThrowsIllegalArgumentException(){
        loginPresenter.doLogin("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsEmptyStringThrowsIllegalArgumentException(){
        loginPresenter.doLogin("test", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsBlankStringThrowsIllegalArgumentException(){
        loginPresenter.doLogin("   ", "   ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsBlankStringThrowsIllegalArgumentException(){
        loginPresenter.doLogin("test", "   ");
    }

    @Test
    public void doLoginCallsRequestHandlerIsUserNameAndPasswordValid(){
        loginPresenter.doLogin("test", "test");

        verify(requestHandlerMock).getPostResponse(anyString(), anyString());
    }

    @Test
    public void doLoginWhenCredentialsAreValidCallsLoginViewShowLoginSuccessMessage(){
        when(requestHandlerMock.getPostResponse(anyString(), anyString())).thenReturn(true);

        loginPresenter.doLogin("test", "test");

        verify(loginViewMock).showLoginSuccessMessage();
    }

    @Test
    public void doLoginWhenCredentialsAreNotValidCallsLoginViewShowErrorMessageForIncorrectUser(){
        when(requestHandlerMock.getPostResponse(anyString(), anyString())).thenReturn(false);

        loginPresenter.doLogin("test", "test");

        verify(loginViewMock).showErrorMessageForIncorrectUser();
    }

    @After
    public void tearDown() {
    }
}