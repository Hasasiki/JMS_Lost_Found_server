
package hasasiki;

import javax.jms.TextMessage;

public class Savechatlog implements Runnable
{
     private  CL cl;
     //private  String inputword="jesus";
     static String inputword;
     
     private int c=1;
     public Savechatlog (CL cl)
     { 
    	 this.cl=cl;
     }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(c==1){
			cl.Writefile(inputword);
			c--;
		}
	}
	//public   void setinputword(String inputword)
	//{
	//	this.inputword=inputword;
	//}
}
