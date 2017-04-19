package com.example.sumit_thakur.emex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Forget password activity
 */
public class ForgetPasswordActivity extends AppCompatActivity {
    private Button btnContinuePressed;
    private EditText etcontactNumber;
    private String contactNumber;
    private TextView tvTitle;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        init();
        tvTitle.setText("Forget Password");
        btnContinuePressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (!contactNumber.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Sucessfull Implementation delete this", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getBaseContext(), "Sorry First Fill Contact field.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * initilization
     */
    private void init() {
        btnContinuePressed = (Button) findViewById(R.id.btnContinue);
        etcontactNumber = (EditText) findViewById(R.id.etContactNumber);
        contactNumber = etcontactNumber.getText().toString();
        tvTitle = (TextView) findViewById(R.id.toolbar_title);
    }
}
