package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.parini.scholastic_brackit.R;

/**
 * Created by parini on 13-11-2016.
 */

public class Java_Semester_Options extends AppCompatActivity
{
    Button options_subdets,options_subject,options_project,options_certificate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_options);

        options_subdets = (Button)findViewById(R.id.semester_options_semdets);
        options_subject = (Button)findViewById(R.id.semester_options_subject);
        options_certificate = (Button)findViewById(R.id.semester_options_certificate);
        options_project = (Button)findViewById(R.id.semester_options_project);

         options_subdets.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Launch_Semester_Details();
             }
         });
        options_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Launch_Subject();
            }
        });

    }
    public void Launch_Semester_Details()
    {
        startActivity(new Intent(Java_Semester_Options.this,Java_Semester_Details.class));
    }
    public void Launch_Subject()
    {
        startActivity(new Intent(Java_Semester_Options.this,Java_Subjects.class));
    }
}
