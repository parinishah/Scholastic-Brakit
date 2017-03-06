package com.example.parini.scholastic_brackit.pkg_data_structure;

/**
 * Created by Abhik on 14-11-2016.
 */

public class Java_Constant_User
{
    protected static Java_TreeImplementation temp;
    protected static String prog_name;
    protected static String sem_num;
    protected static String sub_num;
    protected static String login_signup;

    public String getLogin_signup()
    {
        return login_signup;
    }

    public void setLogin_signup(String login_signup)
    {
        this.login_signup = login_signup;
    }


    public void setJava_TreeImplementation(Java_TreeImplementation temp)
    {
        this.temp = temp;
    }

    public Java_TreeImplementation getJava_TreeImplementation()
    {
        return temp;
    }

    public void setprog_name(String pname)
    {
        this.prog_name = pname;
    }

    public String getprog_name()
    {
        return prog_name;
    }

    public void setsem_num(String sename)
    {
        this.sem_num = sename;
    }

    public String getsem_num()
    {
        return sem_num;
    }

    public void setsub_name(String suname)
    {
        this.sub_num = suname;
    }

    public String getsub_name()
    {
        return sub_num;
    }

}
