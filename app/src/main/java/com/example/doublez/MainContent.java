package com.example.doublez;


public class MainContent
{

    private String Num;
    private String Name;
    private int Id;

    public MainContent(String Num,String Name, int Id)
    {
        this.Num=Num;
        this.Name=Name;
        this.Id=Id;
    }

    public String getNum()
    {
        return this.Num;
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