package com.example.doublez;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SentenceAdapter extends RecyclerView.Adapter<SentenceAdapter.ViewHolder>
{
    private List<Sentence> sentenceList;
    private Activity activity;
    private VideoView videoView;
    private Uri rawUri;
    private MediaRecorder mediaRecorder;
    private File recordFile;
    private MediaPlayer mediaPlayer;
    private Uri uri;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View sentenceView;
        TextView sentenceText;
        Button sentenceRec;
        Button sentencePlay;

        public ViewHolder (View view)
        {
            super(view);
            sentenceView=view;
            sentenceText=(TextView)view.findViewById(R.id.sentence_text);
            sentenceRec=(Button)view.findViewById(R.id.sentence_rec);
            sentencePlay=(Button)view.findViewById(R.id.sentence_play);
        }
    }

    public SentenceAdapter(List<Sentence> sentenceList,Activity activity,VideoView videoview)
    {
        this.sentenceList=sentenceList;
        this.activity=activity;
        this.videoView =videoview;
    }

    @SuppressLint("ClickableViewAccessibility")
    public SentenceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sentence_item,parent,false);
        final SentenceAdapter.ViewHolder holder=new SentenceAdapter.ViewHolder(view);
        holder.sentenceView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                //停止播放录音
                if(mediaPlayer!=null)
                    mediaPlayer.stop();
                // 按Sentence的Text响应
                switch(sentence.getNum())
                {
                    case "1_1":
                        //播放视频
                        rawUri= Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_1);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_2":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_2);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_3":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_3);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_4":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_4);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_5":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_5);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_6":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_6);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_7":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_7);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;
                    default:
                }
            }
        });

        holder.sentenceRec.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                //按下J'enregiste
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    //停止播放录音
                    if(mediaPlayer!=null)
                        mediaPlayer.stop();
                    switch(sentence.getNum())
                    {
                        case "1_1":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_1.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_1_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_2":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_2.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_2_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_3":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_3.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_3_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_4":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_4.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_4_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_5":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_5.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_5_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_6":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_6.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_6_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_7":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "la_politique_7.amr");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_7_s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        default:
                    }
                }

                //抬起J'enregiste
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    if(mediaRecorder!=null)
                    {
                        //结束录音
                        mediaRecorder.stop();
                        mediaRecorder.reset();
                        mediaRecorder.release();
                        mediaRecorder = null;
                    }
                }
                return false;
            }


        });

        holder.sentencePlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                //停止播放录音
                if(mediaPlayer!=null)
                    mediaPlayer.stop();
                switch(sentence.getNum())
                {
                    case "1_1":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_1.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_1_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });
                        break;

                    case "1_2":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_2.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_2_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mediaPlayer.stop();
                            }
                        });
                        break;

                    case "1_3":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_3.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_3_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });
                        break;

                    case "1_4":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_4.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_4_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });
                        break;

                    case "1_5":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_5.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_5_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });
                        break;

                    case "1_6":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_6.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_6_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });

                        break;

                    case "1_7":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "la_politique_7.amr");  // 指向音频文件
                        uri = Uri.fromFile(recordFile);
                        mediaPlayer = MediaPlayer.create(activity, uri);
                        mediaPlayer.start();
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_7_s);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                mediaPlayer.stop();
                            }
                        });
                        break;
                }

            }
        });

        return holder;
    }

    public void onBindViewHolder(SentenceAdapter.ViewHolder holder, int position)
    {
        Sentence sentence=sentenceList.get(position);
        holder.sentenceText.setText(sentence.getText());
    }

    public int getItemCount()
    {
        return sentenceList.size();
    }

    public void destroy()
    {
        if(mediaPlayer!=null)
            mediaPlayer.stop();
    }
}
