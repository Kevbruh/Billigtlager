package com.example.billigtlager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText signUpEmail;
    TextInputEditText signUpPass;
    TextInputEditText signUpConfirmPass;
    Button btnRegister;
    TextView tvLoginHere;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPass = findViewById(R.id.signUpPass);
        signUpConfirmPass = findViewById(R.id.signUpConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginHere = findViewById(R.id.tvLoginHere);

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view ->{
            createUser();
        });

        tvLoginHere.setOnClickListener(view ->{
            startActivity(new Intent(this, LoginActivity.class));
        });
    }

    private void createUser(){
        String email = signUpEmail.getText().toString();
        String password = signUpPass.getText().toString();
        String confirmPassword = signUpConfirmPass.getText().toString();

        if (TextUtils.isEmpty(email)){
            signUpEmail.setError("Email cannot be empty");
            signUpEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            signUpPass.setError("Password cannot be empty");
            signUpPass.requestFocus();
        }else if (TextUtils.isEmpty(confirmPassword)) {
            signUpConfirmPass.setError("Confirm password is required");
            signUpConfirmPass.requestFocus();
        } else if (!password.equals(confirmPassword)) {
            signUpConfirmPass.setError("Passwords are not matching");
            signUpConfirmPass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}