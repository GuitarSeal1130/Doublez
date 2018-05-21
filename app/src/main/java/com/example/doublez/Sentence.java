package com.example.doublez;


public class Sentence
{
    private String num;
    private String text;
    private ReadAACFileThread audioThread=null;

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

    public void thread(String filename)
    {
        this.audioThread=new ReadAACFileThread(filename);
        this.audioThread.start();
    }

    public ReadAACFileThread getThread()
    {
        return this.audioThread;
    }

}
