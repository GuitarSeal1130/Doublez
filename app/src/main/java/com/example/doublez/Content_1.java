package com.example.doublez;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class Content_1 extends AppCompatActivity
{

    private VideoView videoView;
    private List<Sentence> sentenceList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);
        // Toolbar

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        // VdeoView
        videoView = (VideoView) findViewById(R.id.video_view1);
        //videoView.setMediaController(new MediaController(this));  // 播放器控制按钮
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook1);
        videoView.setVideoURI(rawUri);

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initMainContent();
        SentenceAdapter adapter2 = new SentenceAdapter(sentenceList,Content_1.this);
        recyclerView.setAdapter(adapter2);

    }
    private void initMainContent()
    {
        Sentence s1_1 = new Sentence("1_1","1. Un homme dans un café");
        sentenceList.add(s1_1);

        Sentence s1_2 = new Sentence("1_2","2. Un autre arrive");
        sentenceList.add(s1_2);

        Sentence s1_3 = new Sentence("1_3","3. Cela fait deux hommes");
        sentenceList.add(s1_3);

    }
}