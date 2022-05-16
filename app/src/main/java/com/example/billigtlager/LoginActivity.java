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

    TextInputEditText loginEmail;
    TextInputEditText loginPassword;
    Button buttonLogin;
    TextView labelRegisterHere;

    //Firebase authentication
    FirebaseAuth firebaseAuthentication = FirebaseAuth.getInstance();

    //Creating scene
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        firebaseAuthentication = FirebaseAuth.getInstance();

        //Pulling interactive fields/buttons from activity
        loginEmail = findViewById(R.id.LoginEmail);
        loginPassword = findViewById(R.id.LoginPass);
        buttonLogin = findViewById(R.id.btnLogin);
        labelRegisterHere = findViewById(R.id.LabelRegisterHere);

        buttonLogin.setOnClickListener(view -> {
            loginUser();
        });
        labelRegisterHere.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }

    //Login logic
    public void loginUser() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            loginEmail.setError("Email cannot be empty");
            loginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            loginPassword.setError("Password cannot be empty");
            loginPassword.requestFocus();
        } else {
            firebaseAuthentication.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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
        FirebaseUser user = firebaseAuthentication.getCurrentUser();
        if (user == null){
            //  startActivity(new Intent(this, LoginActivity.class));
        }
    }
}