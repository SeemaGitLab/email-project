/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

import java.util.*;
import javax.mail.*; 
import javax.mail.internet.*;
import java.io.*;
import java.util.logging.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Lenoo
 */
public class MailSending
{
public static void sendMail(String recepient,String myAccountEmail,String password,String subj,int j,String bod,int n)throws Exception
{

//System.out.println("Preparing to send email");

Properties properties = new Properties();
//System.out.println("half");
properties.put("mail.smtp.auth","true");
properties.put("mail.smtp.starttls.enable","true");
properties.put("mail.smtp.host","smtp.gmail.com");
properties.put("mail.smtp.port","587");

/*String myAccountEmail = "ziya86959@gmail.com";
String password = "ZiYa2106";*/

Session session;
    session = Session.getInstance(properties,new Authenticator()
    {

        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(myAccountEmail,password);
        }
    }
    );
     Scanner sc=new Scanner(System.in);
   
      // sc.nextLine();
         String[] attachFiles=new String[j];
        
         for(int k=0;k<j;k++)
         {
              System.out.println("enter file names");
             attachFiles[k]=sc.nextLine();
         }

//System.out.println("preparing");
for(int i=1;i<=n;i++)
{
     
  
   // attachFiles[0]="C:\\new\\abc.txt";
   // attachFiles[1]="C:\\new\\cd.txt";
 
//System.out.println("aa");
Message message = prepareMessage( session,myAccountEmail,recepient,attachFiles,subj,bod );
//System.out.println("pp");
Transport.send(message);
System.out.println("Message sent successfully");
Thread.sleep(1000);
resend.check(subj);
}
}
private static void attach_file(Multipart multipart,String filename) throws MessagingException
{
    MimeBodyPart messagebodypart=new MimeBodyPart();
DataSource source=new FileDataSource(filename);
messagebodypart.setDataHandler(new DataHandler(source));
messagebodypart.setFileName(filename);
multipart.addBodyPart(messagebodypart);
}
private static Message prepareMessage(Session session, String myAccountEmail, String recipient,String[] attachFiles,String subj,String bod)
{
try
{
  
Message message = new MimeMessage(session);


message.setFrom(new InternetAddress(myAccountEmail));
message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//String filename=filen;
message.setSubject(subj);
MimeBodyPart messagebodypart1=new MimeBodyPart();
messagebodypart1.setText(bod);
Multipart multipart = new MimeMultipart(); 
multipart.addBodyPart(messagebodypart1);
/*MimeBodyPart messageBodyPart=new MimeBodyPart();

DataSource source=new FileDataSource(filename);
messageBodyPart.setDataHandler(new DataHandler(source));
messageBodyPart.setFileName(filename);
Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart); */ 
        
//message.setContent(multipart);

if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                attach_file(multipart,filePath);
 
               
            }
        }
message.setContent(multipart);
Transport.send(message);
//message.setContent(multipart);
return message;
}


catch(Exception ex)
{
Logger.getLogger(MailSending.class.getName()).log(Level.SEVERE,null,ex);
}
return null;
}
}