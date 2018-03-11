package com.example.doublez;

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
import android.widget.VideoView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Content_1 extends AppCompatActivity
{

    private VideoView videoView=null;
    private List<Sentence> sentenceList=new ArrayList<>();
    private SentenceAdapter adapter;
    private int count;
    private MediaPlayer mediaPlayer;
    private Uri rawUri;
    private File recordFile;
    private Uri uri;
    private MediaRecorder mediaRecorder=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);

        //添加配音记录
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd    HH:mm:ss");
        RecentItem recentitem1=new RecentItem(df.format(date),"La Politique","60");
        recentitem1.save();

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


        // VdeoView
        videoView = (VideoView) findViewById(R.id.video_view1);
        //videoView.setMediaController(new MediaController(this));  // 播放器控制按钮
        Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_0);
        //rawUri = Uri.parse("http://t19p169001.imwork.net/doublez/a_0.mp4");
        videoView.setVideoURI(rawUri);
        videoView.start();
        videoView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                //Uri rawUri = Uri.parse("http://t19p169001.imwork.net/doublez/a_0.mp4");
                Uri rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_0);
                videoView.setVideoURI(rawUri);
                videoView.start();
                return false;
            }
        });


        //RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_content1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initSententce();
        adapter = new SentenceAdapter(sentenceList,Content_1.this,videoView);
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
                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_1s);
                videoView.setVideoURI(rawUri);
                videoView.start();
                //播放录音
                recordFile=new File("/mnt/sdcard", "1_1.aac");  // 指向音频文件
                uri = Uri.fromFile(recordFile);
                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
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
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_2s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                mediaPlayer.stop();
                                recordFile=new File("/mnt/sdcard", "1_2.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 3:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_3s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "1_3.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 4:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_4s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "1_4.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 5:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_5s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "1_5.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 6:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_6s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "1_6.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 7:
                                //播放视频
                                rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_7s);
                                videoView.setVideoURI(rawUri);
                                videoView.start();
                                //播放录音
                                recordFile=new File("/mnt/sdcard", "1_7.aac");  // 指向音频文件
                                uri = Uri.fromFile(recordFile);
                                mediaPlayer = MediaPlayer.create(Content_1.this, uri);
                                mediaPlayer.start();
                                count++;
                                break;
                            case 8:
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

    private void initSententce()
    {
        Sentence s1_1 = new Sentence("1_1","1. Un homme attend dans un café, un autre arrive, cela fait deux hommes. ");
        sentenceList.add(s1_1);

        Sentence s1_2 = new Sentence("1_2","2. Salut, mec. ");
        sentenceList.add(s1_2);

        Sentence s1_3 = new Sentence("1_3","3. Une serveuse s'approche des deux hommes. ");
        sentenceList.add(s1_3);

        Sentence s1_4 = new Sentence("1_4","4. Bojour. ");
        sentenceList.add(s1_4);

        Sentence s1_5 = new Sentence("1_5","5. Bonjour, je vais prendre un déca ");
        sentenceList.add(s1_5);

        Sentence s1_6 = new Sentence("1_6","6. Euh deux, s'il vous plaît. ");
        sentenceList.add(s1_6);

        Sentence s1_7 = new Sentence("1_7","7. Ils commandent de façon directive à la serveuse. ");
        sentenceList.add(s1_7);
    }

    @Override
    public void onBackPressed()
    {
        adapter.destroy();
        finish();
    }

}