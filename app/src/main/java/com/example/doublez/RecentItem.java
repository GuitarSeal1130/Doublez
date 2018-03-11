package com.example.doublez;

import org.litepal.crud.DataSupport;

public class RecentItem extends DataSupport
{
    private String date;
    private String content;
    private String score;

    public RecentItem(String date, String content, String score)
    {
        this.date=date;
        this.content=content;
        this.score=score;
    }
    public String getDate()
    {
        return date;
    }
    public String getContent()
    {
        return content;
    }
    public String getScore()
    {
        return score;
    }
}
