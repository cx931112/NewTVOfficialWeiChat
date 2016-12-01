package com.newtv.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class CheckUtil {
      public static final String token="NewTVofficial";//token值
      
      public static boolean checkSignature(String signature,String timestamp,String nonce){
    	  try{
    	  String [] arr=new String[]{token,timestamp,nonce};
    	  Arrays.sort(arr);
    	  String str=arr[0].concat(arr[1]).concat(arr[2]);
    	  MessageDigest md=MessageDigest.getInstance("SHA-1");
    	  byte[]digest=md.digest(str.getBytes());
    	  String temp=byte2str(digest);
    	  System.out.println(temp);
    	  return signature.equals(temp);
    	  }
    	  catch(Exception e){
    		 return false;
    	  }
    	  
  
      }
      private static String byte2str(byte[]arry){
          StringBuffer hexstr=new StringBuffer();
          String shaHex="";
          for(int i=0;i<arry.length;i++){
        	  shaHex=Integer.toHexString(arry[i]&0xFF);
        	  if(shaHex.length()<2){
        		  hexstr.append(0);
        		  
        	  }
        	  hexstr.append(shaHex);
          }
          return hexstr.toString();
      }
}
