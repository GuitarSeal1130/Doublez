package com.example.doublez;


import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

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
        videoView.setMediaController(new MediaController(this));
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook1);
        videoView.setVideoURI(rawUri);
    }
}


