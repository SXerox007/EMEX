package com.example.sumit_thakur.emex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Login Activity
 */
public class LoginActivity extends AppCompatActivity {

    private Button btnLoginPressed;
    private EditText etEmail, etPassword;
    private TextView tvForgetPassword, tvAlreadyHaveAccount;
    private int flag = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btnLoginPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                flag = fieldsCheck();
                if (flag == 1) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * @return flag value that check condition satisfy or not
     */
    private int fieldsCheck() {
        boolean flagValue;
        String userEmail, userPassword;
        userEmail = etEmail.getText().toString();
        userPassword = etPassword.getText().toString();
        if (userEmail.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(getBaseContext(), "All field Mendatatory", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            flagValue = isValidEmail(userEmail);
            if (!flagValue) {
                Toast.makeText(getBaseContext(), "Email not Valid..!!!  Please Enter the valid Email.", Toast.LENGTH_LONG).show();
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * @param email string(Email) Enter by user
     * @return it will return the boolean value this will true or not
     */
    private static boolean isValidEmail(final String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Initilization
     */
    private void init() {
        btnLoginPressed = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etEmailAddress);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvForgetPassword = (TextView) findViewById(R.id.tvForgetPassword);
        tvAlreadyHaveAccount = (TextView) findViewById(R.id.tvDontHaveAccount);
    }

}
