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
import com.example.parini.scholastic_brackit.pkg_semContents.Subject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by parini on 13-11-2016.
 */

public class Java_Subject_Details extends AppCompatActivity
{
    Button save;
    EditText subject_name,subject_faculty,subject_obtainedgrades,subject_totalgrades;
    Java_Constant_User store_User = new Java_Constant_User();
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        save = (Button)findViewById(R.id.subject_det_save);
        subject_name = (EditText)findViewById(R.id.subject_det_subname);
        subject_faculty = (EditText)findViewById(R.id.subject_det_faculty);
        subject_obtainedgrades = (EditText)findViewById(R.id.subject_det_obtainedgrades);
        subject_totalgrades = (EditText)findViewById(R.id.subject_det_totalgrades);

        retrive_sub_details();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubDetailsSave(subject_name.getText().toString(),subject_faculty.getText().toString(),subject_obtainedgrades.getText().toString(),subject_totalgrades.getText().toString());
                Launch_subject();
            }
        });

    }
    public void retrive_sub_details()
    {
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        String[] temp_sub_details4 = temp_User.get_Details_Sub(store_User.getprog_name(),store_User.getsem_num(),store_User.getsub_name());

        if (temp_sub_details4[0] != null)
        {
            subject_name.setText(temp_sub_details4[0]);
        }
        if (temp_sub_details4[1] != null)
        {
            subject_faculty.setText(temp_sub_details4[1]);
        }
        if (temp_sub_details4[2] != null)
        {
            subject_obtainedgrades.setText(temp_sub_details4[2]);
        }
        if (temp_sub_details4[3] != null)
        {
            subject_totalgrades.setText(temp_sub_details4[3]);
        }
    }

    public void Launch_subject()
    {
       this.onBackPressed();
    }

    public void SubDetailsSave(String subname,String profname,String subobtaingrade,String subtotalgrade)
    {
        System.out.println("Subjects Details in");
        Subject Sub = new Subject();
        Sub.setSubject(subname,profname,subobtaingrade,subtotalgrade);
        String kcllg = store_User.getprog_name();
        String ksem = store_User.getsem_num();
        String ksub = store_User.getsub_name();
        System.out.println(kcllg);
        System.out.println(ksem);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.addsub(kcllg,ksem,ksub,Sub);
        store_User.setJava_TreeImplementation(temp_User);

//        temp_User.display1("Btech","1","Dsa");


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
