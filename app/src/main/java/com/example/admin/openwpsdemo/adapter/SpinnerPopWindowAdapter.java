package com.example.admin.openwpsdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import java.util.List;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/8/6 10:46
 * @邮箱：zhaowh@zgjzd.cn
 */
public class SpinnerPopWindowAdapter extends BaseRvAdapter<String>{

    public static final String TAG = SpinnerPopWindowAdapter.class.getSimpleName();

    public SpinnerPopWindowAdapter(List datas, int layoutId) {
        super(datas, layoutId);
    }

    @Override
    public void convert(CompatViewHolder holder, int position, String string) {
        LOGUtils.w(TAG,"string--->" + string);
        holder.setText(R.id.tv_item,string);

    }

}
