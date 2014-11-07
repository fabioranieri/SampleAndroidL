package org.fingerlinks.mobile.android.samplel;

import android.animation.ObjectAnimator;
import android.app.Activity;

/**
 * Created by fabio on 27/10/14.
 */
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.transition.Explode;
import android.transition.Transition;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.fingerlinks.mobile.android.samplel.model.Image;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class DetailActivity extends Activity {


    private ImageView mImageView = null;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*getWindow().getEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                ImageView hero = (ImageView) findViewById(R.id.image);
                ObjectAnimator color = ObjectAnimator.ofArgb(hero.getColorFilter(), "color", 0);
                color.addUpdateListener(new ColorFilterListener(hero));
                color.start();

                findViewById(R.id.info).animate().alpha(1.0f);
                findViewById(R.id.star).animate().alpha(1.0f);

                getWindow().getEnterTransition().removeListener(this);
            }
        });*/

        Image _bean = (Image)getIntent().getSerializableExtra(EXTRA_IMAGE);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setViewName(EXTRA_IMAGE_TRANSICTION);
        Picasso.with(this).
                load(CodeUtils.getImageResourceId(DetailActivity.this, _bean.imageName)).
                into(image);

        text = (TextView)findViewById(R.id.text);
        text.setText(_bean.description);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void launch(Activity activity, View transitionView, Image bean) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, bean);

        transitionView.setViewName(EXTRA_IMAGE_TRANSICTION);

        activity.startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(
                activity, Pair.create(transitionView, EXTRA_IMAGE_TRANSICTION)).toBundle());
    }

    public void startScheduleActivity(View view) {
        Intent intent = new Intent(DetailActivity.this, TestJobServiceActivity.class);
        startActivity(intent);
    }

    public static final String EXTRA_IMAGE = DetailActivity.class.getName()+":image";
    public static final String EXTRA_IMAGE_TRANSICTION = DetailActivity.class.getName()+":image_transiction";
};