package com.shine.carouseview.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shine.carouseview.R;
import com.shine.carouseview.utils.Constants;

import java.util.ArrayList;

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    //constructor to assign the passed Values to appropriate values in the class
    public ImageViewPagerAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.fragment_image, view, false);

         ImageView imageView1 = imageLayout.findViewById(R.id.iv_1);
         ImageView imageView2 = imageLayout.findViewById(R.id.iv_2);
         ImageView imageView3 = imageLayout.findViewById(R.id.iv_3);

        Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Lionel_Messi_16_June_2018.jpg/220px-Lionel_Messi_16_June_2018.jpg").into(imageView1);
        Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Lionel_Messi_16_June_2018.jpg/220px-Lionel_Messi_16_June_2018.jpg").into(imageView2);
        Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Lionel_Messi_16_June_2018.jpg/220px-Lionel_Messi_16_June_2018.jpg").into(imageView3);

        view.addView(imageLayout, 0);

        return imageLayout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
