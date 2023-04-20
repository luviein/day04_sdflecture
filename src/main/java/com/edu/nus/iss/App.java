package com.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        if (args.length > 0) {
            for (int i= 0; args.length > i; i++){
                System.out.println("Argument: " + i + ": " + args[i]);
            }    
       }else{
            System.out.println("You did not pass in any arguments.");
       }

       String dirPath = args[0];
       String fileName = args[1];
       String dirPathFileName = dirPath + File.separator + fileName;

       File newDir = new File(dirPath);
       if (newDir.exists()){
           System.out.println(dirPath + " exists."); 
       }else{
           newDir.mkdir();
       }

       File newFile = new File(dirPathFileName); //needs to be dirpathfilename, if it is just filename it may go to the wrong dir
       if (!newFile.exists()){
           System.out.println(dirPathFileName + " does not exists.");
           System.exit(0);
           
       }

       //1. Use FileReader and BufferedReader to read file
       FileReader fr = new FileReader(new File(dirPathFileName));
       BufferedReader br = new BufferedReader(fr);

       StringBuilder sbFileContent = new StringBuilder();
       String lineInput = " ";
       //2. While loop to read file into a string variable
       while ((lineInput = br.readLine())!= null) {
           sbFileContent.append(lineInput); //string builder can just keep append to string
       }



       //3. Close the readers
       br.close();
       fr.close();

       //4. print out the StringBuilder object sbFileContent
       // make sure to read all contents 
       System.out.println(sbFileContent);
    }
}
