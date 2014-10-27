package org.fingerlinks.mobile.android.samplel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import org.fingerlinks.mobile.android.samplel.CodeUtils;
import org.fingerlinks.mobile.android.samplel.R;
import org.fingerlinks.mobile.android.samplel.model.Image;

/**
 * Created by Fabio Ranieri on 20/10/14.
 * Copyright 2014 Fingerlinks s.r.l.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<Image> images;
    private int rowLayout;
    private Context mContext;

    public ImageAdapter(List<Image> images, int rowLayout, Context context) {
        this.images = images;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Image _bean = images.get(i);
        viewHolder.name.setText(_bean.name);
        viewHolder.image_url.setImageDrawable(
                mContext.getDrawable(CodeUtils.getImageResourceId(mContext, _bean.imageName)));
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image_url;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image_url = (ImageView)itemView.findViewById(R.id.image);
        }

    }
};