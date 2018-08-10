package com.example.admin.openwpsdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * 适配器
 * @param <T>
 */

public abstract class BaseRvAdapter<T> extends RecyclerView.Adapter<CompatViewHolder> {

    protected final List<T> datas;
    private final int layoutId;
    private CompatViewHolder viewHolder;

    public BaseRvAdapter(List<T> datas, @LayoutRes int layoutId ) {
        this.datas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public  CompatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CompatViewHolder.get(parent.getContext(),parent,layoutId,-1);
    }

    @Override
    public void onBindViewHolder(CompatViewHolder holder, int position) {
        if (datas!=null) ;
        convert(holder,position, datas.get(position));
    }



    public abstract void convert(CompatViewHolder holder, int position, T t) ;



    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }



}
