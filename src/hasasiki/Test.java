package hasasiki;

import java.io.IOException;

import javax.jms.TextMessage;

import hasasiki.CL;
import hasasiki.Savechatlog;
//import hasasiki.Showchatlog;
public  class Test {

 // Runtime run = Runtime.getRuntime();
    // Process p = run.exec("java Createtxt"); 
       public static void savechatlog(String inputword) throws IOException 
       { ProcessBuilder pb = new ProcessBuilder("java", "Createtxt");
         Process p = pb.start();
	CL cl =new CL();
	Savechatlog savechatlog = new Savechatlog(cl);
	
	Savechatlog.inputword=inputword;
	//Showchatlog showchatlog = new Showchatlog(cl);
	Thread t1= new Thread(savechatlog);
	//Thread t2= new Thread(new Showchatlog(cl));
	//new Thread(savechatlog).start();

	//new Thread(showchatlog).start();
	t1.start();
	//t1.join();
	//t2.start();
	//t2.join();
       }
  }