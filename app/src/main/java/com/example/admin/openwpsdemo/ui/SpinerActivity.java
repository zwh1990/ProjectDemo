package com.example.admin.openwpsdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.weight.spinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpinerActivity extends AppCompatActivity{

    private static final String TAG = SpinerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiner);

        NiceSpinner niceSpinner = findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("五天","三天的哈水", "七天"));
        niceSpinner.attachDataSource(dataset);

    }

}
