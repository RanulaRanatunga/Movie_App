package com.example.movieapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movieapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText userName , password;
    Button buttonLogin;
    CheckBox showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        userName = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        showPassword = findViewById(R.id.ckbox);

        buttonLogin = findViewById(R.id.btn_login);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("Ranula") && password.getText().toString().equals("123456")) {

                    Intent intent = new Intent(LoginActivity.this,MovieList.class);
                    startActivity(intent);

                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            LoginActivity.this

                    );
                    builder.setIcon(R.drawable.ic_check_);
                    builder.setTitle("Logged In");
                    builder.setMessage("Click Okay");

                    builder.setNegativeButton("OKAY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username and Password" ,Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
