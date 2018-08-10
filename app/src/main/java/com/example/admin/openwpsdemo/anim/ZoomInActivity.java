package com.example.admin.openwpsdemo.anim;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.openwpsdemo.R;
import com.squareup.picasso.Picasso;

public class ZoomInActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img;

    private String path = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/flying_in_the_light.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_in);

        img = findViewById(R.id.img);
        img.setOnClickListener(this);

        Picasso.with(img.getContext())
                .load(path)
                .noFade()
                .noPlaceholder()
                .into(img);
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.img:

                Intent intent = new Intent(this, ZoomInDetailActivity.class);
                intent.putExtra(ZoomInDetailActivity.PATH, path);

                // BEGIN_INCLUDE(start_activity)
                /**
                 * Now create an {@link android.app.ActivityOptions} instance using the
                 * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
                 * method.
                 */
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,

                        // Now we provide a list of Pair items which contain the view we can transitioning
                        // from, and the name of the view it is transitioning to, in the launched activity
                        new Pair<View, String>(view,
                                ZoomInDetailActivity.VIEW_NAME_HEADER_IMAGE));

                // Now we can start the Activity, providing the activity options as a bundle
                ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
                // END_INCLUDE(start_activity)

                break;
        }

    }
}
