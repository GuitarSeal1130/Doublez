package com.example.doublez;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Recent extends AppCompatActivity
{
    private List<RecentItem> recentitemList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent);

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RecyclerView
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_recent);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initRecentItem();
        RecentItemAdapter adapter=new RecentItemAdapter(recentitemList,Recent.this);
        recyclerView.setAdapter(adapter);
    }

    public void initRecentItem()
    {
        RecentItem r1=new RecentItem("1","2018.3.7","Apple","86");
        recentitemList.add(r1);
    }

    public void onBackPressed()
    {
        finish();
    }

}
