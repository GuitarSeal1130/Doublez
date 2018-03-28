package com.example.doublez;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity
{
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText repassword;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_r);
        setSupportActionBar(toolbar);

        username=(EditText)findViewById(R.id.signup_username);
        email=(EditText)findViewById(R.id.signup_email);
        password=(EditText)findViewById(R.id.signup_password);
        repassword=(EditText)findViewById(R.id.signup_repassword);
        // 密码星号化
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        repassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        Button signup=(Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(password.getText().toString().equals(repassword.getText().toString()))
                {
                    // 计入数据库，释放Activit
                    Intent intent=new Intent(Signup.this,Login.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    // AlertDialog
                    AlertDialog.Builder dialog=new AlertDialog.Builder(Signup.this);
                    dialog.setTitle("密码不一致");
                    dialog.setMessage("请重新输入");
                    dialog.setCancelable(true);
                    dialog.setPositiveButton("好",new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            password.setText("");
                            repassword.setText("");
                        }
                    });
                    dialog.show();
                }
            }
        });
    }
}
