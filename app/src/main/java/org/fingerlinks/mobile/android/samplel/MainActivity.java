package org.fingerlinks.mobile.android.samplel;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import org.fingerlinks.mobile.android.samplel.adapter.ImageAdapter;
import org.fingerlinks.mobile.android.samplel.listener.RecyclerItemClickListener;
import org.fingerlinks.mobile.android.samplel.model.Image;
import org.fingerlinks.mobile.android.samplel.model.ImageFactoryManager;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
        Transition ts = new Explode(); //Slide();
        ts.setStartDelay(2000);
        ts.setDuration(5000);

        /*
         * If you have set an enter transition for the second activity,
         * the transition is also activated when the activity starts.
         */
        getWindow().setEnterTransition(ts);
        getWindow().setExitTransition(ts);

        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(android.R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ImageAdapter(ImageFactoryManager.getInstance().getAllImages(), R.layout.row, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        Image actualImage = ImageFactoryManager.getInstance().getImageAt(position);
                        DetailActivity.launch(MainActivity.this,
                                view.findViewById(R.id.image), actualImage );
                    }
                }));
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
}
