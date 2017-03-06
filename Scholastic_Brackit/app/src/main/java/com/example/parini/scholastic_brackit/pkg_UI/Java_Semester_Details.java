package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;
import com.example.parini.scholastic_brackit.pkg_semester.Semester;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by parini on 13-11-2016.
 */

public class Java_Semester_Details extends AppCompatActivity
{
    Button sem_det_save;
    EditText sem_det_gpa,sem_det_cgpa,sem_det_totalgpa,sem_det_totalcgpa;
    Java_Constant_User store_User = new Java_Constant_User();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_details);

        sem_det_save = (Button) findViewById(R.id.sem_det_save);
        sem_det_gpa = (EditText) findViewById(R.id.sem_det_gpa);
        sem_det_cgpa = (EditText) findViewById(R.id.sem_det_cgpa);
        sem_det_totalgpa = (EditText) findViewById(R.id.sem_det_totalgpa);
        sem_det_totalcgpa = (EditText) findViewById(R.id.sem_det_totalcgpa);

        retrive_sem_details();

        sem_det_save. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemDetailsSave(store_User.getsem_num(),sem_det_gpa.getText().toString(),sem_det_totalgpa.getText().toString(),sem_det_cgpa.getText().toString(),sem_det_totalcgpa.getText().toString());
                Launch_Semester_Options();
            }
        });
    }

    public void retrive_sem_details()
    {
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        String[] temp_sem_details4 = temp_User.get_Details_Sem(store_User.getprog_name(),store_User.getsem_num());

        if (temp_sem_details4[0] != null) {
            sem_det_gpa.setText(temp_sem_details4[0]);
        }
        if (temp_sem_details4[1] != null) {
            sem_det_totalgpa.setText(temp_sem_details4[1]);
        }
        if (temp_sem_details4[2] != null) {
            sem_det_cgpa.setText(temp_sem_details4[2]);
        }
        if (temp_sem_details4[3] != null) {
            sem_det_totalcgpa.setText(temp_sem_details4[3]);
        }
    }

    public void Launch_Semester_Options()
    {
      this.onBackPressed();
    }

  /*  public void Launch_Semester_Options()
    {
        startActivity(new Intent(Java_Semester_Details.this,Java_Semester_Options.class));
    }*/
    public void SemDetailsSave(String semnum ,String gpa,String totalgpa,String cgpa,String totalcgpa)
    {
        System.out.println("Subjects Details in");
        Semester Sem = new Semester();
        Sem.setSemester(semnum,gpa,totalgpa,cgpa,totalcgpa);
        String kcllg = store_User.getprog_name();
        String ksem = store_User.getsem_num();
        System.out.println(kcllg);
        System.out.println(ksem);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.addsem(kcllg,ksem,Sem);
        store_User.setJava_TreeImplementation(temp_User);


        /* Here is to be made */

        try
        {
            FileOutputStream fos = new FileOutputStream(getFilesDir()+"file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(temp_User);
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

