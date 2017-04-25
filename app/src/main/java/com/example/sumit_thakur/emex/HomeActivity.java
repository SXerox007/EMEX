package com.example.sumit_thakur.emex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sumit_thakur.emex.Fragment.HelpFragment;
import com.example.sumit_thakur.emex.Fragment.HomeFragment;
import com.example.sumit_thakur.emex.Fragment.JobHistoryFragment;

/**
 * Home Screen Activity
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ImageView ivButtonMenu;
    private TextView tvJobHistory, tvTitle, tvHelpPressed;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new HomeFragment();
        fragmentTransaction.replace(R.id.flHomeActivity, fragment);
        fragmentTransaction.commit();

        ivButtonMenu.setImageResource(R.drawable.ic_menu_button);
        tvJobHistory.setOnClickListener(this);
        tvHelpPressed.setOnClickListener(this);
        ivButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
    }

    /**
     * initilization
     */
    private void init() {
        drawerLayout = (DrawerLayout) findViewById(R.id.dlUserDrawer);
        ivButtonMenu = (ImageView) findViewById(R.id.backBtn);
        tvJobHistory = (TextView) findViewById(R.id.tvJobHistoryTextView);
        tvTitle = (TextView) findViewById(R.id.toolbar_title);
        tvHelpPressed = (TextView) findViewById(R.id.tvHelp);
        linearLayout = (LinearLayout) findViewById(R.id.llDrawer);
    }

    @Override
    public void onClick(final View v) {
        drawerLayout.closeDrawer(Gravity.START);
        int id = v.getId();
        fragmentManager = getSupportFragmentManager();
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (id) {
            case R.id.tvJobHistoryTextView:
                tvTitle.setText("Job History");
                fragment = new JobHistoryFragment();
                tvJobHistory.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.tvHelp:
                tvTitle.setText("Help");
                fragment = new HelpFragment();
                tvHelpPressed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
            default:
                fragment = null;
                break;
        }
        fragmentTransaction.replace(R.id.flHomeActivity, fragment);
        fragmentTransaction.commit();
    }
}
