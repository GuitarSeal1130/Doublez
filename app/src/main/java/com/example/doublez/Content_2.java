package com.example.doublez;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class Content_2 extends AppCompatActivity {

    private VideoView videoView;
    private List<Sentence> sentenceList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_2);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        /* VdeoView
        videoView = (VideoView) findViewById(R.id.video_view2);
        //videoView.setMediaController(new MediaController(this));  // 播放器控制按钮
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rook1);
        videoView.setVideoURI(rawUri);
        */

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initMainContent();
        SentenceAdapter adapter2 = new SentenceAdapter(sentenceList,Content_2.this);
        recyclerView.setAdapter(adapter2);

    }

    private void initMainContent()
    {
        for(int i=0;i<3;i++)
        {
            Sentence s2_1 = new Sentence("2_1","1. Un homme dans un café");
            sentenceList.add(s2_1);

            Sentence s2_2 = new Sentence("2_2","2. Un autre arrive");
            sentenceList.add(s2_2);

            Sentence s2_3 = new Sentence("2_3","3. Cela fait deux hommes");
            sentenceList.add(s2_3);
        }

    }
}
