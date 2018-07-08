package com.rabagel.marian.guardcheckpoint.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rabagel.marian.guardcheckpoint.Communication.RequestHandler;
import com.rabagel.marian.guardcheckpoint.Login.Contracts.ILoginView;
import com.rabagel.marian.guardcheckpoint.R;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private EditText userName;
    private EditText password;
    private Button loginButton;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializePresenter();
        initializeViews();
    }

    private void initializeViews() {
        userName = findViewById(R.id.user_name_textBox);
        password = findViewById(R.id.password_textBox);
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener((View view) ->
                loginPresenter.doLogin(userName.getText().toString(), password.getText().toString()));
    }

    private void initializePresenter() {
        RequestHandler requestHandler = new RequestHandler(this);
        loginPresenter = new LoginPresenter(this, requestHandler);
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(loginButton, R.string.LoginSuccessfulMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForIncorrectUser() {
        Snackbar.make(password, R.string.IncorrectUserError, Snackbar.LENGTH_LONG).show();
    }
}
