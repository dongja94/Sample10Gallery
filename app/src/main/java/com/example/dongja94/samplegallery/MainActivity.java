package com.example.dongja94.samplegallery;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {

    ImageAdapter mAdapter;
    Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery)findViewById(R.id.gallery);
        mAdapter = new ImageAdapter();
        gallery.setAdapter(mAdapter);

        initData();

        gallery.setSelection((Integer.MAX_VALUE / 2) / IDS.length * IDS.length);
        int spacing = getResources().getDimensionPixelSize(R.dimen.spacing);
        gallery.setSpacing(spacing);
    }

    int[] IDS = {R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8,
    };
    private void initData() {
        for (int i : IDS) {
            Drawable d = getResources().getDrawable(i);
            mAdapter.add(d);
        }
    }
}
