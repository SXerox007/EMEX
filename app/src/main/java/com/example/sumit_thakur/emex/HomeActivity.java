package com.example.sumit_thakur.emex;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumit_thakur.emex.Fragment.JobHistoryFragment;

/**
 * Home Screen Activity
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ImageView ivButtonMenu;
    private TextView tvJobHistory, tvTitle;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private JobHistoryFragment jobHistoryFragment;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        tvJobHistory.setOnClickListener(this);
        tvTitle.setText("Job History");
        ivButtonMenu.setImageResource(R.drawable.ic_menu_button);
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
        jobHistoryFragment = new JobHistoryFragment();
        tvTitle = (TextView) findViewById(R.id.toolbar_title);
    }

    @Override
    public void onClick(final View v) {
        drawerLayout.closeDrawer(Gravity.START);
        int id = v.getId();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (id) {
            case R.id.tvJobHistoryTextView:
                tvJobHistory.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragmentTransaction.replace(R.id.flHomeActivity, jobHistoryFragment);
                fragmentTransaction.commit();
                break;
            default:
                break;
        }
    }
}
