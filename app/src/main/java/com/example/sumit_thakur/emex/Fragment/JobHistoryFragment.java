package com.example.sumit_thakur.emex.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sumit_thakur.emex.Constants.Constants;
import com.example.sumit_thakur.emex.R;


/**
 * Job history Fragment
 */
public class JobHistoryFragment extends Fragment implements Constants, View.OnClickListener {
    private ViewPager viewPager;
    private Button btnJobHistoryPressed, btnMissedJobPressed;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_job_history_fragment, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpSwipe);
        btnJobHistoryPressed = (Button) view.findViewById(R.id.btnJobHistory);
        btnMissedJobPressed = (Button) view.findViewById(R.id.btnMissedJob);
        btnMissedJobPressed.setOnClickListener(this);
        btnJobHistoryPressed.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    btnJobHistoryPressed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnMissedJobPressed.setBackgroundColor(getResources().getColor(R.color.colorMissedJob));
                } else {
                    btnJobHistoryPressed.setBackgroundColor(getResources().getColor(R.color.colorMissedJob));
                    btnMissedJobPressed.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {
            }
        });


        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new JobFragment(JOB_HISTORY);
                } else {
                    return new JobFragment(MISSED_JOB);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(fragmentStatePagerAdapter);
        return view;
    }

    @Override
    public void extra() {

    }

    @Override
    public void onClick(final View v) {

    }
}
