package com.example.dongja94.samplegallery;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-18.
 */
public class ImageAdapter extends BaseAdapter {
    List<Drawable> items = new ArrayList<Drawable>();

    public void add(Drawable d) {
        items.add(d);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (items.size() == 0) return 0;
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position % items.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(parent.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int width = parent.getContext().getResources().getDimensionPixelSize(R.dimen.photo_width);
            int height = parent.getContext().getResources().getDimensionPixelSize(R.dimen.photo_height);
            Gallery.LayoutParams params = new Gallery.LayoutParams(width, height);
            imageView.setLayoutParams(params);
        } else {
            imageView = (ImageView)convertView;
        }
        imageView.setImageDrawable(items.get(position % items.size()));
        return imageView;
    }
}
