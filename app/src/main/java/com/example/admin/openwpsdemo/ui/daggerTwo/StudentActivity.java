package com.example.admin.openwpsdemo.ui.daggerTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.openwpsdemo.LOGUtils;
import com.example.admin.openwpsdemo.R;

import javax.inject.Inject;

public class StudentActivity extends AppCompatActivity {

    private static final String TAG = StudentActivity.class.getSimpleName();
    TextView tv_student;
    TextView tv_person;

    @Inject
    Student student;

    @Inject
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        tv_student = findViewById(R.id.tv_student);
        tv_person = findViewById(R.id.tv_person);

        DaggerStudentComponed.builder().studentModule(new StudentModule()).build().inject(this);
        tv_student.setText(student.getName());
        tv_person.setText(person.getStudent().getAge());

        if(person.getStudent().equals(student)){
            LOGUtils.w(TAG,"true --->");
        }else{
            LOGUtils.w(TAG,"false --->");
        }


    }
}
