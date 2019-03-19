package com.example.admin.openwpsdemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.CustomImageSizeModel;
import com.example.admin.openwpsdemo.glide.CustomImageModelLoader;

import java.util.List;

/**
 * @Created by zwh.
 * @description：
 * @date 2018/8/30 14:24
 * @邮箱：zhaowh@zgjzd.cn
 */
public class GlideAdapter extends BaseRvAdapter<CustomImageSizeModel> {

    private Context mCxt;

    public GlideAdapter(Context mCxt, List<CustomImageSizeModel> datas, int layoutId) {
        super(datas, layoutId);
        this.mCxt = mCxt;
    }

    @Override
    public void convert(CompatViewHolder holder, int position, CustomImageSizeModel s) {
        Glide.with(mCxt)
//                .using(new CustomImageModelLoader(mCxt))
                .load(datas.get(position).getBaseUrl())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.arrow)
                .into((ImageView) holder.getView(R.id.img));

    }
}
