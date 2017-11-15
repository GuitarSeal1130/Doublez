package com.example.doublez;


public class MainContent
{

    private String Name;
    private int Id;

    public MainContent(String Name, int Id)
    {
        this.Name=Name;
        this.Id=Id;
    }

    public String getName()
    {
        return this.Name;
    }


    public int getId()
    {
        return this.Id;
    }

}