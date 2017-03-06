package com.example.parini.scholastic_brackit.pkg_UI;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;
import com.example.parini.scholastic_brackit.pkg_studentDetails.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * Created by parini on 12-11-2016.
 */

public class Java_Programs extends AppCompatActivity
{
    private static String prog_name;
    Button add;
    Java_Constant_User store_User = new Java_Constant_User();
    LinearLayout re;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        re = (LinearLayout)findViewById(R.id.linearlayout);
        retrive_progs();
        add =(Button)findViewById(R.id.programs_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogopener();
            }
        });
    }

    public void retrive_progs()
    {
        int arrlength;
        if(store_User.getLogin_signup().equals("SIGN"))
        {
            arrlength = 0;
        }
        else
        {
            Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
            Set keys = temp_User.retListProg().keySet();

            Object[] ProgArr = keys.toArray();
            arrlength = ProgArr.length;

            System.out.println(arrlength);
            for(int j =0; j<arrlength;j++)
            {
                String p_name;
                final Button newbtn = new Button(this);
                p_name = ProgArr[j].toString();
                newbtn.setText(p_name);
                newbtn.setVisibility(View.VISIBLE);

                int id=0;
                for (int var = 0; var < p_name.length(); var++)
                    id += p_name.charAt(var);
                newbtn.setId(id);
                newbtn.setBackgroundResource(R.drawable.border_button);
                newbtn.setPadding(100, 10, 100, 10);
                newbtn.setTextColor(Color.BLACK);
                newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                re.addView(newbtn);

                newbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        store_User.setprog_name(newbtn.getText().toString());
                        Launch_Semester();

                    }
                });
            }

        }
    }

    public void createnewbutton(String c)
    {
        final Button newbtn = new Button(this);
        newbtn.setText(c);
        newbtn.setVisibility(View.VISIBLE);


        int id;
        id=0;
        for (int var = 0; var < c.length(); var++)
            id += c.charAt(var);
        newbtn.setId(id);
        newbtn.setBackgroundResource(R.drawable.border_button);
        newbtn.setPadding(100, 10, 100, 10);
        newbtn.setTextColor(Color.BLACK);
        newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        re.addView(newbtn);

        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_User.setprog_name(newbtn.getText().toString());
                Launch_Semester();

            }
        });
    }

    public void dialogopener(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_program_popup);

        Button ok = (Button)dialog.findViewById (R.id.button12);
        final EditText program_name = (EditText)dialog.findViewById(R.id.editText9);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog_name = program_name.getText().toString();

                User_CllgNode(prog_name);
                createnewbutton(prog_name);

                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
    public void Launch_Semester()
    {
        startActivity(new Intent(Java_Programs.this,Java_Semesters.class));
    }
    public void User_CllgNode(String S)
    {
        System.out.println("Prog in");
        College cllg = new College();
        cllg.setClg_programme(S);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.insert(S,cllg);
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
