package com.example.doublez;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Content_2 extends AppCompatActivity
{

    private Uri rawUri;
    private VideoView videoView=null;
    private List<Sentence> sentenceList=new ArrayList<>();
    private SentenceAdapter adapter;
    private int count=1;
    private File recordFile;
    private MediaPlayer mediaPlayer=null;
    private Uri uri;
    private MediaRecorder mediaRecorder=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_2);
        // Toolbar

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


        // VdeoView
        videoView = (VideoView) findViewById(R.id.video_view2);
        //videoView.setMediaController(new MediaController(this));  // 播放器控制按钮
        rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_0);
        videoView.setVideoURI(rawUri);
        videoView.start();
        videoView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_0);
                videoView.setVideoURI(rawUri);
                videoView.start();
                return false;
            }
        });


        //RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initMainContent();
        adapter = new SentenceAdapter(sentenceList,Content_2.this,videoView);
        recyclerView.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.content_toolbar,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            //Doublez按钮监听函数
            case R.id.play:
                count=1;
                //停止播放录音
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                }
                //停止录音
                if(mediaRecorder!=null)
                {
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder = null;
                }
                //播放视频
                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_1s);
                videoView.setVideoURI(rawUri);
                videoView.start();
                //播放录音
                recordFile=new File("/mnt/sdcard", "2_1.aac");  // 指向音频文件
                uri = Uri.fromFile(recordFile);
                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                mediaPlayer.start();
                count++;

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    //@Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        //停止播放录音
                        if(mediaPlayer!=null)
                            mediaPlayer.stop();
                        switch(count)
                        {
                            case 2:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_2s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                mediaPlayer.stop();
                                recordFile=new File("/mnt/sdcard", "2_2.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 3:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_3s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_3.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 4:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_4s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_4.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 5:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_5s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_5.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 6:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_6s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_6.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 7:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_7s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_7.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 8:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_8s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "2_8.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 9:
                                count=1;
                                mediaPlayer.reset();
                                break;
                            default:

                        }
                    }
                });
                break;
            default:
        }
        return true;
    }

    private void initMainContent()
    {
        Sentence s2_1 = new Sentence("2_1","1. Ça veut dire: de la campagne. ");
        sentenceList.add(s2_1);

        Sentence s2_2 = new Sentence("2_2","2. Comme justement votre mère a besoin d'un peu de campagne. ");
        sentenceList.add(s2_2);

        Sentence s2_3 = new Sentence("2_3","3. J'ai donc loué de moitié avec l'oncle Jules. ");
        sentenceList.add(s2_3);

        Sentence s2_4 = new Sentence("2_4","4. Une villa dans la colline, et nous y passerons les grandes vacances. ");
        sentenceList.add(s2_4);

        Sentence s2_5 = new Sentence("2_5","5. Elle est où, cette villa? ");
        sentenceList.add(s2_5);

        Sentence s2_6 = new Sentence("2_6","6. Juste au bord d'un désert de garrigue. ");
        sentenceList.add(s2_6);

        Sentence s2_7 = new Sentence("2_7","7. Qui va d'aubagne jusqu'à Aix. ");
        sentenceList.add(s2_7);

        Sentence s2_8 = new Sentence("2_8","8. Elle est un vrai désert. ");
        sentenceList.add(s2_8);
    }

    @Override
    public void onBackPressed()
    {
        adapter.destroy();
        finish();
    }

}