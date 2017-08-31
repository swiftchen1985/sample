package sample;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.Test;

public class TestHashCode {

	@Test
	public void TestStringHashCode(){
		/*char c1 = '��';
		char[] c = new String("�й���").toCharArray();
		System.out.println("���֣�" +SumStrAscii("�й�123") + ";ascii2char:" + byteAsciiToChar(SumStrAscii("��"))); 
		System.out.println((int)c[0] + "--" + (int)c[1] + "--" + (int)c[2]  + "--" + Character.getNumericValue(c[2]));  
		System.out.println(new String("��").hashCode());
		
		
		System.out.println(new String("abc").hashCode());
		System.out.println(calculate(1,new int[]{1,2,3,4}));*/
	}
	
	
	 private static int calculate(int radix,int[] a){  
	        int sum = 0;  
	        for(int i=0;i<a.length;++i){  
	            sum = sum*radix+a[i];  
	        }  
	        return sum;  
	    }  
	
	 public static int SumStrAscii(String str){  
	        byte[] bytestr;
	        int sum = 0;  
			try {
				bytestr = str.getBytes("GB2312");
				 for(int i=0;i<bytestr.length;i++){  
					 System.out.println(bytestr[i]);
			            sum += bytestr[i];  
			        }  
			       
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        return sum;  
	    } 
	 public static char byteAsciiToChar(int ascii){  
		  String csn = Charset.defaultCharset().name();
		 System.out.println( csn   );
	        char ch = (char)ascii; 
	        System.out.println(ch); 
	        return ch;  
	 }  
}
