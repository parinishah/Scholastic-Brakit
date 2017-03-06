package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by parini on 12-11-2016.
 */

public class Java_SignUp extends AppCompatActivity
{
    Button register;
    EditText username,email,password,re_password;
    protected Java_TreeImplementation User;
    protected Java_Constant_User store_User = new Java_Constant_User();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        register = (Button)findViewById(R.id.signup_register);
        username = (EditText)findViewById(R.id.signup_username);
        email = (EditText)findViewById(R.id.signup_email);
        password = (EditText)findViewById(R.id.signup_password);
        re_password = (EditText)findViewById(R.id.signup_re_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                UserNode(username.getText().toString(),email.getText().toString(),password.getText().toString());
                Intent i = new Intent(Java_SignUp.this,Java_Homepage.class);
                startActivity(i);
            }
        });
    }

    public void UserNode(String usrname,String email,String pass)
    {
        System.out.println("SignUp in");
        User = new Java_TreeImplementation();
        User.set_Data_PD_SignUp(usrname,email,pass);
        store_User.setJava_TreeImplementation(User);
        store_User.setLogin_signup("SIGN");

        /* Here is to be made */

        try
        {
            FileOutputStream fos = new FileOutputStream(getFilesDir()+"file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(User);
            oos.close();

//            System.out.println("Worked1");

            /*
            FileInputStream fis = new FileInputStream(getFilesDir()+"file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Java_TreeImplementation result = (Java_TreeImplementation) ois.readObject();
            ois.close();
            */
//            System.out.println("Worked2");

//            result.display1("Btech","1","Dsa");
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }

    }
}

