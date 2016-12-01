package com.newtv.weixin.util;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

public class MessageUtil {
	public static String req_msg_text="text";
	public static String req_msg_vedio="vedio";
        public static String responseXml(HttpServletResponse response,HashMap<String,String> map){
        	String MsgType=map.get("MsgType");
        	String CreateTime=map.get("CreateTime");
        	String FromUserName=map.get("FromUserName");
        	String ToUserName=map.get("ToUserName");
			return null;
			
        	
        	
        }
}
