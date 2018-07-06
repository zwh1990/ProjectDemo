package com.example.admin.openwpsdemo.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;

/**
 * @author Fuchunxiao
 * @Description:
 * @date 2018/2/5
 */
public class SelectTextView extends LinearLayout {

    public static final String TAG = SelectTextView.class.getSimpleName();

    private final int mContentColor;
    private final int mTitleColor;
    private final int mContentSize;
    private final int mTitleSize;
    private final String mContent;
    private final String mTitle;
    private final Drawable mDetailpic;
    private TextView mTvTitle;
    private TextView mTvSelect;

    public SelectTextView(Context context) {
        this(context, null);
    }

    public SelectTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SelectTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemUserInfoView);
        mContentColor = typedArray.getColor(R.styleable.ItemUserInfoView_content_text_color, Color.BLACK);
        mTitleColor = typedArray.getColor(R.styleable.ItemUserInfoView_title_text_color, Color.BLACK);
        mContentSize = typedArray.getDimensionPixelSize(R.styleable.ItemUserInfoView_content_text_size, 12);
        mTitleSize = typedArray.getDimensionPixelSize(R.styleable.ItemUserInfoView_title_text_size, 12);
        mContent = typedArray.getString(R.styleable.ItemUserInfoView_content_text);
        mTitle = typedArray.getString(R.styleable.ItemUserInfoView_title_text);
        mDetailpic = typedArray.getDrawable(R.styleable.ItemUserInfoView_detail_ic);
        typedArray.recycle();
        initView(context);
        initContent();
    }

    private void initContent() {
        mTvSelect.setTextColor(mContentColor);
        mTvSelect.setTextSize(mContentSize);
        mTvSelect.setHint(TextUtils.isEmpty(mContent) ? "" : mContent);

        mTvTitle.setTextColor(mTitleColor);
        mTvTitle.setTextSize(mTitleSize);
        mTvTitle.setText(TextUtils.isEmpty(mTitle) ? "" : mTitle);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_select_textview, this, true);
        mTvTitle = findViewById(R.id.tv_title);
        mTvSelect = findViewById(R.id.tv_select);
        // TODO: 2018/2/6  设置icon
    }

    public void setText(CharSequence text) {
        mTvSelect.setText(text);
    }

    public String getText(){
        CharSequence text = mTvSelect.getText();
        if(!TextUtils.isEmpty(text)){
            return  text.toString().trim();
        }
        return "";
    }

    //设置内容背景为null
    public void setContentBac(){
        mTvSelect.setBackground(null);
    }

}
