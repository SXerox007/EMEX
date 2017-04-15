package com.example.sumit_thakur.emex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.sumit_thakur.emex.BaseActivity.BaseActivity;

/**
 * Main Activity of EMEX
 */
public class MainActivity extends BaseActivity {

    private static final int TIME_OUT = 2000, REQUEST_CODE_SIGNUP = 2, REQUEST_CODE_LOGIN = 3;
    private Button btnLogin, btnSignup;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        splashScreen();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnLogin.setVisibility(View.VISIBLE);
                btnSignup.setVisibility(View.VISIBLE);
            }
        }, TIME_OUT);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /**
     * SplashScreen Visibility
     */
    private void splashScreen() {
        btnLogin.setVisibility(View.GONE);
        btnSignup.setVisibility(View.GONE);
    }

    /**
     * Initilization
     */
    private void init() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);
    }
}
