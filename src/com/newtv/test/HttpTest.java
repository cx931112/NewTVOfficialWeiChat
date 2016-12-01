package com.newtv.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTest {
public static void main(String[] args) throws Exception {
	URL url=new URL("http://www.qq.com");
	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
	conn.setRequestMethod("GET");
	
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
