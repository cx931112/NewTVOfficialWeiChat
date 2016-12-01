package com.newtv.test;

import net.sf.json.JSONObject;

import com.newtv.weixin.button.entity.BaseButton;
import com.newtv.weixin.button.entity.ClickButton;
import com.newtv.weixin.button.entity.ComplexButton;
import com.newtv.weixin.button.entity.Menu;
import com.newtv.weixin.button.entity.ViewButton;
import com.newtv.weixin.entity.Token;
import com.newtv.weixin.util.HttpsGetJsonOrTokenUtil;
import com.newtv.weixin.util.MenuUtil;

public class MenuTest {
public static void main(String[] args) {
	ClickButton clickButton10=new ClickButton();
	clickButton10.setName("天气预报");
	clickButton10.setType("click");
	clickButton10.setKey("KEY_WEATHER");
	ClickButton clickButton21=new ClickButton();
	clickButton21.setName("每日歌曲");
	clickButton21.setType("click");
	clickButton21.setKey("KEY_MUSIC");
	ViewButton viewButton22=new ViewButton();
	viewButton22.setName("百度");
	viewButton22.setType("view");
	viewButton22.setUrl("http://www.baidu.com/");
	ComplexButton complexButton20=new ComplexButton();
	complexButton20.setName("菜单");
	complexButton20.setSubbutton(new BaseButton[]{clickButton21,viewButton22});
	Menu menu=new Menu();
	menu.setButton(new BaseButton[]{clickButton10,complexButton20});
	String json=JSONObject.fromObject(menu).toString();
	System.out.println(json);
	String appid="wx950afa8dc104c424";
	String appsecret="a21ce4b1be554604e465b3f4fbd9918c";
	Token token=HttpsGetJsonOrTokenUtil.getToken(appid, appsecret);
	
	boolean result=MenuUtil.createMenu(token.getAccess_token(), json);
	System.out.println(result);
	
}
}
