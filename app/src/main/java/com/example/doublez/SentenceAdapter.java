package com.example.doublez;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SentenceAdapter extends RecyclerView.Adapter<SentenceAdapter.ViewHolder>
{
    private List<Sentence> sentenceList;
    private Activity activity;

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

    public SentenceAdapter(List<Sentence> sentenceList,Activity activity)
    {
        this.sentenceList=sentenceList;
        this.activity=activity;
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
                // Item的Text响应
                switch(sentence.getNum())
                {
                    case "Apple":
                        Intent intent=new Intent(activity,Content_1.class);
                        activity.startActivity(intent);
                        break;
                    default:
                }
            }
        });
        holder.sentenceRec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                // Item的Rec按钮响应
                switch(sentence.getNum())
                {
                    case "Apple":
                        Intent intent=new Intent(activity,Content_1.class);
                        activity.startActivity(intent);
                        break;
                    default:
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
}
