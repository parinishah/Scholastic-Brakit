package com.example.parini.scholastic_brackit.pkg_data_structure;

import com.example.parini.scholastic_brackit.pkg_studentDetails.*;
import com.example.parini.scholastic_brackit.pkg_semester.*;
import com.example.parini.scholastic_brackit.pkg_semContents.*;

import java.io.*;
import java.util.*;

public class Java_TreeImplementation implements Serializable
{
	HashMap <String,College> StrCllg;
	HashMap <College,Data_Cllg> Cllg;
	PersonalDetails Data_PD; 
	
	public Java_TreeImplementation()
	{
		StrCllg = new HashMap<String,College>();
		Cllg = new HashMap<College,Data_Cllg>();
		Data_PD = new PersonalDetails();
	}	
	
	public void set_Data_PD(String pd_fname,String pd_lname,String pd_gender,String pd_pinCode,String pd_city,String pd_country,String pd_contact)
	{
		Data_PD.setPersonalDetails(pd_fname, pd_lname, pd_gender, pd_pinCode, pd_city, pd_country, pd_contact);
	}
	public void set_Data_PD_SignUp(String pd_usrname,String pd_email,String pd_password)
	{
		Data_PD.setSignUpDetails(pd_usrname,pd_email,pd_password);
	}

	public void insert(String k,College cllg)
	{
		Data_Cllg Cllg_temp = new Data_Cllg();
		this.StrCllg.put(k,cllg);
		this.Cllg.put(cllg,Cllg_temp);
	}
	
	public void addsem(String kcllg,String ksem,Semester sem)
	{
		College Cllg_temp = this.StrCllg.get(kcllg);
		Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);
		Data_Cllg_temp.insert(ksem,sem);
	}
	
	public void addsub(String kcllg,String ksem,String ksub,Subject sub)
	{
		College Cllg_temp = this.StrCllg.get(kcllg);
		Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);
		Data_Cllg_temp.addsub(ksem, ksub, sub);
	}

	public void display1(String kcllg,String ksem,String ksub)
	{
		
		College tmp = this.StrCllg.get(kcllg);
		Data_Cllg temp = this.Cllg.get(tmp);
		
		System.out.println(tmp.getClg_name());
		System.out.println(tmp.getClg_programme());
		System.out.println(tmp.getClg_field());
		System.out.println(tmp.getClg_uniName());
		System.out.println(tmp.getClg_enrollNumber());
		System.out.println(tmp.getClg_enrollYear());
		System.out.println(tmp.getClg_yearOfPassing());
		System.out.println(tmp.getClg_completed());
		System.out.println();
		
		temp.display2(ksem,ksub);
	}

	public HashMap <String,College> retListProg()
	{
		return StrCllg;
	}

	public HashMap <String,Semester> retListSem(String kcllg)
	{
		College Cllg_temp = this.StrCllg.get(kcllg);
		Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);
		return Data_Cllg_temp.retListSemtoandfro();
	}

	public HashMap <String,Subject> retListSub(String kcllg,String ksem)
	{
		College Cllg_temp = this.StrCllg.get(kcllg);
		Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);
		return Data_Cllg_temp.retListSubtoandfro1(ksem);
	}

	public String[] get_Details_PD()
	{
		String[] pd_details7 = new String[7];

		pd_details7[0]= Data_PD.getPd_fname();
		pd_details7[1]= Data_PD.getPd_lname();
		pd_details7[2]= Data_PD.getPd_gender();
		pd_details7[3]= Data_PD.getPd_pinCode();
		pd_details7[4]= Data_PD.getPd_country();
		pd_details7[5]= Data_PD.getPd_city();
		pd_details7[6]= Data_PD.getPd_contact();

		return pd_details7;
	}

	public String[] get_Details_Cllg(String kcllg)
	{
		String[] cllg_details7 = new String[7];
		College details_temp_cllg = StrCllg.get(kcllg);

		cllg_details7[0] = details_temp_cllg.getClg_programme();
		cllg_details7[1] = details_temp_cllg.getClg_field();
		cllg_details7[2] = details_temp_cllg.getClg_name();
		cllg_details7[3] = details_temp_cllg.getClg_uniName();
		cllg_details7[4] = details_temp_cllg.getClg_enrollNumber();
		cllg_details7[5] = details_temp_cllg.getClg_enrollYear();
		cllg_details7[6] = details_temp_cllg.getClg_yearOfPassing();

		return cllg_details7;
	}

    public String[] get_Details_Sem(String kcllg,String ksem)
    {
        College Cllg_temp = this.StrCllg.get(kcllg);
        Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);

        return Data_Cllg_temp.get_Details_Semtoandfro(ksem);
    }

    public String[] get_Details_Sub(String kcllg,String ksem,String ksub)
    {
        College Cllg_temp = this.StrCllg.get(kcllg);
        Data_Cllg Data_Cllg_temp = this.Cllg.get(Cllg_temp);

        return Data_Cllg_temp.get_Details_Subtoandfro1(ksem,ksub);
    }
}


class Data_Cllg implements Serializable
{
	HashMap <String,Semester> StrSem;
	HashMap <Semester,Data_Semester> Sem;	
	
	public Data_Cllg()
	{
		StrSem = new HashMap <String,Semester>();
		Sem = new HashMap<Semester,Data_Semester>();
	}	
	
	public void insert(String k,Semester sem)
	{
		Data_Semester Sem_temp = new Data_Semester();
		this.StrSem.put(k,sem);
		this.Sem.put(sem,Sem_temp);
	}
	
	public void addsub(String ksem,String ksub,Subject sub)
	{
		Semester Sem_temp = this.StrSem.get(ksem);
		Data_Semester Data_Sem_temp = this.Sem.get(Sem_temp);
		Data_Sem_temp.insert(ksub,sub);
	}	
	
	public void display2(String ksem,String ksub)
	{
		Semester tmp = this.StrSem.get(ksem);
		Data_Semester temp = this.Sem.get(tmp);
		
		System.out.println(tmp.getSem_no());
		System.out.println(tmp.getSem_gpa());
		System.out.println(tmp.getSem_total_gpa());
		System.out.println(tmp.getSem_cgpa());
		System.out.println(tmp.getSem_total_cgpa());
		System.out.println("completed");
		System.out.println();
		
		temp.display3(ksub);
	}

	public HashMap <String,Semester> retListSemtoandfro()
	{
		return StrSem;
	}

	public HashMap <String,Subject> retListSubtoandfro1(String ksem)
	{
		Semester Sem_temp = this.StrSem.get(ksem);
		Data_Semester Data_Sem_temp = this.Sem.get(Sem_temp);
		return Data_Sem_temp.retListSubtoandfro();
	}

    public String[] get_Details_Semtoandfro(String ksem)
    {
        String[] sem_details4 = new String[4];
        Semester details_temp_sem = StrSem.get(ksem);

        sem_details4[0] = details_temp_sem.getSem_gpa();
        sem_details4[1] = details_temp_sem.getSem_total_gpa();
        sem_details4[2] = details_temp_sem.getSem_cgpa();
        sem_details4[3] = details_temp_sem.getSem_total_cgpa();

        return sem_details4;
    }

    public String[] get_Details_Subtoandfro1(String ksem,String ksub)
    {
        Semester Sem_temp = this.StrSem.get(ksem);
        Data_Semester Data_Sem_temp = this.Sem.get(Sem_temp);

        return Data_Sem_temp.get_Details_Subtoandfro(ksub);
    }
}


class Data_Semester implements Serializable
{
	HashMap <String,Subject> Sub;	
	
	public Data_Semester()
	{
		Sub = new HashMap<String,Subject>();
	}
	
	public void insert(String k,Subject subtemp)
	{
		this.Sub.put(k,subtemp);
	}
	
	public void display3(String ksub)
	{
		Subject sub = Sub.get(ksub);
		
		System.out.println(sub.getSubject_name());
		System.out.println(sub.getProffessor_name());
		System.out.println(sub.getMax_score());
		System.out.println(sub.getUser_score());
		System.out.println();
	}

	public HashMap <String,Subject> retListSubtoandfro()
	{
		return Sub;
	}

    public String[] get_Details_Subtoandfro(String ksub)
    {
        String[] sub_details4 = new String[4];
        Subject details_temp_sub = Sub.get(ksub);

        sub_details4[0] = details_temp_sub.getSubject_name();
        sub_details4[1] = details_temp_sub.getProffessor_name();
        sub_details4[2] = details_temp_sub.getUser_score();
        sub_details4[3] = details_temp_sub.getMax_score();

        return sub_details4;
    }
}

/*
public class Java_TreeImplementation 
{
	public static void main(String args[])
	{
		Scanner inp = new Scanner(System.in);
				
		Data_User du = new Data_User();
		boolean ans1=true,ans2=true,ans3=true;
		
		while(ans1)
		{
			College c = new College();
			
			String clgname = inp.next();
			
			c.setCollege(clgname,"BTech","ICT","AU","1","2015","2019",false);
		
			du.insert(clgname,c);

			ans2=true;	
			while(ans2)
			{
				Semester se = new Semester();
				
				String semnum = inp.next();
			
				se.setSemester(semnum,"5.0","6.0","4.0","6.0");
				
				du.addsem(clgname,semnum,se);
				
				ans3=true;
				while(ans3)
				{
					Subject su = new Subject();

					String subname = inp.next();

					su.setSubject(subname,"Ratnik","1.5","3.0");
					
					du.addsub(clgname,semnum,subname,su);
					
					System.out.println("u wish to enter more sub");
					ans3 = inp.nextBoolean();
				}
				System.out.println("u wish to enter more sem");
				ans2 = inp.nextBoolean();
			}
			System.out.println("u wish to enter more cllg");
			ans1 = inp.nextBoolean();
		}

		boolean disans = true;
		while(disans)
		{
			try
			{
				System.out.println("Enter the College");
				String cllg;
				cllg = inp.next();

				System.out.println("Enter the Semester");
				String semis;
				semis = inp.next();
				
				System.out.println("Enter the Subject");
				String subj;
				subj = inp.next();

				du.display1(cllg,semis,subj);
						
				
				System.out.println("Do you want to continue");
				disans = inp.nextBoolean();				
			}
			catch(Exception err)
			{
				err.printStackTrace();
			}
			
			
		}

	}
}
*/