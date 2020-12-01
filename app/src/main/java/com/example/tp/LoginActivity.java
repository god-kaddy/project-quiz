package com.example.tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText Email,Password;
    private Button Login_button;
    private TextView Forgot_pass, Signup_button;
    private FirebaseAuth mAuth;
    private Dialog progressDailog;
    private TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email =findViewById(R.id.email);
        Password=findViewById(R.id.password);
        Login_button=findViewById(R.id.login_button);
        Signup_button=findViewById(R.id.signup_button);

        progressDailog=new Dialog(LoginActivity.this);
        progressDailog.setContentView(R.layout.dailog_layout);
        progressDailog.setCancelable(false);
        progressDailog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText=progressDailog.findViewById(R.id.dailog_text);
        dialogText.setText("Signing in...");

        mAuth=FirebaseAuth.getInstance();

        

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidateData())
                {
                    login();
                }

            }
        });

        Signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
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

        progressDailog.show();
        mAuth.signInWithEmailAndPassword(Email.getText().toString().trim(), Password.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                            progressDailog.dismiss();
                            Intent intent=new Intent(LoginActivity.this,chooseActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDailog.dismiss();
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            // ...
                        }

                        // ...
                    }
                });

    }
}