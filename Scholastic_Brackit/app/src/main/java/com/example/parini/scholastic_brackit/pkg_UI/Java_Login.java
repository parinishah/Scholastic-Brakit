package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Java_Login extends AppCompatActivity
{
    protected Button login;
    protected Button signup;
    protected EditText username;
    protected EditText password;
    protected Java_TreeImplementation User;
    protected Java_Constant_User store_User = new Java_Constant_User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_signup);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login_login);
        signup = (Button) findViewById(R.id.login_signup);
        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Launch_Home();
                UserNode();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Launch_Signup();
            }
        });



    }
    public void Launch_Home()
    {
        Intent i = new Intent(Java_Login.this,Java_Homepage.class);
        startActivity(i);
    }
    public void Launch_Signup()
    {
        Intent i = new Intent(Java_Login.this,Java_SignUp.class);
        startActivity(i);
    }
     public void UserNode()
    {
        System.out.println("Login in");
        /*
        User = new Java_TreeImplementation();
        Java_Constant_User store_User = new Java_Constant_User();
        store_User.setJava_TreeImplementation(User);
        */

        /* Here is to be made */
        /* Extract Only Here */

        try
        {
            /*
            FileOutputStream fos = new FileOutputStream(getFilesDir()+"file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(temp_User);
            oos.close();
            */
//            System.out.println("Worked1");

            FileInputStream fis = new FileInputStream(getFilesDir()+"file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User = (Java_TreeImplementation) ois.readObject();
//            Java_TreeImplementation result = (Java_TreeImplementation) ois.readObject();
            ois.close();
            store_User.setJava_TreeImplementation(User);
            store_User.setLogin_signup("LOGIN");
//            System.out.println("Worked2");

//            result.display1("Btech","1","Dsa");
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }

    }
}
