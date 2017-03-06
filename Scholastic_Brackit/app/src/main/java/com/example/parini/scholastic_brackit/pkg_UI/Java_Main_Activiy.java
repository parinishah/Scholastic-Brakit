package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.parini.scholastic_brackit.R;

/**
 * Created by parini on 12-11-2016.
 */

public class Java_Main_Activiy extends AppCompatActivity
{
    LinearLayout first_layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        first_layout = (LinearLayout)findViewById(R.id.first_tap);
        first_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Launch_Login();
            }
        });
    }
    public void Launch_Login()
    {
        Intent i = new Intent(Java_Main_Activiy.this,Java_Login.class);
        startActivity(i);
    }
}