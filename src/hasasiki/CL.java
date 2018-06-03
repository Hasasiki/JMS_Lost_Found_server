package hasasiki;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class CL 
{
	
	
      public synchronized  void Writefile(String inputword)
      {
	   try{
		File writename = new File("D:\\Chatlog.txt"); 
		BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));
		out.write(System.lineSeparator());
		out.write(inputword);
		out.flush();
		 out.close();
	      }
	     catch(Exception e)
	      {
		
	      }
       }
      /*  public  synchronized void Readfile()throws IOException
       {  StringBuilder result = new StringBuilder();
	   try{File file = new File("D:/Chatlog.txt");
  
                BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                result.append(s+System.lineSeparator());
					
                }  
			br.close(); 	
	       }
	     catch(Exception e){
	    }
	      System.out.println(result.toString());

        }	*/
}