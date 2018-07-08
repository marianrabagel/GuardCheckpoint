package com.rabagel.marian.guardcheckpoint.Communication;

import android.content.Context;

import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class RequestHandlerTest {
    IRequestHandler requestHandler;
    @Before
    public void setUp() throws Exception {
        Context contextMock = mock(Context.class);
        requestHandler = new RequestHandler(contextMock);
    }

    @After
    public void tearDown() throws Exception {
    }
}