package com.example.admin.openwpsdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.adapter.TimeLineAdapter;
import com.example.admin.openwpsdemo.biz.TimeLineBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 时间轴activity
 */
public class TimeLineActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineBean> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        initView();
    }

    private void initView() {
        LinearLayoutManager mLinearLayoutManager =  new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(this,mDataList);
        mRecyclerView.setAdapter(mTimeLineAdapter);

    }

    private void setDataListItems(){

        mDataList.add(new TimeLineBean("立案", "时间:2014-09-20","经办:人张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("受案", "时间:2014-09-20","经办人:张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("受案审批", "时间:2014-09-20","经办人:张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("侦查措施", "时间:2014-09-20","经办人:张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("侦查方案", "时间:2014-09-20","经办:人张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("传唤", "时间:2014-09-20","经办人:张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("调取证据", "时间:2014-09-20","经办:人张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));

        mDataList.add(new TimeLineBean("询问", "时间:2014-09-20","经办:人张三、李四","即可到时候覅的韩师傅举案说法u爱是发货地阿斯卡" +
                "复活断水口附近哈时间大精神防化服u鞍山分行考试\n很骄傲的书法进库房阿USif回家哭\n件大事返回键奥卡福" ));
    }

}
