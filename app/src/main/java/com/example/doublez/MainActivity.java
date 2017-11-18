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
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
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
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initMainContent();
        MainContentAdapter adapter=new MainContentAdapter(maincontentList,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    private void initMainContent()
    {
        MainContent a=new MainContent("1","La Polituque",R.drawable.la_politique);
        maincontentList.add(a);

        MainContent b=new MainContent("2","Banana",R.drawable.banana_pic);
        maincontentList.add(b);

        MainContent c=new MainContent("3","Cherry",R.drawable.cherry_pic);
        maincontentList.add(c);

        MainContent d=new MainContent("4","Lemond",R.drawable.lemond_pic);
        maincontentList.add(d);

        MainContent e=new MainContent("5","Mango",R.drawable.mango_pic);
        maincontentList.add(e);

        MainContent f=new MainContent("6","Melon",R.drawable.melon_pic);
        maincontentList.add(f);;

        MainContent g=new MainContent("7","Pear",R.drawable.pear_pic);
        maincontentList.add(g);

        MainContent h=new MainContent("8","Pineapple",R.drawable.pineapple_pic);
        maincontentList.add(h);

        MainContent i=new MainContent("9","Strawberry",R.drawable.strawberry_pic);
        maincontentList.add(i);

        MainContent j=new MainContent("10","Apple",R.drawable.apple_pic);
        maincontentList.add(j);

        MainContent k=new MainContent("11","Banana",R.drawable.banana_pic);
        maincontentList.add(k);

        MainContent l=new MainContent("12","Cherry",R.drawable.cherry_pic);
        maincontentList.add(l);

        MainContent m=new MainContent("13","Lemond",R.drawable.lemond_pic);
        maincontentList.add(m);

        MainContent n=new MainContent("14","Mango",R.drawable.mango_pic);
        maincontentList.add(n);

        MainContent o=new MainContent("15","Melon",R.drawable.melon_pic);
        maincontentList.add(o);;

        MainContent p=new MainContent("16","Pear",R.drawable.pear_pic);
        maincontentList.add(p);

        MainContent q=new MainContent("17","Pineapple",R.drawable.pineapple_pic);
        maincontentList.add(q);

        MainContent r=new MainContent("18","Strawberry",R.drawable.strawberry_pic);
        maincontentList.add(r);
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}