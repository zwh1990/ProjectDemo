package com.example.admin.openwpsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.openwpsdemo.biz.AnalysisChartBean;
import com.example.admin.openwpsdemo.weight.compat.CompatPieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.openwpsdemo.R.id.pieChart;

public class PieActivity extends AppCompatActivity {

    private static final String TAG = PieActivity.class.getSimpleName();
    CompatPieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        initView();

    }

    private void initView() {

        pieChart = findViewById(R.id.pieChart);

        AnalysisChartBean analysisChartBean = new AnalysisChartBean();
        List<String> option = new ArrayList<>();
        option.add("电话");
        option.add("邮箱");
        option.add("来信");
        option.add("来访");
        option.add("公安部督办");
        option.add("省厅督办");
        option.add("市政法委督办");


        analysisChartBean.setqOption(option);

        List<String> answer = new ArrayList<>();
        answer.add("8");
        answer.add("6");
        answer.add("7");
        answer.add("5");
        answer.add("3");
        answer.add("6");
        answer.add("10");
        answer.add("1");

        analysisChartBean.setqAnswer(answer);
        pieChart.setData(analysisChartBean,false);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                if (e == null)
                    return;
                Log.i(TAG,
                        "选中饼状图--->" + e.getX()+ ","+ e.getY() + ", index: " + h.getX()
                                + ", DataSet index: " + h.getDataSetIndex());

            }

            @Override
            public void onNothingSelected() {
                Log.w(TAG,"未选中饼状图--->");
            }

        });
    }

}
