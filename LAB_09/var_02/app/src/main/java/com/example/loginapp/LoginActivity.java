package com.example.loginapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String KEY_LOGIN = "key_login";
    private static final String KEY_PASSWORD = "key_password";

    private EditText etLogin;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);


        if (savedInstanceState != null) {
            etLogin.setText(savedInstanceState.getString(KEY_LOGIN, ""));
            etPassword.setText(savedInstanceState.getString(KEY_PASSWORD, ""));
        }

        btnLogin.setOnClickListener(v -> {
            String login = etLogin.getText().toString().trim();
            String password = etPassword.getText().toString();

            if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Авторизация: " + login, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_LOGIN, etLogin.getText().toString());
        outState.putString(KEY_PASSWORD, etPassword.getText().toString());
    }
}