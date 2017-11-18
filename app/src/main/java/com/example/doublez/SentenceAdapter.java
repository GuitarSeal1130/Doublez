package com.example.doublez;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.List;

public class SentenceAdapter extends RecyclerView.Adapter<SentenceAdapter.ViewHolder>
{
    private List<Sentence> sentenceList;
    private Activity activity;
    VideoView videoview;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View sentenceView;
        TextView sentenceText;
        Button sentenceRec;

        public ViewHolder (View view)
        {
            super(view);
            sentenceView=view;
            sentenceText=(TextView)view.findViewById(R.id.sentence_text);
            sentenceRec=(Button)view.findViewById(R.id.sentence_rec);
        }
    }

    public SentenceAdapter(List<Sentence> sentenceList,Activity activity,VideoView videoview)
    {
        this.sentenceList=sentenceList;
        this.activity=activity;
        this.videoview=videoview;
    }

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

                // 按Sentence的Text响应
                switch(sentence.getNum())
                {
                    case "1_1":
                        Uri rawUri1 = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_1);
                        videoview.setVideoURI(rawUri1);
                        videoview.start();
                        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                        {
                            @Override
                            public void onCompletion(MediaPlayer mp)
                            {
                                videoview.start();
                            }
                        });
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

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    //按下J'enregiste
                    switch(sentence.getNum())
                    {
                        case "1_1":
                            Uri rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.la_politique_1_s);
                            videoview.setVideoURI(rawUri);
                            videoview.start();
                            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                            {
                                @Override
                                public void onCompletion(MediaPlayer mp)
                                {}
                            });
                            break;
                        default:
                    }
                }
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    //抬起J'enregiste
                    switch(sentence.getNum())
                    {
                        case "1_1":
                            videoview.pause();
                            break;
                        default:
                    }
                }
                return false;
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
}
