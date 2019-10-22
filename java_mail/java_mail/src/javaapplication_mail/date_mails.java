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
public class date_mails extends Mail_receive{
    public static void main(String args[]) throws IOException
    {
          Scanner sc=new Scanner(System.in);
        System.out.println("Enter the email address : ");
 String Username=sc.next();
System.out.println("Enter the password : ");
 String password=sc.next();
 int days;
System.out.println("Enter the number of days : ");
  days=sc.nextInt();
   Message messages[]=create_mail(Username,password);
       int cal_date= 0;
        int cal_mon= 0;
        int cal_year= 0;
        Date date=new Date();
        Date_f(date);
        int p=f_date;
        int q=f_mon;
        int r=f_year;
while(days>0)
        {
            if(isLeapyear(r) == 1)
            {
month_days[2]=29;
            }

            if(p==0)
            {
                q--;
                p=month_days[q];
                if(q==0)
                {
                    r--;
                    q=12;
                    p=month_days[q];
                }
            }
            p--;
            days--;
        }

cal_date= p;
cal_mon= q;
cal_year= r;
int count=0;
int i=messages.length-1;
try
{
         while(f_year>cal_year)
         {
count++;
     Message      message = messages[i];


            date = message.getSentDate();
            Date_f(date);
            if(f_year<cal_year)
    break;
            display(message,i,1);
            i--;
    }
         if(f_year==cal_year )
        {
        while(f_mon>cal_mon)
        {
             Message      message = messages[i];
             date = message.getSentDate();
            Date_f(date);
            if((f_mon<cal_mon)||(f_year<cal_year))
    break;
            display(message,i,1);
            i--;
        }
         if(f_mon==cal_mon)
        {
            while(f_date>=cal_date)
            {
                Message      message = messages[i];
             date = message.getSentDate();
            Date_f(date);
                if((f_date<cal_date)||(f_mon<cal_mon)||(f_year<cal_year))
                break;
                  display(message,i,1);
            i--;
            }
        }
        }
}
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

