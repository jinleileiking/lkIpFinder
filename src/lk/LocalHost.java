/**
 * 
 */
package lk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Administrator
 *
 */
public class LocalHost {

	/**
	 * @param args
	 */
	static String Ret = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMac());
	    System.out.println(getIP());
	}

	public static String getIP()
	{
	    try
        {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
	}
	
	public static String getMac()
	{
		return getMACAddress();
	}


	public static String getMACAddress()
	{ 

		try
		{ 
			String line; 
	        Process process = Runtime.getRuntime().exec("ipconfig /all"); 
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream())); 
			while ( (line=bufferedReader.readLine()) != null)
			{ 
//				System.out.println(line);
				if(line.indexOf("Physical Address. . . . . . . . . :") != -1)
				{ 
					if(line.indexOf(":") != -1)
					{ 
						Ret = line.substring(line.indexOf(":")+2);
					}
					break; //�ҵ�MAC,�Ƴ�ѭ�� 
				}
				
			}
			process.waitFor(); 
		}
		catch(Exception e)
		{ 
			e.printStackTrace(); 
		} 
		return Ret; 
	}

	
	
	
	
//	public static String getWindowsMACAddress() { 
//	    String address = ""; 
//	    try { 
//	     ProcessBuilder pb = new ProcessBuilder("ipconfig ","/all"); 
//	     Process p = pb.start(); 
//	     BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
//	     String line; 
//	     while ((line = br.readLine()) != null) { 
//	        if (line.indexOf("Physical Address") != -1) { 
//	         int index = line.indexOf(":"); 
//	         address = line.substring(index + 1); 
//	         break; 
//	        } 
//	     } 
//	     br.close(); 
//	     return address.trim(); 
//	    } catch (IOException e) { 
//	    } 
//	    return address; 
//	} 
//	public static String getLinuxMACAddress() { 
//	    String address = ""; 
//	    try { 
//	     ProcessBuilder pb = new ProcessBuilder("ifconfig", "-a"); 
//	     Process p = pb.start(); 
//	     BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream())); 
//	     String line; 
//	     while ((line = br.readLine()) != null) { 
//	        System.out.println(line); 
//	        if (line.indexOf("Link encap:Ethernet    HWaddr") != -1) { 
//	         int index = line.indexOf("HWaddr"); 
//	         address = line.substring(index + 7); 
//	         break; 
//	        } 
//	     } 
//	     br.close(); 
//	     return address.trim(); 
//	    } catch (IOException e) { 
//	    } 
//	    return address; 
//	} 
//	public static String getMACAddress() { 
//	    String address = ""; 
//	    String os = System.getProperty("os.name"); 
//	    // System.out.println(os); 
//	    if (os != null && os.startsWith("Windows")) { 
//	     address = getWindowsMACAddress(); 
//	     address = address.replaceAll("-", ":"); 
//	    } else { 
//	     address = getLinuxMACAddress(); 
//	    } 
//	    return address; 
//	} 
}
