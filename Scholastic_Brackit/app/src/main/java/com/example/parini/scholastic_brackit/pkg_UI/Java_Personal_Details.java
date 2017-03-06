package com.example.parini.scholastic_brackit.pkg_UI;

import android.content.Intent;
import android.content.PeriodicSync;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;
import com.example.parini.scholastic_brackit.pkg_studentDetails.PersonalDetails;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by parini on 12-11-2016.
 */

public class Java_Personal_Details extends AppCompatActivity
{
    EditText f_name;
    EditText l_name;
    EditText pincode;
    EditText country;
    EditText city;
    EditText contact;
    Button done;
    Spinner gender;
    Java_Constant_User store_User = new Java_Constant_User();

    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        f_name = (EditText)findViewById(R.id.personal_details_fname);
        l_name = (EditText)findViewById(R.id.personal_details_lname);
        gender = (Spinner)findViewById(R.id.personal_details_gender);
        pincode = (EditText)findViewById(R.id.personal_details_pincode);
        country = (EditText)findViewById(R.id.personal_details_country);
        city = (EditText)findViewById(R.id.personal_details_city);
        contact = (EditText)findViewById(R.id.personal_details_contact);
        done = (Button)findViewById(R.id.personal_details_btn_done);

        retrive_personal_details();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalDetailsSave(f_name.getText().toString(),l_name.getText().toString(),gender.getSelectedItem().toString(),pincode.getText().toString(),country.getText().toString(),city.getText().toString(),contact.getText().toString());
                Launch_Home();
            }
        });
    }

    public void retrive_personal_details()
    {
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        String[] temp_pd_details7 = temp_User.get_Details_PD();

        if(temp_pd_details7[0]!=null)
        {
            f_name.setText(temp_pd_details7[0]);
        }
        if(temp_pd_details7[1]!=null)
        {
            l_name.setText(temp_pd_details7[1]);
        }
        if(temp_pd_details7[2]!=null)
        {
            if(temp_pd_details7[2].equals("Male"))
                gender.setSelection(0);
            else if(temp_pd_details7[2].equals("Female"))
                gender.setSelection(1);
            else
                gender.setSelection(2);
        }
        if(temp_pd_details7[3]!=null)
        {
            pincode.setText(temp_pd_details7[3]);
        }
        if(temp_pd_details7[4]!=null)
        {
            country.setText(temp_pd_details7[4]);
        }
        if(temp_pd_details7[5]!=null)
        {
            city.setText(temp_pd_details7[5]);
        }
        if(temp_pd_details7[6]!=null)
        {
            contact.setText(temp_pd_details7[6]);
        }
    }

    public void Launch_Home()
    {
        startActivity(new Intent(Java_Personal_Details.this,Java_Homepage.class));
    }
    public void PersonalDetailsSave(String fname,String lname,String gen,String pin,String country,String city,String contact)
    {
        System.out.println("Pesonal Details in");
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.set_Data_PD(fname,lname,gen,pin,city,country,contact);


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
