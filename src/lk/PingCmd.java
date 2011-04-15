package lk;

import java.io.*;
import java.util.regex.*;

public class PingCmd
{
	public static boolean Ping(String cStrToPing)
	{
        String line;
        String cStrRet = "";
        try
        {
            Process pro = Runtime.getRuntime().exec("ping -n 1 -w 50 " + cStrToPing);
            BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            while ((line = buf.readLine()) != null)
            {
//                System.out.println(line); 
                cStrRet += line;
            }
//            System.out.println(cStrRet);
        	
            Pattern pattern = Pattern.compile("100%");
            Matcher matcher = pattern.matcher(cStrRet);
            if(matcher.find())
            {
            	System.out.println("Ping Fail!" + cStrToPing);
            	return false;
            }          
            else
            {
                System.out.println("Ping Ok!" + cStrToPing);        
                return true;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
	}
	
    public static void main(String args[])
    {
    	Ping("10.86.10.121");
    }

}