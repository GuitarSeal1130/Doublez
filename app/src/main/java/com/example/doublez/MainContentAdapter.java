package com.example.doublez;

import android.app.Activity;
import android.content.Intent;
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
    private Activity activity;

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

    public MainContentAdapter(List<MainContent> mainContentList,Activity activity)
    {
        this.mainContentList=mainContentList;
        this.activity=activity;
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
                // Item的Text响应
                switch(maincontent.getNum())
                {
                    case "1":
                        Intent intent1=new Intent(activity,Content_1.class);
                        activity.startActivity(intent1);
                        break;
                    case "2":
                        Intent intent2=new Intent(activity,Content_2.class);
                        activity.startActivity(intent2);
                        break;
                    case "3":
                        Toast.makeText(activity,"尚未开放！", Toast.LENGTH_SHORT).show();
                        break;
                    case "4":
                        Toast.makeText(activity,"尚未开放！", Toast.LENGTH_SHORT).show();
                        break;
                    case "5":
                        Toast.makeText(activity,"尚未开放！", Toast.LENGTH_SHORT).show();
                        break;
                    case "6":
                        Toast.makeText(activity,"尚未开放！", Toast.LENGTH_SHORT).show();
                        break;
                    case "7":
                        Toast.makeText(activity,"尚未开放！", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
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