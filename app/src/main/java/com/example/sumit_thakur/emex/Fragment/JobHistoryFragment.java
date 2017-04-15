package com.example.sumit_thakur.emex.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumit_thakur.emex.Constants.Constants;
import com.example.sumit_thakur.emex.R;


/**
 * Job history Fragment
 */
public class JobHistoryFragment extends Fragment implements Constants {
    private ViewPager viewPager;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_job_history_fragment, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpSwipe);


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
}
