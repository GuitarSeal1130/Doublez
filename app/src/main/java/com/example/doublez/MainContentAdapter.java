package com.example.doublez;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainContentAdapter extends RecyclerView.Adapter<MainContentAdapter.ViewHolder>
{

    private List<MainContent> mainContentList;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View mainContentView;
        ImageView mainContentImage;
        TextView mainContentName;

        public ViewHolder (View view)
        {
            super(view);
            mainContentView=view;
            mainContentImage=(ImageView)view.findViewById(R.id.maincontent_image);
            mainContentName=(TextView)view.findViewById(R.id.maincontent_name);
        }
    }

    public MainContentAdapter(List<MainContent> mainContentList)
    {
        this.mainContentList=mainContentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.maincontent_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.mainContentView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                MainContent maincontent=mainContentList.get(position);
                //Item响应
                Toast.makeText(v.getContext(),"You clicked text "+maincontent.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.mainContentImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                MainContent maincontent=mainContentList.get(position);
                //Item响应
                Toast.makeText(v.getContext(),"You clicked image "+maincontent.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position)
    {
        MainContent maincontent=mainContentList.get(position);
        holder.mainContentImage.setImageResource(maincontent.getId());
        holder.mainContentName.setText(maincontent.getName());
    }

    @Override
    public int getItemCount()
    {
        return mainContentList.size();
    }

}
