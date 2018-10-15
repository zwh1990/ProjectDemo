package com.example.admin.openwpsdemo.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.admin.openwpsdemo.R;
import com.example.admin.openwpsdemo.utils.LOGUtils;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = EditActivity.class.getSimpleName();
    private Button bt_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        bt_dialog = findViewById(R.id.bt_dialog);
        bt_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        confirmDialog("审批退回", "请填写退回原因", false);
    }

    private void confirmDialog(String title, String hint, final boolean isAgree) {
        new MaterialDialog.Builder(this)
                .title(title)
                .inputType(
                        InputType.TYPE_CLASS_TEXT
                                | InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                                | InputType.TYPE_TEXT_FLAG_CAP_WORDS)
                .inputRange(2, 50)
                .positiveText("提交")
                .input(hint, "", false, new MaterialDialog.InputCallback() {

                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        LOGUtils.w(TAG, "input--->" + input);
                        //呈请上报
//                        applyReported(input.toString().trim(), isAgree);
                    }
                }).show();

    }
}
