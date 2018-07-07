package com.rabagel.marian.guardcheckpoint.Communication;

import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RequestHandlerTest {
    IRequestHandler requestHandler;
    @Before
    public void setUp() throws Exception {
        requestHandler = new RequestHandler();
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsNullThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsNullThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsEmptyStringThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsEmptyStringThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid("test", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenUserNameIsBlankStringThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid("   ", "   ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isUserNameAndPasswordValidWhenPasswordIsBlankStringThrowsIllegalArgumentException(){
        requestHandler.isUserNameAndPasswordValid("test", "   ");
    }

    @After
    public void tearDown() throws Exception {
    }
}