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
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test_la_politique);
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
        Sentence s1_1 = new Sentence("1_1","1. Un homme attend dans un café,un autre arrive, cela fait deux hommes. ");
        sentenceList.add(s1_1);

        Sentence s1_2 = new Sentence("1_2","2. Salut, mec. ");
        sentenceList.add(s1_2);

        Sentence s1_3 = new Sentence("1_3","3. Une serveuse s'approche des deux hommes. ");
        sentenceList.add(s1_3);

        Sentence s1_4 = new Sentence("1_4","4. Bojour. ");
        sentenceList.add(s1_3);

        Sentence s1_5 = new Sentence("1_5","5. Bonjour, je vais prendre un déca ");
        sentenceList.add(s1_4);

        Sentence s1_6 = new Sentence("1_6","6. Euh deux, s'il vous plaît. ");
        sentenceList.add(s1_5);

        Sentence s1_7 = new Sentence("1_7","7. Ils commandent de façon directive à la serveuse. ");
        sentenceList.add(s1_7);

    }
}