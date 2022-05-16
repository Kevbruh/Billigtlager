package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText etSignUpEmail;
    TextInputEditText etSignUpPassword;
    Button btnLogin;
    TextView tvRegisterHereLabel;


    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etSignUpEmail = findViewById(R.id.signUpEmail);
        etSignUpPassword = findViewById(R.id.signUpPass);
        btnLogin = findViewById(R.id.btnRegister);
        tvRegisterHereLabel = findViewById(R.id.tvLoginHere);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
        tvRegisterHereLabel.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });


    }

    public void loginUser() {
        String email = etSignUpEmail.getText().toString();
        String password = etSignUpPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etSignUpEmail.setError("Email cannot be empty");
            etSignUpEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etSignUpPassword.setError("Password cannot be empty");
            etSignUpPassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            //  startActivity(new Intent(this, LoginActivity.class));
        }
    }
}