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
import com.bumptech.glide.request.RequestOptions;
import com.shine.carouseview.R;
import com.shine.carouseview.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    List<Integer> generated = new ArrayList<Integer>();


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

        Glide.with(mContext).load(generateRandomImageURL()).into(imageView1);
        if (position != 2) {
            Glide.with(mContext).load(generateRandomImageURL()).into(imageView2);
            Glide.with(mContext).load(generateRandomImageURL()).into(imageView3);
        }
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
        return 3;
    }

    private String generateRandomImageURL() {
        Random random = new Random();
        int x = random.nextInt(900) + 100;
        int y = random.nextInt(900) + 100;
        while (true) {
            if (!generated.contains(x)) {
                // Done for this iteration
                generated.add(x);
                break;
            }
        }
        System.out.println("generateRandomImageURL = " + Constants.IMG_BASE_URL + "/" + x + "" + y + "/");
        return Constants.IMG_BASE_URL + "/" + x + "/" + y + "/";
    }
}
