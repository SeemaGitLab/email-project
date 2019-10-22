/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

/**
 *


/**
 *
 * @author Lenoo
 */
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeBodyPart;

public class Mail_receive {
//public static Message messages[];
    /**
     * @param args the command line arguments
     */
    //int cal_min,cal_hr,cal_date,cal_mon,cal_year;
   static int month_days[]={0,31,28,30,31,30,31,31,31,30,31,30,31}; 
    static   int f_date=0,f_mon=0,f_year=0,f_hr=0,f_min=0,f_sec=0;
    static int test=0;
    public static int isLeapyear(int year)
{

boolean leap = false;
if(year % 4 == 0)
        {
if( year % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
        if(leap)
           return 1;
        else
           return 0;
}

    
    public static void Date_f(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
           String strDate = dateFormat.format(date);
            String sp[]=strDate.split(" ");
            f_date=Integer.parseInt(sp[0]);
f_mon=Integer.parseInt(sp[1]);
f_year=Integer.parseInt(sp[2]);
String time[]=sp[3].split(":");
f_hr=Integer.parseInt(time[0]);
f_min=Integer.parseInt(time[1]);
    }
   public static Message[] create_mail(String Username,String password)
   {
       try
       {
       Properties prop=new Properties();
            prop.setProperty("mail.store.protocol","imaps");
            Session emailSession=Session.getDefaultInstance(prop);
            Store emailStore=emailSession.getStore("imaps");
            emailStore.connect("imap.gmail.com",Username,password);
             Folder emailFolder = emailStore.getFolder("INBOX");
emailFolder.open(Folder.READ_ONLY);
              Message messages[]=emailFolder.getMessages();
            return messages;
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
       return null;
   }
   public static void content_check(String subject,String messagec) throws FileNotFoundException, IOException
   {
         String cont="C:\\store\\"+subject+".txt";
                                File file=new File(cont);
                                
                                FileInputStream f=null;
                                f=new FileInputStream(file);
                                byte filec[]=new byte[(int)file.length()];
                                f.read(filec);
                                String s=new String(filec);
                                if(!messagec.equals(s))
                                    test=1;
                                     if(test==1)
    System.out.println("not same");
else
    System.out.println("same");
   }
   public static void display(Message message,int i,int k) throws IOException
   {
       try
       {
           /*Multipart multipart=(Multipart)message.getContent();
           for(int k=0;k<multipart.getCount();k++)
           {
               BodyPart bodypart=multipart.getBodyPart(k);
               InputStream inputstream =(InputStream)bodypart.getInputStream();
               BufferedReader br=new BufferedReader(new InputStreamReader(inputstream));
               while(br.ready())
                   System.out.println(br.readLine());
           }*/
int test=0;
Address[] fromAddress = message.getFrom();
				String from = fromAddress[0].toString();
				String subject = message.getSubject();
				String sentDate = message.getSentDate().toString();
String  saveDirectory="D:\\temp\\";
				String contentType = message.getContentType();
				String messageContent = "";

				// store attachment file name, separated by comma
				String attachFiles = "";

				if (contentType.contains("multipart")) {
					// content may contain attachments
					Multipart multiPart = (Multipart) message.getContent();
					int numberOfParts = multiPart.getCount();
					for (int partCount = 0; partCount < numberOfParts; partCount++) {
						MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
						if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
							// this part is attachment
							String fileName = part.getFileName();
                                                        int index=fileName.lastIndexOf("\\");
                                                        String file_n=saveDirectory+File.separator+fileName.substring(index+1,fileName.length());
                                                        String file_n1="C:\\store\\"+fileName.substring(index+1,fileName.length());
                                                       
							attachFiles += fileName + ", ";
							part.saveFile(file_n);
                                                     
                                                      if(!Check.comp(file_n,file_n1))
                                                      {
                                                         test=1;
                                                          break;
                                                      } 
                                                      
						} else {
							// this part may be the message content
							messageContent = part.getContent().toString();
						}
					}

					if (attachFiles.length() > 1) {
						attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
					}
				} else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
					Object content = message.getContent();
					if (content != null) {
						messageContent = content.toString();
					}
				}

				//print out details of each message
				System.out.println("Message #" + (i + 1) + ":");
				System.out.println("\t From: " + from);
				System.out.println("\t Subject: " + subject);
                               /* String cont="C:\\new\\"+subject+".txt";
                                File file=new File(cont);
                                
                                FileInputStream f=null;
                                f=new FileInputStream(file);
                                byte filec[]=new byte[(int)file.length()];
                                f.read(filec);
                                String s=new String(filec);
                                if(!messageContent.equals(s))
                                    test=1;*/
                               
                               
				System.out.println("\t Sent Date: " + sentDate);
				System.out.println("\t Message: " + messageContent);
				System.out.println("\t Attachments: " + attachFiles);
                                if(k==1)
                                content_check(subject,messageContent);
                              /*  if(test==1)
    System.out.println("not same");
else
    System.out.println("same");*/
			}

				
catch(FileNotFoundException fe)
{
  //  System.out.println("file not found");
    System.out.print("not same ");
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
 }     catch (IOException ex) {
           Logger.getLogger(Mail_receive.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}

