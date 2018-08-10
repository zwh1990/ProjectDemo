package com.example.admin.openwpsdemo.anim;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.admin.openwpsdemo.R;
import com.squareup.picasso.Picasso;

public class ZoomInDetailActivity extends AppCompatActivity {

    private static final String TAG = ZoomInDetailActivity.class.getSimpleName();

    public static final String PATH = "path";

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    private ImageView img;

    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_in_detail);

        img = findViewById(R.id.img);

        path = getIntent().getStringExtra(PATH);

        ViewCompat.setTransitionName(img, VIEW_NAME_HEADER_IMAGE);


        Picasso.with(img.getContext())
                .load(path)
                .noFade()
                .noPlaceholder()
                .into(img);
    }
}
