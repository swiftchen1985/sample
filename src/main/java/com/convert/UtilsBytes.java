package com.convert;

public class UtilsBytes {
	
   public static byte[] toByte(char c){  
        return toBytes((short)c);  
   }
   
   public static byte[] toBytes(short n){  
        byte[] bytes=new byte[2];  
        for (int i = 0; i < bytes.length; i++) {  
            bytes[i] = (byte) ((n >> (i << 3)) & 0xFF);  
        }  
        return bytes;  
    }  
   
	public static byte[] toBytes(int n) {  
        byte[] bytes = new byte[4];  
        for (int i = 0; i < bytes.length; i++) {  
            bytes[i] = (byte) ((n >> (i << 3)) & 0xFF);  
        }  
        return bytes;  
    }  
	
    public static byte[] toBytes(long n) {  
        byte[] bytes = new byte[8];  
        for (int i = 0; i < bytes.length; i++) {  
            bytes[i] = (byte) ((n >> (i << 3)) & 0xFF);  
        }  
        return bytes;  
    }  
    
    public static int toInt(byte[] bytes) {  
        int n = 0;  
        for (int i = 0; i < bytes.length; i++) {  
            n = n | ((bytes[i] & 0xff) << (i << 3));  
        }  
        return n;  
    }  
    
    public static long toLong(byte[] bytes) {  
        long n = 0;  
        for (int i = 0; i < bytes.length; i++) {  
            n = n | ((bytes[i] & 0xffL) << (i << 3));  
        }  
        return n;  
    }  
  
    public static short toShort(byte[] bytes){  
        short n = 0;  
        for (int i = 0; i < bytes.length; i++) {  
            n = (short) (n | ((bytes[i] & 0xff) << (i << 3)));  
        }  
        return n;  
    } 
    
    public static char toChar(byte[] bytes){  
        return (char)toShort(bytes);  
    }  
    
    
}
