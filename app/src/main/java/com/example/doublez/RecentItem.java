package com.example.doublez;

public class RecentItem
{
    private String id;
    private String date;
    private String content;
    private String score;

    public RecentItem(String id, String date, String content, String score)
    {
        this.id=id;
        this.date=date;
        this.content=content;
        this.score=score;
    }
    public String getId()
    {
        return this.id;
    }
    public String getDate()
    {
        return this.date;
    }
    public String getContent()
    {
        return this.content;
    }
    public String getScore()
    {
        return this.score;
    }
}
