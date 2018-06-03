package hasasiki;

import java.io.*;
public class Createtxt
{
    public static void main(String[] args) throws IOException
    {
       FileOutputStream fOut = new FileOutputStream("D:\\Chatlog.txt");
       fOut.close();
       System.out.println("sucess");
    }
}