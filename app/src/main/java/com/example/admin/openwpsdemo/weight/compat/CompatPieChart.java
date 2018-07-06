package com.example.admin.openwpsdemo.weight.compat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.AnalysisChartBean;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *description :  把MpAndroidChart  饼状图表封装
 * Created by Administrator on 2017/10/26.
 */

public class CompatPieChart extends PieChart {

    private static final String TAG = CompatPieChart.class.getSimpleName();

    protected Typeface mTfLight;
    protected Typeface mTfRegular;

    private Context mCxt;

    //百分比后面的单位
    private String unit;

    public CompatPieChart(Context context) {
        this(context,null);
    }

    public CompatPieChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompatPieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mCxt = context;
        compactInit();
    }

    private void compactInit() {

        mTfLight = Typeface.createFromAsset(getResources().getAssets(), "OpenSans-Light.ttf");
        mTfRegular = Typeface.createFromAsset(getResources().getAssets(), "OpenSans-Regular.ttf");


        setUsePercentValues(true);
        getDescription().setEnabled(false);
        setExtraOffsets(30, 20, 30, 20);

        setDragDecelerationFrictionCoef(0.95f);

        setCenterTextTypeface(mTfLight);

        setDrawHoleEnabled(true);
        setHoleColor(Color.WHITE);

        setDrawEntryLabels(true);

        setTransparentCircleColor(Color.WHITE);
        setTransparentCircleAlpha(110);

        setHoleRadius(50f);
        setTransparentCircleRadius(55f);

        setDrawCenterText(true);

        setRotationAngle(90);
        // enable rotation of the chart by touch
        setRotationEnabled(true);
        setHighlightPerTapEnabled(true);

//        animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        l.setEnabled(false);

        // entry label styling
        setEntryLabelColor(Color.BLACK);
        setEntryLabelTypeface(mTfRegular);
        setEntryLabelTextSize(12f);

    }

    public void setData(AnalysisChartBean chartBean, boolean isDefault) {

        List<String> option= chartBean.getqOption();
        List<String> answer= chartBean.getqAnswer();

        unit = chartBean.getUnit();

        setCenterText(chartBean.getqTitle());

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < option.size() ; i++) {
            if(Integer.parseInt(answer.get(i))!=0){
                entries.add(new PieEntry(Integer.parseInt(answer.get(i)),
                        option.get(i % option.size()),
                        getResources().getDrawable(R.drawable.ic_start)));
            }
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(0f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
//        dataSet.setSelectionShift(10f);
        int [] colors ={mCxt.getColor(R.color.pieFour),mCxt.getColor(R.color.pieTwo),mCxt.getColor(R.color.pieThirteen),
                mCxt.getColor(R.color.pieOne),mCxt.getColor(R.color.pieNine),mCxt.getColor(R.color.pieFive),
                mCxt.getColor(R.color.pieSenven),mCxt.getColor(R.color.pieEight),mCxt.getColor(R.color.pieTwelve),
                mCxt.getColor(R.color.pieTen),mCxt.getColor(R.color.pieEleven),mCxt.getColor(R.color.pieSix),
                mCxt.getColor(R.color.pieThree),mCxt.getColor(R.color.pieFourteen),mCxt.getColor(R.color.pieFifteen)};
        dataSet.setColors(colors);


        if(!isDefault){
            dataSet.setValueLinePart1OffsetPercentage(80.f);
            dataSet.setValueLinePart1Length(0.6f);
            dataSet.setValueLinePart2Length(0.3f);
            dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            dataSet.setValueLineColor(Color.BLACK);
        }else{
            dataSet.setDrawValues(false);
        }

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new CompatPercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(mTfLight);
        setData(data);

        // undo all highlights
        highlightValues(null);

        invalidate();
    }

    class CompatPercentFormatter implements IValueFormatter, IAxisValueFormatter{
        protected DecimalFormat mFormat;

        public CompatPercentFormatter() {
            mFormat = new DecimalFormat("###,###,##0.0");
        }

        /**
         * Allow a custom decimalformat
         *
         * @param format
         */
        public CompatPercentFormatter(DecimalFormat format) {
            this.mFormat = format;
        }

        // IValueFormatter
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return (int)entry.getY() + unit +"("+ mFormat.format(value) + " %)";
        }

        // IAxisValueFormatter
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mFormat.format(value) + " %";
        }

        public int getDecimalDigits() {
            return 1;
        }
    }
}
