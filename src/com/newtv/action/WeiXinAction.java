package com.newtv.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtv.weixin.util.CheckUtil;
import com.newtv.weixin.util.ParseXmlGetMapUtil;

public class WeiXinAction extends HttpServlet {

	public void doWeiXin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if (method != null && method.equals("GET")) {
			String signature = request.getParameter("signature");

			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			PrintWriter out = response.getWriter();
			if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
		} else if (method != null && method.equals("POST")) {
			String signature = request.getParameter("signature");

			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			if(CheckUtil.checkSignature(signature, timestamp, nonce)){
				HashMap map=ParseXmlGetMapUtil.ParseXmlGetMap(request);
				
				
			}
			
			
		}

	}

}
