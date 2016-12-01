package com.newtv.test;

import com.newtv.weixin.entity.Token;
import com.newtv.weixin.util.HttpsGetJsonOrTokenUtil;

public class HttpsWeiXinTest {
public static void main(String[] args) {
	String requestUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx950afa8dc104c424&secret=a21ce4b1be554604e465b3f4fbd9918c";
	String appid="wx950afa8dc104c424";
	String appsecret="a21ce4b1be554604e465b3f4fbd9918c";
	Token token=HttpsGetJsonOrTokenUtil.getToken(appid, appsecret);
	System.out.println(token.getAccess_token());
	System.out.println(token.getExpires_in());
}
}
