package com.example.healthcare;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText TextName, TextEmail, TextPassword;
    CheckBox buttonBox;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAuth=FirebaseAuth.getInstance();
        TextName = findViewById(R.id.name_et);
        TextEmail = findViewById(R.id.email_et);
        TextPassword = findViewById(R.id.pass_et);
        buttonBox = findViewById(R.id.cb_box);
        signupButton = findViewById(R.id.btsignup);

        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name,email,password;
                name =String.valueOf(TextName.getText());
                email = String.valueOf(TextEmail.getText());
                password =String.valueOf(TextPassword.getText());


                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SignupActivity.this,"Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(SignupActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(SignupActivity.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, " account ",
                                            Toast.LENGTH_SHORT).show();
                                    // Sign in success, update UI with the signed-in user's information
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignupActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

    }

}