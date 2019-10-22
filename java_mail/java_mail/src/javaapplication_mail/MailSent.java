/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

/**
 *
 * @author Lenoo
 */
import java.util.Scanner;

/**
 *
 * @author Lenoo
 */
public class MailSent {
    public static void main(String args[])throws Exception
{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter no of attachments");
       int j=sc.nextInt();
       sc.nextLine();
       System.out.println("sbject to be entered");
       String sub=sc.nextLine();
       System.out.println("no of mails to be sent");
       int n=sc.nextInt();
     
      // System.out.println("Ab");
MailSending.sendMail("zibasey@gmail.com","ziya86959@gmail.com","ZiYa2106",sub,j,"demo1",n);

}

}