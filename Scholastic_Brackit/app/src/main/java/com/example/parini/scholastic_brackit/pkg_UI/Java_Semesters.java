package com.example.parini.scholastic_brackit.pkg_UI;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parini.scholastic_brackit.R;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_Constant_User;
import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;
import com.example.parini.scholastic_brackit.pkg_semester.Semester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * Created by parini on 12-11-2016.
 */

public class Java_Semesters extends AppCompatActivity
{
    private static String sem_name;
    private static int i,j;
    Button add;
    Button sem_details;
    LinearLayout re;
    Java_Constant_User store_User = new Java_Constant_User();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesters);
        re = (LinearLayout)findViewById(R.id.linearlayout);
        add = (Button)findViewById(R.id.semseter_add);
        retrive_sem();
        sem_details = (Button)findViewById(R.id.semester_details);
        i=0;


        sem_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Java_Semesters.this, sem_details);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.sem_option_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                            Launch_Program_Details();
                        return true;
                    }
                });

                popup.show();
            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialogopener();
            }
        });
    }

    public void retrive_sem()
    {
        int arrlength;
        if(store_User.getLogin_signup().equals("SIGN"))
        {
            arrlength = 0;
        }
        else
        {
            Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
            Set keys = temp_User.retListSem(store_User.getprog_name()).keySet();

            Object[] SemArr = keys.toArray();
            arrlength = SemArr.length;

            System.out.println(arrlength);
            for (j = 0; j<arrlength; j++)
            {
                int semnum = Integer.parseInt(SemArr[j].toString());
                final Button newbtn = new Button(this);
                newbtn.setText("Semester "+ semnum);
                newbtn.setId(semnum);
                newbtn.setBackgroundResource(R.drawable.border_button);
                newbtn.setPadding(100,10,100,10);
                newbtn.setTextColor(Color.BLACK);
                newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                newbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        store_User.setsem_num(String.valueOf(newbtn.getText().toString().charAt(9)));
                        Launch_Semester_Options();
                    }
                });
                re.addView(newbtn);
            }
        }
    }
    public void createnewbutton(int c)
    {

        final Button newbtn = new Button(this);
        newbtn.setText("Semester " + c);
        newbtn.setId(c);
        newbtn.setBackgroundResource(R.drawable.border_button);
        newbtn.setPadding(100, 10, 100, 10);
        newbtn.setTextColor(Color.BLACK);
        newbtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_User.setsem_num(String.valueOf(newbtn.getText().toString().charAt(9)));
                Launch_Semester_Options();
            }
        });
        re.addView(newbtn);
    }

    public void dialogopener(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_semester_popup);

        Button ok = (Button)dialog.findViewById (R.id.button12);
        final EditText program_name = (EditText)dialog.findViewById(R.id.editText9);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sem_name = program_name.getText().toString();

                try
                {
                    i = Integer.parseInt(sem_name);
                    createnewbutton(i);
                    User_Cllg_SemNode(sem_name);
                    dialog.dismiss();
                }
                catch(Exception err)
                {
                    program_name.setText("");
                    program_name.setHint("Enter a Number!");
                }
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
    public void Launch_Program_Details()
    {
        startActivity(new Intent(Java_Semesters.this,Java_Program_Details.class));
    }
    public void Launch_Semester_Options()
    {
        startActivity(new Intent(Java_Semesters.this,Java_Semester_Options.class));
    }
    public void User_Cllg_SemNode(String S)
    {
        System.out.println("Sem in");
        Semester Sem = new Semester();
        Sem.setSem_no(S);
        String kcllg = store_User.getprog_name();
        System.out.println(kcllg);
        Java_TreeImplementation temp_User = store_User.getJava_TreeImplementation();
        temp_User.addsem(kcllg,S,Sem);
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
