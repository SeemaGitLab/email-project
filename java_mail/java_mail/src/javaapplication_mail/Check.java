/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author Lenoolic static void comp
 */
public class Check {
static boolean ByteArrayCompare(byte[] a1, byte[] a2)
{
    if (a1.length != a2.length)
        return false;

    for (int i=0; i<a1.length; i++)
        if (a1[i]!=a2[i])
            return false;

    return true;
}

    public static boolean comp(String s1,String s2)
    {
         File file = new File(s1);
 File file1=new File(s2);
        //String s1="",s="";
        FileInputStream fin = null;
         FileInputStream fin1 = null;
        try {
            // create FileInputStream object
            fin = new FileInputStream(file);
 
            byte fileContent[] = new byte[(int)file.length()];
             
            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin.read(fileContent);
            //create string from byte array
           //  s = new String(fileContent);
          //  System.out.println("File content: " + s);
        
        
	 
            // create FileInputStream object
            fin1 = new FileInputStream(file1);
 
            byte fileContent1[] = new byte[(int)file1.length()];
             
            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin1.read(fileContent1);
            //create string from byte array
           // s1 = new String(fileContent1);
            System.out.println("File content: " + s1);
            boolean a=ByteArrayCompare(fileContent,fileContent1);
        
      return a;
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        }	//EmailAttachmentReceiver receiver = new EmailAttachmentReceiver();
		//receiver.setSave
   return false;
}
}
