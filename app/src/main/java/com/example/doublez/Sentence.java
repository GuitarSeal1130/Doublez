package com.example.doublez;


public class Sentence
{
    private String num;
    private String text;

    public Sentence(String num,String text)
    {
        this.num=num;
        this.text=text;
    }

    public String getNum()
    {
        return this.num;
    }

    public String getText()
    {
        return this.text;
    }

}
