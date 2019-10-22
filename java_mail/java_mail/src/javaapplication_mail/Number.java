/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

import java.io.IOException;
import java.util.Scanner;
import javax.mail.Message;

/**
 *
 * @author Lenoo
 */
public class Number extends Mail_receive{
     public static void main(String[] args) throws IOException
    {
         Scanner sc=new Scanner(System.in);
        System.out.println("Enter the email address : ");
 String Username=sc.next();
System.out.println("Enter the password : ");
 String password=sc.next();
 System.out.println("Enter no of mails : ");
 int n=sc.nextInt();

 //int j=messages.length;
 Message messages[]=create_mail(Username,password);
// System.out.print(j);
 for(int i=messages.length-1; i>=messages.length-n; i--)
 {
 Message message = messages[i];

display(message,i,1);
 }
    }
}


