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
import com.example.parini.scholastic_brackit.pkg_semContents.Subject;
import com.example.parini.scholastic_brackit.pkg_semester.Semester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * Created by parini on 13-11-2016.
 */

public class Java_Subjects extends AppCompatActivity
{
    private static String subject_name;
    Button add;
    protected int i;
    LinearLayout re;
    Java_Constant_User store_User = new Java_Constant_User();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        re = (LinearLayout)findViewById(R.id.sub_linearlayout);
        retrive_subjects();
        add = (Button)findViewById(R.id.sub_add);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialogopener();
            }
        });
    }

    public void retrive_subjects()
    {
        int arrlength;
        if(store_User.getLogin_signup().equals("SIGN"))
        {
            arrlength = 0;
        }
        else
        {
            Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
            Set keys = temp_User.retListSub(store_User.getprog_name(),store_User.getsem_num()).keySet();

            Object[] SubArr = keys.toArray();
            arrlength = SubArr.length;

            System.out.println(arrlength);
            for(int j =0;j<arrlength;j++)
            {
                String sub_name;
                final Button newbtn = new Button(this);
                sub_name = SubArr[j].toString();
                newbtn.setText(sub_name);

                int id = 0;
                for(int var=0;var<sub_name.length();var++)
                    id+=sub_name.charAt(var);

                newbtn.setId(id);
                newbtn.setBackgroundResource(R.drawable.border_button);
                newbtn.setPadding(100,10,100,10);
                newbtn.setTextColor(Color.BLACK);
                newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                newbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        store_User.setsub_name(newbtn.getText().toString());
                        Launch_Subject_Options();
                    }
                });
                re.addView(newbtn);
            }
        }
    }
    public void createnewbutton(String c)
    {



        final Button newbtn = new Button(this);
        newbtn.setText(subject_name);

        int id = 0;
        for(int var=0;var<c.length();var++)
            id+=c.charAt(var);

        newbtn.setId(id);
        newbtn.setBackgroundResource(R.drawable.border_button);
        newbtn.setPadding(100,10,100,10);
        newbtn.setTextColor(Color.BLACK);
        newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_User.setsub_name(newbtn.getText().toString());
                Launch_Subject_Options();
            }
        });
        re.addView(newbtn);
    }

    public void dialogopener(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_subjects_popup);

        Button ok = (Button)dialog.findViewById (R.id.ok_sub_popup);
        final EditText sub_name = (EditText)dialog.findViewById(R.id.editText9);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject_name = sub_name.getText().toString();
                User_Cllg_Sem_SubNode(subject_name);
                createnewbutton(subject_name);
                sub_name.setText("");
                sub_name.setHint("Enter subject name.");
                dialog.dismiss();

            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    public void Launch_Subject_Options()
    {
        startActivity(new Intent(Java_Subjects.this,Java_Subject_Details.class));
    }
    public void User_Cllg_Sem_SubNode(String S)
    {
        System.out.println("Sub in");
        Subject Sub = new Subject();
        Sub.setSubject_name(S);
        String kcllg = store_User.getprog_name();
        String ksem = store_User.getsem_num();
        System.out.println(kcllg);
        System.out.println(ksem);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.addsub(kcllg,ksem,S,Sub);
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
