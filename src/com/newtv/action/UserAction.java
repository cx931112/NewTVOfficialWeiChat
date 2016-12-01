package com.newtv.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtv.entity.User;
import com.newtv.factory.ObjectFactory;
import com.newtv.service.UserService;

public class UserAction extends HttpServlet {
	private UserService userService=(UserService)ObjectFactory.getObject("userService");
   public void login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	   request.setCharacterEncoding("utf-8");
	   PrintWriter out=response.getWriter();
	   String userName=request.getParameter("username");
	   String passWord=request.getParameter("password");
	   User user=new User();
	   user.setUserName(userName);
	   user.setPassWord(passWord);
	   if(userService.selectUserByUserName(user).equals("success")){
               
               String json="{\"result\":true}";
               
               out.print(json);
	   }
	   else{
		   
		   String json="{\"result\":false}";
		   
		   out.print(json);
		   
		   
	   }
	   
	   
	   
   } 
   
   public String tomain(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	   request.setCharacterEncoding("utf-8");
	   String userName=request.getParameter("username");
	   
	   User user=new User();
	   user.setUserName(userName);
	   
	   
	   request.getSession().setAttribute("user", user);
	   return "success";
	   
	   
   }
   public String exit(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	request.getSession().invalidate();
	
	return "success";
	   
   }
}
