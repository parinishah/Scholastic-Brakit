package com.example.parini.scholastic_brackit.pkg_data_base;

import android.app.Activity;
import android.app.Notification;

import com.example.parini.scholastic_brackit.pkg_data_structure.Java_TreeImplementation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Abhik on 22-11-2016.
 */

public class Java_temp_txt_store extends Activity
{
    public void to_file(Java_TreeImplementation storefileUSER)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(getFilesDir()+"file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(storefileUSER);
            oos.close();
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
    }

    public Java_TreeImplementation from_file()
    {
        try
        {
            FileInputStream fis = new FileInputStream(getFilesDir()+"file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Java_TreeImplementation result = (Java_TreeImplementation) ois.readObject();
            ois.close();

            return result;
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        return null;
    }

}

