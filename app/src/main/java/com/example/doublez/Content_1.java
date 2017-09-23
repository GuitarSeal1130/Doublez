package com.example.doublez;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class Content_1 extends AppCompatActivity
{

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);
        // Toolbar

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        // VdeoView
        videoView = (VideoView) findViewById(R.id.video_view);
        //videoView.setMediaController(new MediaController(this));  // 播放器控制按钮
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook1);
        videoView.setVideoURI(rawUri);

        //Button
        Button button1=(Button)findViewById(R.id.clip_1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook1);
                videoView.setVideoURI(rawUri);
                videoView.start();
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        videoView.start();

                    }
                });
            }
        });

        Button button2=(Button)findViewById(R.id.clip_2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook2);
                videoView.setVideoURI(rawUri);
                videoView.start();
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        videoView.start();

                    }
                });
            }
        });

        Button button3=(Button)findViewById(R.id.clip_3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ash);
                videoView.setVideoURI(rawUri);
                videoView.start();
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        videoView.start();

                    }
                });
            }
        });

        Button button4=(Button)findViewById(R.id.clip_4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ying);
                videoView.setVideoURI(rawUri);
                videoView.start();
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        videoView.start();
                    }
                });
            }
        });

    }

}