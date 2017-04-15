package com.example.sumit_thakur.emex.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumit_thakur.emex.Adapter.RecyclerViewAdapter;
import com.example.sumit_thakur.emex.Constants.Constants;
import com.example.sumit_thakur.emex.Model.JobHistoryModel;
import com.example.sumit_thakur.emex.R;

import java.util.ArrayList;

/**
 * Job Fragment
 */
public class JobFragment extends Fragment implements Constants {
    private ArrayList<JobHistoryModel> jobInfos;
    private JobHistoryModel jobHistoryModel;
    private RecyclerView recyclerView;
    private String jobHistory;


    /**
     * @param jobHistory code
     */
    public JobFragment(final String jobHistory) {
        this.jobHistory = jobHistory;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_job_fragment, container, false);
        init();
        if (jobHistory.equals(JOB_HISTORY)) {
            jobInfos.add(jobHistoryModel);
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), jobInfos, JOB_HISTORY);
            recyclerViewCommon(view, recyclerViewAdapter);
        } else {
            jobInfos.add(jobHistoryModel);
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), jobInfos, MISSED_JOB);
            recyclerViewCommon(view, recyclerViewAdapter);
        }
        return view;
    }

    /**
     * @param view                view
     * @param recyclerViewAdapter recycler view adapter
     */
    private void recyclerViewCommon(final View view, final RecyclerViewAdapter recyclerViewAdapter) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rvJobHistory);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    /**
     * initilization
     */
    private void init() {
        jobInfos = new ArrayList<>();
        jobHistoryModel = new JobHistoryModel("Sumit Thakur", "55.5 km",
                "14 June, 2016 04:23 PM", "3846 W 38 Rd, Shiv Srishti Marg Mumbai",
                "Silver Oks Hospital, Laxmi Nagar,Mumbai", "20 min", "1870");
    }

    @Override
    public void extra() {

    }
}
