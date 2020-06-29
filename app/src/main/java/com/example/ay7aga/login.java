package com.example.ay7aga;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private static final Pattern Password_Pattern= Pattern.compile("^"+
            "(?=.*[0-9])"+
            "(?=.*[a-z])"+
            "(?=.*[A-Z])"+
            "(?=.*[@#$%&+=])"+
            "(?=\\S+$)"+
            ".{6,}"+
            "$" );
    private TextInputLayout email;
    private TextInputLayout password;
    Button button;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        button=findViewById(R.id.bttn);
        button1=findViewById(R.id.bttn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this, Signup.class);
                startActivity(intent);
            }
        });
    }
    private boolean vEmail() {
        String Email = email.getEditText().getText().toString().trim();
        if (Email.isEmpty()) {
            email.setError("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.setError("Please enter a valid email adress ");
            return false;

        } else {
            email.setError(null);
            return true;

        }


    }
    private boolean validatePassword() {
        String Password = password.getEditText().getText().toString().trim();
        if (Password.isEmpty()) {
            password.setError("Field can't be empty");
            return false;

        }else if (!Password_Pattern.matcher(Password).matches()){
            password.setError("Password is too weak");
            return false;
        }



        else {
            password.setError(null);
            return true;

        }


    }
    public void logininput(View v) {
        if (!vEmail()  | !validatePassword()) {

            return;
        }
        String input = "Email" + email.getEditText().getText().toString();
        input += "\n";
        input += "Password" + password.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(login.this,profile.class);
        startActivity(intent);
    }

}
