package org.fingerlinks.mobile.android.samplel;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.fingerlinks.mobile.android.samplel.model.Image;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class DetailActivity extends Activity {


    private ImageView mImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Image _bean = (Image)getIntent().getSerializableExtra(EXTRA_IMAGE);
        ImageView image = (ImageView) findViewById(R.id.image);
        //View.setTransitionName(image, EXTRA_IMAGE);
        Picasso.with(this).load(
                CodeUtils.getImageResourceId(DetailActivity.this, _bean.imageName))
                .into(image);
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
        activity.startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(
                activity).toBundle());
    }

    public static final String EXTRA_IMAGE = DetailActivity.class.getName()+":image";
};