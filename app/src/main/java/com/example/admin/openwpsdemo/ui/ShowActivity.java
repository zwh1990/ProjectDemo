package com.example.admin.openwpsdemo.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.biz.DirectiveFeedbackBean;
import com.example.admin.openwpsdemo.weight.SelectTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用展示页面
 */
public class ShowActivity extends AppCompatActivity {

    SelectTextView st_clue_name;
    SelectTextView st_clue_source;

    TableLayout table_directive_feedback;
    String [] directive_feedback;

    List<DirectiveFeedbackBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initView();
    }

    private void initView() {
        st_clue_name = findViewById(R.id.st_clue_name);
        st_clue_source = findViewById(R.id.st_clue_source);
        table_directive_feedback = findViewById(R.id.table_directive_feedback);

        st_clue_name.setText("nihao");
        st_clue_source.setText("nihaoogfngdhfrekjgfdkkjgiofdkfgjifdkgjdfkgnfdkj" +
                "hfdhsjfkdjsgkdfsjfgokrjdfmkgjdfkgjfkldskgjirgjjkdfgjdfsksdhgjjksfg" +
                "udfgjnkdfjgkdfgjidsfkkjgkerjgkfdjgsghidfuighskgjhuidfkgri");


        directive_feedback = getResources().getStringArray(R.array.directive_feedback);
        getData();

        addHeaderRow(table_directive_feedback);
        if(data!=null && data.size()>0){
            addRows();
        }

    }

    private void addHeaderRow(TableLayout layout) {
        TableRow tr = getTableRow();

        TextView contacts = getTextView(getString(R.string.contacts));
        contacts.setBackgroundResource(R.color.colorAccent);
        tr.addView(contacts);

        TextView contactsPhoneIn = getTextView(getString(R.string.contacts_phone_in));
        contactsPhoneIn.setBackgroundResource(R.color.colorAccent);
        tr.addView(contactsPhoneIn);

        TextView contactsPhoneOut = getTextView(getString(R.string.contacts_phone_out));
        contactsPhoneOut.setBackgroundResource(R.color.colorAccent);
        tr.addView(contactsPhoneOut);

        TextView acceptDep = getTextView(getString(R.string.accept_dep));
        acceptDep.setBackgroundResource(R.color.colorAccent);
        tr.addView(acceptDep);

        TextView feedbackDay = getTextView(getString(R.string.feedback_day));
        feedbackDay.setBackgroundResource(R.color.colorAccent);
        tr.addView(feedbackDay);


        TextView workRequire = getTextView(getString(R.string.work_require));
        workRequire.setBackgroundResource(R.color.colorAccent);
        tr.addView(workRequire);

        TextView directiveType = getTextView(getString(R.string.directive_type));
        directiveType.setBackgroundResource(R.color.colorAccent);
        tr.addView(directiveType);

        TextView transpondNumber = getTextView(getString(R.string.transpond_number));
        transpondNumber.setBackgroundResource(R.color.colorAccent);
        tr.addView(transpondNumber);

        TextView isSelfInspection = getTextView(getString(R.string.is_self_inspection));
        isSelfInspection.setBackgroundResource(R.color.colorAccent);
        tr.addView(isSelfInspection);

        TextView directiveStatus = getTextView(getString(R.string.directive_status));
        directiveStatus.setBackgroundResource(R.color.colorAccent);
        tr.addView(directiveStatus);

        TextView isQualified = getTextView(getString(R.string.is_qualified));
        isQualified.setBackgroundResource(R.color.colorAccent);
        tr.addView(isQualified);

        TextView operate = getTextView(getString(R.string.operate));
        operate.setBackgroundResource(R.color.colorAccent);
        tr.addView(operate);

        layout.addView(tr, getLayoutParams());

    }

    @NonNull
    private TableRow getTableRow() {
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tr.setDividerDrawable(ResourcesCompat.getDrawable(getResources(),
                R.drawable.table_h_divider, null));
        tr.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE
                | LinearLayout.SHOW_DIVIDER_BEGINNING
                | LinearLayout.SHOW_DIVIDER_END);
        tr.setGravity(Gravity.CENTER_VERTICAL);
        return tr;
    }

    @NonNull
    private TableLayout.LayoutParams getLayoutParams() {
        return new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
    }

    public TextView getTextView(String value) {
        TextView textview = new TextView(this);
        textview.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
        return setTextView(value, textview);
    }

    @NonNull
    private TextView setTextView(String value, TextView textview) {
        textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        textview.setText(value);
        textview.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
        textview.setGravity(Gravity.CENTER);
        textview.setPadding(15, 15, 15, 15);
        textview.setBackgroundResource(android.R.color.white);
        return textview;
    }

    private void addRows() {
        for (int k = 0; k < data.size(); k++) {
            final DirectiveFeedbackBean bean =  data.get(k);
            TableRow tr = getTableRow();
            TextView contacts = getTextView(bean.getContacts());
            tr.addView(contacts);

            String contactsPhoneIn = bean.getContactsPhoneIn();
            TextView caseSort = getTextView(contactsPhoneIn);
            tr.addView(caseSort);

            TextView contactsPhoneOut = getTextView(bean.getContactsPhoneOut());
            tr.addView(contactsPhoneOut);

            TextView acceptDep = getTextView(bean.getAcceptDep());
            tr.addView(acceptDep);

            TextView feedbackDay = getTextView(bean.getFeedbackDay());
            tr.addView(feedbackDay);

            TextView workRequire = getTextView(bean.getWorkRequire());
            tr.addView(workRequire);

            TextView directiveType = getTextView(bean.getDirectiveType());
            tr.addView(directiveType);

            TextView transpondNumber = getTextView(bean.getTranspondNumber());
            tr.addView(transpondNumber);

            TextView isSelfInspection = getTextView(bean.getIsSelfInspection());
            tr.addView(isSelfInspection);

            TextView directiveStatus = getTextView(bean.getDirectiveStatus());
            tr.addView(directiveStatus);

            TextView isQualified = getTextView(bean.getIsQualified());
            tr.addView(isQualified);

            TextView operate = getTextView(bean.getOperate());
            tr.addView(operate);

//            TextView operation = getTextView(bean.getOperate());
//            operation.setTextColor(ResourcesCompat.getColor(getContext().getResources(), R.color.colorPrimaryDark, null));
//            tr.addView(operation);


            table_directive_feedback.addView(tr, getLayoutParams());
        }
    }


    public void getData() {
        data = new ArrayList<>();
        DirectiveFeedbackBean feedbackBean = new DirectiveFeedbackBean("张三","673256","74756783",
                "djsahj","hdfh","hdfj","hjhs","hjd",
                "jddjf","hadsj","hjdff");

        data.add(feedbackBean);

    }

}
