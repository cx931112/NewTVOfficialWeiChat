package com.newtv.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.newtv.weixin.util.MyX509TrustManager;



public class HttpsTest {
public static void main(String[] args) throws Exception{
	SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
	TrustManager[]tm={new MyX509TrustManager()};
	sslContext.init(null, tm, new java.security.SecureRandom());
	SSLSocketFactory ssf=sslContext.getSocketFactory();
//	URL url=new URL("https://95598.gd.csg.cn/");
	//URL url=new URL("https://www.oracle.com/sun/index.html");
	URL url=new URL("https://kyfw.12306.cn/");
	HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
	conn.setRequestMethod("GET");
	conn.setSSLSocketFactory(ssf);
	conn.connect();
	InputStream is=conn.getInputStream();
	InputStreamReader isr=new InputStreamReader(is,"utf-8");
	BufferedReader br=new BufferedReader(isr);
	StringBuffer buffer=new StringBuffer();
	String line=null;
	while((line=br.readLine())!=null){
		
		buffer.append(line);
		
	}
	
	System.out.println(buffer.toString());
	
}
}
