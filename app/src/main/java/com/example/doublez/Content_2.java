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

    private double[] cepsb_1={2.79,1.69,1.61,0.71,0.50,0.57,-0.70,-0.01,0.38,-0.86,-0.94,-0.32};
    private double[] cepsb_2={2.32,3.56,1.68,-0.97,-0.39,-1.16,-0.45,0.53,-0.39,-1.29,-1.14,-0.79};
    private double[] cepsb_3={2.34,4.22,0.65,0.60,-0.04,0.09,-0.54,-0.77,1.17,0.22,-0.89,-0.91};
    private double[] cepsb_4={-0.33,5.23,0.69,0.45,0.16,-0.94,-0.72,-0.75,0.43,-0.85,-0.74,-0.40};
    private double[] cepsb_5={0.12,4.89,0.49,0.45,0.58,-0.05,-0.03,-1.47,-0.41,-0.48,-0.70,-0.63};
    private double[] cepsb_6={0.31,3.83,-1.24,-0.58,0.85,0.28,0.56,-0.59,0.56,-0.32,0.55,0.61};
    private double[] cepsb_7={1.05,2.98,1.03,-0.78,-1.89,0.47,-0.46,0.28,-0.18,0.09,-0.43,0.68};
    private double[] cepsb_8={-0.36,4.21,1.06,0.19,1.21,1.30,-0.02,-0.69,0.93,-0.85,-0.01,0.23};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_2);

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
                            double[] ceps2_1 = adapter.returnList().get(0).getThread().getCeps();
                            double[] ceps2_2 = adapter.returnList().get(1).getThread().getCeps();
                            double[] ceps2_3 = adapter.returnList().get(2).getThread().getCeps();
                            double[] ceps2_4 = adapter.returnList().get(3).getThread().getCeps();
                            double[] ceps2_5 = adapter.returnList().get(4).getThread().getCeps();
                            double[] ceps2_6 = adapter.returnList().get(5).getThread().getCeps();
                            double[] ceps2_7 = adapter.returnList().get(6).getThread().getCeps();
                            double[] ceps2_8 = adapter.returnList().get(7).getThread().getCeps();

                            // 算分
                            int score1 =0;
                            int score2 =0;
                            int score3 =0;

                            score1 += (int)Statistics.Score1(ceps2_1,cepsb_1);
                            score2 += (int)Statistics.Score2(ceps2_1,cepsb_1);
                            score3 += (int)Statistics.Score3(ceps2_1,cepsb_1);

                            score1 += (int)Statistics.Score1(ceps2_2,cepsb_2);
                            score2 += (int)Statistics.Score2(ceps2_2,cepsb_2);
                            score3 += (int)Statistics.Score3(ceps2_2,cepsb_2);

                            score1 += (int)Statistics.Score1(ceps2_3,cepsb_3);
                            score2 += (int)Statistics.Score2(ceps2_3,cepsb_3);
                            score3 += (int)Statistics.Score3(ceps2_3,cepsb_3);

                            score1 += (int)Statistics.Score1(ceps2_4,cepsb_4);
                            score2 += (int)Statistics.Score2(ceps2_4,cepsb_4);
                            score3 += (int)Statistics.Score3(ceps2_4,cepsb_4);

                            score1 += (int)Statistics.Score1(ceps2_5,cepsb_5);
                            score2 += (int)Statistics.Score2(ceps2_5,cepsb_5);
                            score3 += (int)Statistics.Score3(ceps2_5,cepsb_5);

                            score1 += (int)Statistics.Score1(ceps2_6,cepsb_6);
                            score2 += (int)Statistics.Score2(ceps2_6,cepsb_6);
                            score3 += (int)Statistics.Score3(ceps2_6,cepsb_6);

                            score1 += (int)Statistics.Score1(ceps2_7,cepsb_7);
                            score2 += (int)Statistics.Score2(ceps2_7,cepsb_7);
                            score3 += (int)Statistics.Score3(ceps2_7,cepsb_7);

                            score1 += (int)Statistics.Score1(ceps2_8,cepsb_8);
                            score2 += (int)Statistics.Score2(ceps2_8,cepsb_8);
                            score3 += (int)Statistics.Score3(ceps2_8,cepsb_8);

                            final int Score1=score1/8;
                            final int Score2=score2/8;
                            final int Score3=score3/8;


                            Log.d("Score1", Integer.toString(Score1));
                            Log.d("Score2", Integer.toString(Score2));
                            Log.d("Score3", Integer.toString(Score3));

                            // AlertDialog
                            AlertDialog.Builder dialog=new AlertDialog.Builder(Content_2.this);
                            dialog.setTitle("匹配结束");
                            dialog.setMessage("您的平均分数为："+Integer.toString(Score1));
                            dialog.setCancelable(true);
                            dialog.setPositiveButton("存储",new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    Date date=new Date();
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd    HH:mm:ss");
                                    RecentItem recentitem=new RecentItem(df.format(date),"la_gloire_de_mon_pere","La Gloire de mon Père 1",Integer.toString(Score1));
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
        finish();
        adapter.destroy();
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