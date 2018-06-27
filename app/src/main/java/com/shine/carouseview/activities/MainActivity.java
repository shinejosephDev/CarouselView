package com.shine.carouseview.activities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.shine.carouseview.R;
import com.shine.carouseview.adapter.ImageViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    public static final String VIDEO_STREAM_URL = "http://playertest.longtailvideo.com/adaptive/wowzaid3/playlist.m3u8";
    public static final String VIDEO_STREAM_URL = "http://184.72.239.149/vod/smil:BigBuckBunny.smil/playlist.m3u8";
    private VideoView _videoView;
    private ViewPager _viewPager;

    private ImageViewPagerAdapter _adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        _videoView = findViewById(R.id.videoView);
        _viewPager = findViewById(R.id.viewPager);
        Button btnNext = findViewById(R.id.btn_next);
        Button btnPrev = findViewById(R.id.btn_prev);

        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);

        _adapter = new ImageViewPagerAdapter(this);
        _viewPager.setAdapter(_adapter);
        playVideo();
    }

    private void playVideo() {
        try {
            MediaController mediaController = new MediaController(MainActivity.this);
            mediaController.setAnchorView(_videoView);

            Uri video = Uri.parse(VIDEO_STREAM_URL);
            _videoView.setMediaController(mediaController);
            _videoView.setVideoURI(video);
            _videoView.requestFocus();
            _videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    mp.setVolume(0f, 0f);
                    _videoView.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                nextPage();
                break;
            case R.id.btn_prev:
                prevPage();
                break;
        }
    }

    private void nextPage() {
        if (_viewPager.getCurrentItem() != 2) {
            _viewPager.setCurrentItem(_viewPager.getCurrentItem() + 1);
        } else {
            _viewPager.setCurrentItem(0);
        }
    }

    private void prevPage() {
        if (_viewPager.getCurrentItem() != 0) {
            _viewPager.setCurrentItem(_viewPager.getCurrentItem() - 1);
        } else {
            _viewPager.setCurrentItem(2);
        }
    }
}
