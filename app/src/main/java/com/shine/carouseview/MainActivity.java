package com.shine.carouseview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    //    public static final String VIDEO_STREAM_URL = "http://playertest.longtailvideo.com/adaptive/wowzaid3/playlist.m3u8";
    public static final String VIDEO_STREAM_URL = "http://184.72.239.149/vod/smil:BigBuckBunny.smil/playlist.m3u8";
    private VideoView _videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        _videoView = findViewById(R.id.videoView);
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
                    _videoView.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
