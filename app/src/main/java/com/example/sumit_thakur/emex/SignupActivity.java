package com.example.sumit_thakur.emex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * signup screen
 */
public class SignupActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etContactNumber, etContactName, etEmailAddress, etPassword, etConfirmPassword;
    private Button btnSignupPressed;
    private CheckBox cbTermsConditions;
    private int flag = 0;
    private String firstName, lastName, contactNumber, contactName, emailAddress, password, rePassword;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        btnSignupPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                flag = checkConditions();
                if (flag == 1) {
                    Toast.makeText(getBaseContext(), "Sucessfull delete this toast", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * @return return the flag value satisfy the conditions or not
     */
    private int checkConditions() {
        firstName = etFirstName.getText().toString();
        lastName = etLastName.getText().toString();
        contactNumber = etContactNumber.getText().toString();
        contactName = etContactName.getText().toString();
        emailAddress = etEmailAddress.getText().toString();
        password = etPassword.getText().toString();
        rePassword = etConfirmPassword.getText().toString();

        if (firstName.isEmpty() || lastName.isEmpty() || contactName.isEmpty() || contactNumber.isEmpty()
                || emailAddress.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            Toast.makeText(getBaseContext(), "All field Mendatatory", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }

    }

    /**
     * initilization
     */
    private void init() {
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etContactNumber = (EditText) findViewById(R.id.etContactNumber);
        etContactName = (EditText) findViewById(R.id.etContactName);
        etEmailAddress = (EditText) findViewById(R.id.etEmailAddress);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        btnSignupPressed = (Button) findViewById(R.id.btnSignup);
    }
}
