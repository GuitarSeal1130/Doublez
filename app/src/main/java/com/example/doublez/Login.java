package com.example.doublez;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends AppCompatActivity
{
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // EditText
        username=(EditText)findViewById(R.id.username_blank);
        password=(EditText)findViewById(R.id.password_blank);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());


        // Button
        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String inputUsername=username.getText().toString();
                String inputPassword=password.getText().toString();
                if(inputUsername.equals("admin") && inputPassword.equals("admin"))
                {
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    intent.putExtra("Username",inputUsername);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    // AlertDialog
                    AlertDialog.Builder dialog=new AlertDialog.Builder(Login.this);
                    dialog.setTitle("Username or Password not correct!");
                    dialog.setMessage("Please try again.");
                    dialog.setCancelable(true);
                    dialog.setPositiveButton("Okay",new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            EditText editText=(EditText)findViewById(R.id.password_blank);
                            editText.setText("");
                        }
                    });
                    dialog.show();
                }
            }
        });

        ImageView doublez=(ImageView)findViewById(R.id.main_logo);
        doublez.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView signup=(TextView)findViewById(R.id.login_signup);
        signup.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);
                finish();
            }
        });
    }

}