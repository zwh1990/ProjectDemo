package com.example.admin.openwpsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.util.List;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/5/29 17:25
 * @邮箱：zhaowh@zgjzd.cn
 */
public class RecAdapter extends RecyclerView.Adapter {

    private static final String TAG = RecAdapter.class.getSimpleName();

    private Context mCxt;
    private List<String> mDatas;
    private LayoutInflater mLayoutInflater;

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;


    public RecAdapter(Context mCxt, List<String> mDatas) {
        this.mCxt = mCxt;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mCxt);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ONE) {

            View view = mLayoutInflater.inflate(R.layout.item_one,parent,false);
            return new ViewHolderOne(view);

        } else if (viewType == TWO) {

            View view = mLayoutInflater.inflate(R.layout.item_two,parent,false);
            return new ViewHolderTwo(view);

        } else if (viewType == THREE) {

            View view = mLayoutInflater.inflate(R.layout.item_three,parent,false);
            return new ViewHolderThree(view);

        } else if (viewType == FOUR) {

            View view = mLayoutInflater.inflate(R.layout.item_four,parent,false);
            return new ViewHolderFour(view);

        } else if (viewType == FIVE) {

            View view = mLayoutInflater.inflate(R.layout.item_five,parent,false);
            return new ViewHolderFive(view);

        } else if (viewType == SIX) {

            View view = mLayoutInflater.inflate(R.layout.item_six,parent,false);
            return new ViewHolderSix(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolderOne){
            LOGUtils.w(TAG,"ViewHolderOne--->");

        }else if(holder instanceof ViewHolderTwo){
            LOGUtils.w(TAG,"ViewHolderTwo--->");

        }else if(holder instanceof ViewHolderThree){
            LOGUtils.w(TAG,"ViewHolderThree--->");

        }else if(holder instanceof ViewHolderFour){
            LOGUtils.w(TAG,"ViewHolderFour--->");

        }else if(holder instanceof ViewHolderFive){
            LOGUtils.w(TAG,"ViewHolderFive--->");

        }else if(holder instanceof ViewHolderSix){
            LOGUtils.w(TAG,"ViewHolderSix--->");
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        } else if (position == 1) {
            return TWO;
        } else if (position == 2) {
            return THREE;
        } else if (position == 3) {
            return FOUR;
        } else if (position == 4) {
            return FIVE;
        } else if (position == 5) {
            return SIX;
        }
        return -1;
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{

        public ViewHolderOne(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder{

        public ViewHolderTwo(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderThree extends RecyclerView.ViewHolder{

        public ViewHolderThree(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderFour extends RecyclerView.ViewHolder{

        public ViewHolderFour(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderFive extends RecyclerView.ViewHolder{

        public ViewHolderFive(View itemView) {
            super(itemView);
        }
    }

    class ViewHolderSix extends RecyclerView.ViewHolder{

        public ViewHolderSix(View itemView) {
            super(itemView);
        }
    }
}
