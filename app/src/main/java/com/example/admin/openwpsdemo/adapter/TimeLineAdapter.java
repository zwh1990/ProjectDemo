package com.example.admin.openwpsdemo.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.TimeLineBean;
import com.example.admin.openwpsdemo.weight.TimelineView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Created by zwh.
 * @description：时间轴的adapter
 * @date 2018/5/24 14:36
 * @邮箱：zhaowh@zgjzd.cn
 */

public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mCxt;
    private List<TimeLineBean> mDatas;
    private LayoutInflater mLayoutInflater;

    public TimeLineAdapter(Context mCxt, List<TimeLineBean> mDatas) {
        this.mCxt = mCxt;
        this.mDatas = mDatas;

        mLayoutInflater = LayoutInflater.from(mCxt);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate( R.layout.item_time_line, parent, false);
        return new TimeLineViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TimeLineBean timeLineBean = mDatas.get(position);

        if(holder instanceof TimeLineViewHolder){
            TimeLineViewHolder timeLineViewHolder = (TimeLineViewHolder) holder;
            timeLineViewHolder.mTimelineView.setMarker(ContextCompat.getDrawable(mCxt, R.drawable.ic_marker),
                    ContextCompat.getColor(mCxt, R.color.pieSenven));

            timeLineViewHolder.progressName.setText(timeLineBean.getProgressName());
            timeLineViewHolder.progressTime.setText(timeLineBean.getProgressTime());
            timeLineViewHolder.progressPerson.setText(timeLineBean.getProgressPerson());
            timeLineViewHolder.progress.setText(timeLineBean.getProgress());

        }
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    class TimeLineViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progressName)
        TextView progressName;

        @BindView(R.id.progressTime)
        TextView progressTime;

        @BindView(R.id.progressPerson)
        TextView progressPerson;

        @BindView(R.id.progress)
        TextView progress;

        @BindView(R.id.time_marker)
        TimelineView mTimelineView;

        public TimeLineViewHolder(View itemView,int viewType) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mTimelineView.initLine(viewType);
        }
    }


}
