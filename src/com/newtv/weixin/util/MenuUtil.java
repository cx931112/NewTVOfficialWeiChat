package com.newtv.weixin.util;

import net.sf.json.JSONObject;

public class MenuUtil {
public static final String MENU_CREATE_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
public static boolean createMenu(String accessToken,String json){
	boolean result=false;
	String requestUrl=MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
	String respJson=HttpsGetJsonOrTokenUtil.getJson(requestUrl,"POST", json);
	JSONObject jsonObject=JSONObject.fromObject(respJson);
	if(jsonObject!=null){
		int errCode=jsonObject.getInt("errcode");
		String errMsg=jsonObject.getString("errmsg");
		if(errCode==0){
			result=true;
		}
		else{
			result=false;
			System.out.println("菜单创建失败："+respJson);
			
		}
	}
	return result;
	
}
}
