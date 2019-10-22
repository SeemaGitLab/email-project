/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

/**
 *
 * @author Lenoo
 */

    import java.util.Date;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;


/**
 *
 * @author Lenoo
 */
public class Time extends Mail_receive{
 public static Message messages[];
    public static  void check(String sub,Message message,int i)throws MessagingException, IOException
    {
                   String sub1=message.getSubject();
if(sub.equals(sub1))
{
    display(message,i,1);
    
}
    }
   /* public static Message insert(int i)throws MessagingException
    {
       Message  message = messages[i];

              Date    date = message.getSentDate();
                  Date_f(date); 
                  return message;
    }*/
   public static void main(String [] args) throws IOException
   {
         Scanner sc=new Scanner(System.in);
         String Username,password;
 // char c;
System.out.println("Enter the email address : ");
  Username=sc.nextLine();
System.out.println("Enter the password : ");
  password=sc.nextLine();
     System.out.println("enter");
      String subj=sc.nextLine();
      //System.out.println(sub);
      System.out.print("ENTER TIME");
      int min=sc.nextInt();
      System.out.println(subj);
       Message messages[]=create_mail(Username,password);
        int cal_date,cal_min,cal_hr,cal_mon,cal_year;
       
        Date date=new Date();
        Date_f(date);
        int t_date=f_date;
        int t_mon=f_mon;
        int t_yr=f_year;
        int t_min=f_min;
        int t_hr=f_hr;
        while(min>=0)
{
     if(isLeapyear(t_yr) == 1)
            {
month_days[2]=29;
            }
    min--;
   t_min--;
    if(t_min==0)
    {
        t_hr--;
        t_min=59;
    }
    if(t_hr==0)
    {
        t_date--;
        t_hr=23;
    }
    if(t_date==0)
    {
       t_mon--;
        t_date=month_days[t_mon];
    }
    if(t_mon==0)
    {
         t_yr--;
        t_mon=12;
        t_date=31;
    }
    
}
        cal_date= t_date;
cal_mon= t_mon;
cal_year= t_yr;
cal_hr=t_hr;
cal_min=t_min;
System.out.println("time"+cal_year+" "+cal_mon+" "+cal_date+" "+cal_min+" "+cal_hr);
      int i=messages.length-1;
   //   Message message;
      try
      {
        while(f_year>cal_year)
               {
                //   message=insert(i);
                      Message message=messages[i];
         //  message = messages[i];
             date = message.getSentDate();
             Date_f(date);
               if(f_year<cal_year)
                 break;
               check(subj,message,i);
              /*  String sub1=message.getSubject();
                if(sub.equals(sub1))
                    {
                        display(message,i);
                    }*/
                i--;
               }
      /*  if(f_year==cal_year )
         {*/
                 while(f_mon>cal_mon)
                 {
// message=insert(i);
                  Message  message = messages[i];

                  date = message.getSentDate();
                  Date_f(date);
                  if((f_mon<cal_mon)||(f_year<cal_year))
    break;
                  check(subj,message,i);
/*String sub1=message.getSubject();
if(sub.equals(sub1))
{
    display(message,i);
}*/
i--;
   }
             /*    if(f_mon==cal_mon)
        {*/
            while(f_date>cal_date)
            {
            //     message=insert(i);
         Message    message = messages[i];


            date = message.getSentDate();
            Date_f(date);
                     if((f_date<cal_date)||(f_mon<cal_mon)||(f_year<cal_year))
                break;
                     check(subj,message,i);
          /*  String sub1=message.getSubject();
if(sub.equals(sub1))
{
    display(message,i);
}*/
i--;
}
          /*  if(f_date==cal_date)
        {*/
           // System.out.println("hour+"+f_hr);
            while(f_hr>cal_hr)
            {
                 //message=insert(i);
                Message    message = messages[i];


            date = message.getSentDate();
            Date_f(date);
            if((f_hr<cal_hr)||(f_mon<cal_mon)||(f_date<cal_date)||(f_year<cal_year))
    break;
            check(subj,message,i);
           /* String sub1=message.getSubject();
if(sub.equals(sub1))
{
    display(message,i);
    
}*/
i--;
            }
            /* if(f_hr==cal_hr){*/
            while(f_min>=cal_min)
            {
               //  message=insert(i);/*Message   
            Message    message = messages[i];

//System.out.println("min"+f_min);
            date = message.getSentDate();
            Date_f(date);
            if((f_min<cal_min)||(f_hr<cal_hr)||(f_mon<cal_mon)||(f_date<cal_date)||(f_year<cal_year))
    break;
            check(subj,message,i);
       /*     String sub1=message.getSubject();
if(sub.equals(sub1))
{
    display(message,i);
    
}*/
i--;
            }}
        
       
   
               catch(ArrayIndexOutOfBoundsException ex)
{
    
}
catch(NoSuchProviderException nspe)
 {
nspe.printStackTrace();
System.out.println("INVALID");
 }
catch(MessagingException me)
 {
me.printStackTrace();
System.out.println("INVALID");
 }
   }
}
