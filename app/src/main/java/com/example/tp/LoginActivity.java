package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Email,Password;
    private Button Login_button;
    private TextView Forgot_pass, Signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email =findViewById(R.id.email);
        Password=findViewById(R.id.password);
        Login_button=findViewById(R.id.login_button);
        Signup_button=findViewById(R.id.signup_button);

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidateData())
                {
                    login();
                }

            }
        });
    }

    private  boolean ValidateData()
    {

        if (Email.getText().toString().isEmpty())
        {
            Email.setError("ENTER EMAIL ID");
            return false;
        }

        if (Password.getText().toString().isEmpty())
        {
            Password.setError("ENTER PASSWORD");
            return false;
        }

        return true;
    }
    private void login()
    {

    }
}