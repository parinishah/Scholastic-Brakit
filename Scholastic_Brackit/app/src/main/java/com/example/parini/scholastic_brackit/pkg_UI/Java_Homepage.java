package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.parini.scholastic_brackit.R;


/**
 * Created by parini on 12-11-2016.
 */

public class Java_Homepage extends AppCompatActivity
{
    Button profile,academic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profile = (Button)findViewById(R.id.homepage_profile);
        academic = (Button)findViewById(R.id.homepage_academic);

        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Launch_Program();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Launch_Profile();
            }
        });

    }
    public void Launch_Program()
    {
        Intent i = new Intent(Java_Homepage.this,Java_Programs.class);
        startActivity(i);
    }
    public void Launch_Profile()
    {
        Intent i = new Intent(Java_Homepage.this,Java_Personal_Details.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
