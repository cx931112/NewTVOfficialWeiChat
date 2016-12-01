package com.newtv.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import com.newtv.weixin.entity.Token;



public class HttpsGetJsonOrTokenUtil {
  public static String getJson(String requestUrl,String requestMethod,String outputStr){
	  StringBuffer buffer=null;
	  try {
		SSLContext sslContext=SSLContext.getInstance("SSL", "SunJSSE");
		TrustManager[] tm={new MyX509TrustManager()};
		sslContext.init(null, tm, new java.security.SecureRandom());
		SSLSocketFactory ssf=sslContext.getSocketFactory();
		URL url=new URL(requestUrl);
		HttpsURLConnection  conn=(HttpsURLConnection)url.openConnection();
		conn.setRequestMethod(requestMethod);
		conn.setSSLSocketFactory(ssf);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.connect();
		if(outputStr!=null){
			OutputStream os=conn.getOutputStream();
			os.write(outputStr.getBytes("utf-8"));
			os.close();
		}
		InputStream is=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		buffer=new StringBuffer();
		String line=null;
		while((line=br.readLine())!=null){
			
			buffer.append(line);
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  
	return buffer.toString();
	
	  
	  
  }
public static String token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


public static Token getToken(String appid,String appsecret){
	
	Token token=null;
	String requestUrl=token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
	
	String json=getJson(requestUrl,"GET",null);
	
	
	try{
	JSONObject jsonObject=JSONObject.fromObject(json);
	
	String accessToken=jsonObject.getString("access_token");
	int expiresIn=jsonObject.getInt("expires_in");
	token=new Token();
	token.setAccess_token(accessToken);
	token.setExpires_in(expiresIn);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return token;
	
}




}
