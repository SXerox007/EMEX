package com.example.sumit_thakur.emex.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sumit_thakur.emex.Constants.Constants;
import com.example.sumit_thakur.emex.Model.JobHistoryModel;
import com.example.sumit_thakur.emex.R;

import java.util.ArrayList;

/**
 * Recycler View Adapter
 */
public class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Constants {

    private Context context;
    private ArrayList<JobHistoryModel> jobInfo;
    private String mode;

    /**
     * @param context get Context of previous activity
     * @param jobInfo Arraylist jobInfo
     * @param mode    mode
     */
    public RecyclerViewAdapter(final Context context, final ArrayList<JobHistoryModel> jobInfo, final String mode) {
        this.context = context;
        this.jobInfo = jobInfo;
        this.mode = mode;

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        context = parent.getContext();
        View convertView;
        convertView = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        JobHistoryModel obj = jobInfo.get(position);
        if (mode.equals(JOB_HISTORY)) {
            //holder.tvDriverNam.setText(obj.getDriverName());
            holder.tvDriverNam.setVisibility(View.GONE);
            holder.tvDriverNameTitle.setVisibility(View.GONE);
            holder.tvAmount.setText(obj.getTotalAmounttoBePaid());
            holder.tvRideTime.setText(obj.getTotalRideTime());
            holder.tvDateTime.setText(obj.getDateAndTime());
            holder.tvDistance.setText(obj.getDistanceCover());
            holder.tvStartAddr.setText(obj.getPickupAddress());
            holder.tvEndAddr.setText(obj.getDestinationAddress());
        } else {
            holder.tvDriverNam.setText(obj.getDriverName());
            holder.tvAmount.setVisibility(View.GONE);
            holder.tvAmountTitle.setVisibility(View.GONE);
            holder.tvRideTime.setVisibility(View.GONE);
            holder.tvRideTimeTitle.setVisibility(View.GONE);
            holder.tvDateTime.setText(obj.getDateAndTime());
            holder.tvDistance.setText(obj.getDistanceCover());
            holder.tvStartAddr.setText(obj.getPickupAddress());
            holder.tvEndAddr.setVisibility(View.GONE);
            holder.view.setVisibility(View.GONE);

        }


    }

    @Override
    public int getItemCount() {
        return jobInfo.size();
    }

    @Override
    public void extra() {

    }

    /**
     * viewHolder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDateTime, tvDistance, tvStartAddr, tvEndAddr,
                tvRideTime, tvAmount, tvDriverNam, tvRideTimeTitle, tvAmountTitle, tvDriverNameTitle;
        private View view;
        /**
         * @param itemView view itemView
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvDateTime = (TextView) itemView.findViewById(R.id.tvDateAndTime);
            tvDistance = (TextView) itemView.findViewById(R.id.tvDistanceKm);
            tvStartAddr = (TextView) itemView.findViewById(R.id.tvPickupAddress);
            tvEndAddr = (TextView) itemView.findViewById(R.id.tvDestinationAddress);
            tvRideTime = (TextView) itemView.findViewById(R.id.tvTotalRideTime);
            tvAmount = (TextView) itemView.findViewById(R.id.tvTotalAmount);
            tvDriverNam = (TextView) itemView.findViewById(R.id.tvDriverName);
            tvRideTimeTitle = (TextView) itemView.findViewById(R.id.tvTotalRideTimeTitle);
            tvAmountTitle = (TextView) itemView.findViewById(R.id.tvTotalAmountTitle);
            tvDriverNameTitle = (TextView) itemView.findViewById(R.id.tvDriverNameTitle);
            view = (View) itemView.findViewById(R.id.vLineHorizontalBelow);

        }

    }
}
