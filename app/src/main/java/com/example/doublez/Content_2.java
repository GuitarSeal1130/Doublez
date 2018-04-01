package com.example.doublez;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Content_2 extends AppCompatActivity
{

    private Uri rawUri;
    private VideoView videoView=null;
    private List<Sentence> sentenceList=new ArrayList<>();
    private SentenceAdapter adapter;
    private File recordFile;
    private MediaPlayer mediaPlayer=null;
    private Uri uri;
    private MediaRecorder mediaRecorder=null;
    private int amount=8;
    private int a=0;
    private ReadAACFileThread audioThread;

    private double[] ceps2_2=new double[13];
    private double[] cepsb_2={0,-1.0609,-1.1623,0.9289,0.0196,-0.1308,-0.0285,0.2883,0.1368,-0.2297,-0.7038,-0.0999,0.4408};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_2);

        //添加配音记录


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
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_content2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initSentence();
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

                // 开始计算的线程
                if (audioThread == null || !audioThread.isAlive())
                {
                    audioThread = new ReadAACFileThread("2_2.aac");
                    audioThread.start();
                }

                a=1;
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

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    //@Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        a++;
                        if(a<=amount)
                        {
                            //停止播放录音
                            if (mediaPlayer != null)
                                mediaPlayer.stop();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + getPackageName() + "/" + getResource("b_" + Integer.toString(a) + "s"));
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            //播放录音
                            recordFile = new File("/mnt/sdcard", "2_" + Integer.toString(a) + ".aac");  // 指向音频文件
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(Content_2.this, uri);
                            mediaPlayer.start();
                        }
                        else if(a==amount+1)
                        {
                            if (audioThread != null || !audioThread.isAlive())
                            {
                                ceps2_2 = audioThread.getCeps();
                                for (int i = 1; i < 13; i++)
                                    Log.d("Ceps", Double.toString(ceps2_2[i]));

                                //从这里开始
                                final int score1 =(int)Statistics.Score1(ceps2_2,cepsb_2);
                                final int score2 =(int)Statistics.Score2(ceps2_2,cepsb_2);
                                Log.d("Score1", Integer.toString(score1));
                                Log.d("Score2", Integer.toString(score2));

                                // AlertDialog
                                AlertDialog.Builder dialog=new AlertDialog.Builder(Content_2.this);
                                dialog.setTitle("匹配结束");
                                dialog.setMessage("您的平均分数为："+Integer.toString(score1));
                                dialog.setCancelable(true);
                                dialog.setPositiveButton("存储",new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        Date date=new Date();
                                        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd    HH:mm:ss");
                                        RecentItem recentitem=new RecentItem(df.format(date),"la_gloire_de_mon_pere","La Gloire de mon Père 1",Integer.toString(score1));
                                        recentitem.save();
                                    }
                                });
                                dialog.setNegativeButton("放弃",new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {

                                    }
                                });
                                dialog.show();
                            }
                            else
                                audioThread=null;


                        }

                    }
                });


                break;

            default:
        }
        return true;
    }

    private void initSentence()
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
        audioThread=null;
        finish();
    }

    public int  getResource(String imageName){
        Class raw = R.raw.class;
        try {
            Field field = raw.getField(imageName);
            return field.getInt(imageName);
        } catch (NoSuchFieldException e) {
            return 0;
        } catch (IllegalAccessException e) {
            return 0;
        }
    }

}