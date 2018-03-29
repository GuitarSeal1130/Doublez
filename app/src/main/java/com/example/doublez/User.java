package com.example.doublez;

import android.graphics.Bitmap;

import org.litepal.crud.DataSupport;

public class User extends DataSupport
{
    private String username;
    private String email;
    private String password;
    private byte[] avatar;

    public User(String username,String email,String password,byte[] avatar)
    {
        this.username=username;
        this.email=email;
        this.password=password;
        this.avatar=avatar;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public byte[] getavatarBMP()
    {
        return this.avatar;
    }
}
