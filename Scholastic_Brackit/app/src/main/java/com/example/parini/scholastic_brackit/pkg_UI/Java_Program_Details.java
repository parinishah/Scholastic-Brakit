package com.example.parini.scholastic_brackit.pkg_UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;
import com.example.parini.scholastic_brackit.pkg_studentDetails.College;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by parini on 13-11-2016.
 */

public class Java_Program_Details extends AppCompatActivity
{
    Button save;
    EditText prog_det_name,prog_det_field,prog_det_college,prog_det_univ,prog_det_enrollnum,prog_det_enrollyear,prog_det_passyear;
    Java_Constant_User store_User = new Java_Constant_User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog_uni_details);

        save= (Button)findViewById(R.id.prog_det_save);
        prog_det_name= (EditText)findViewById(R.id.prog_det_progname);
        prog_det_field= (EditText)findViewById(R.id.prog_det_field);
        prog_det_college= (EditText)findViewById(R.id.prog_det_college);
        prog_det_univ= (EditText)findViewById(R.id.prog_det_university);
        prog_det_enrollnum= (EditText)findViewById(R.id.prog_det_enrollnum);
        prog_det_enrollyear= (EditText)findViewById(R.id.prog_det_enrollyear);
        prog_det_passyear= (EditText)findViewById(R.id.prog_det_passyear);

        retrive_cllg_details();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgDetailsSave(prog_det_name.getText().toString(),prog_det_field.getText().toString(),prog_det_college.getText().toString(),prog_det_univ.getText().toString(),prog_det_enrollnum.getText().toString(),prog_det_enrollyear.getText().toString(),prog_det_passyear.getText().toString());
                Back_to_Semester();
            }
        });
    }

    public void retrive_cllg_details()
    {
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        String[] temp_cllg_details7 = temp_User.get_Details_Cllg(store_User.getprog_name());

        if(temp_cllg_details7[0]!=null)
        {
            prog_det_name.setText(temp_cllg_details7[0]);
        }
        if(temp_cllg_details7[1]!=null)
        {
            prog_det_field.setText(temp_cllg_details7[1]);
        }
        if(temp_cllg_details7[2]!=null)
        {
            prog_det_college.setText(temp_cllg_details7[2]);
        }
        if(temp_cllg_details7[3]!=null)
        {
            prog_det_univ.setText(temp_cllg_details7[3]);
        }
        if(temp_cllg_details7[4]!=null)
        {
            prog_det_enrollnum.setText(temp_cllg_details7[4]);
        }
        if(temp_cllg_details7[5]!=null)
        {
            prog_det_enrollyear.setText(temp_cllg_details7[5]);
        }
        if(temp_cllg_details7[6]!=null)
        {
            prog_det_passyear.setText(temp_cllg_details7[6]);
        }
    }

    public void Back_to_Semester()
    {
        this.onBackPressed();
    }

    public void ProgDetailsSave(String progname,String fieldname,String cllgname,String univname,String enrollnum,String enrollyear,String passingyear)
    {
        System.out.println("Program Details in");
        College Cllg = new College();
        Cllg.setCollege(progname,fieldname,cllgname,univname,enrollnum,enrollyear,passingyear,false);
        String kcllg = store_User.getprog_name();
        System.out.println(kcllg);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.insert(kcllg,Cllg);
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
