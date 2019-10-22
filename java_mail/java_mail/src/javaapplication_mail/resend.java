/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

import java.util.*;
import javax.mail.*;
/**
 *
 * @author Lenoo
 */
public class resend {

    /**
     *
     * @throws MessagingException
     */
    public static void check(String sub)throws MessagingException, Exception
            {
              //  Scanner sc=new Scanner (System.in);
              //  System.out.print("enter");
                String username ="zibasey@gmail.com";
                String password ="RiKu12345";
               // String sub=sc.nextLine();
                       Message messages[]=Mail_receive.create_mail(username,password);

                       
                int i=messages.length-1;
                
                if(sub.equals(messages[i].getSubject()))
                {
                                       String sub1=messages[i].getSubject();
if(sub.equalsIgnoreCase(sub1))
{
    
 MailSending.sendMail("ziya86959@gmail.com","zibasey@gmail.com","RiKu12345","reply to"+sub,0,"mail reached",1);
  // Mail_receive.display(messages[i], i);
  Thread.sleep(1000);
  Message[] mesages=Mail_receive.create_mail("ziya86959@gmail.com","ZiYa2106");
  int j=mesages.length-1;
  if(("reply to"+sub).equals(mesages[j].getSubject()))
      Mail_receive.display(mesages[j],j,0);
  else 
      System.out.print("no");
}
else
{
    System.out.print("not");
}
                   // String sub=messages.getSubject();
                }
            }
 
}
