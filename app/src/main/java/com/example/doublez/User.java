package com.example.doublez;

import org.litepal.crud.DataSupport;

public class User extends DataSupport
{
    private String username;
    private String email;
    private String password;

    public User(String username,String email,String password)
    {
        this.username=username;
        this.email=email;
        this.password=password;
    }
}
