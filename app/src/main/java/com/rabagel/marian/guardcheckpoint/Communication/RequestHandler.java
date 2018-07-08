package com.rabagel.marian.guardcheckpoint.Communication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rabagel.marian.guardcheckpoint.Communication.Contracts.IRequestHandler;

public class RequestHandler implements IRequestHandler {
    Context context;

    public RequestHandler(Context context){
        this.context = context;
    }

    @Override
    public boolean getPostResponse(String username, String password) {
        boolean isValid = false;

        /*RequestQueue queue = Volley.newRequestQueue(context);
        String url = "htttp://www.test.aaa";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //interpret response --- format?
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })*/

        return isValid;
    }
}
