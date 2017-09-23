package com.example.doublez;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{

    private List<MainContent> maincontentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        //DrawerLayout 点击按钮打开菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
            {
                switch(item.getItemId())
                {
                    case R.id.nav_1:
                        Toast.makeText(MainActivity.this,"排行榜", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_2:
                        Toast.makeText(MainActivity.this,"最近配音", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_3:
                        Intent intent=new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //RecyclerView
        initMainContent();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainContentAdapter adapter=new MainContentAdapter(maincontentList,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    private void initMainContent()
    {
        for(int i=0;i<=1;i++)
        {
            MainContent apple=new MainContent("Apple",R.drawable.apple_pic);
            maincontentList.add(apple);

            MainContent banana=new MainContent("Banana",R.drawable.banana_pic);
            maincontentList.add(banana);

            MainContent cherry=new MainContent("Cherry",R.drawable.cherry_pic);
            maincontentList.add(cherry);

            MainContent lemond=new MainContent("Lemond",R.drawable.lemond_pic);
            maincontentList.add(lemond);

            MainContent mango=new MainContent("Mango",R.drawable.mango_pic);
            maincontentList.add(mango);

            MainContent melon=new MainContent("Melon",R.drawable.melon_pic);
            maincontentList.add(melon);;

            MainContent pear=new MainContent("Pear",R.drawable.pear_pic);
            maincontentList.add(pear);

            MainContent pineapple=new MainContent("Pineapple",R.drawable.pineapple_pic);
            maincontentList.add(pineapple);

            MainContent strawberry=new MainContent("Strawberry",R.drawable.strawberry_pic);
            maincontentList.add(strawberry);
        }
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}