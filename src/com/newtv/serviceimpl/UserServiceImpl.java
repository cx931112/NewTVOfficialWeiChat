package com.newtv.serviceimpl;

import java.util.List;

import com.newtv.dao.UserDao;
import com.newtv.entity.User;
import com.newtv.factory.ObjectFactory;
import com.newtv.service.UserService;
import com.newtv.transaction.ITransaction;

public class UserServiceImpl implements UserService{
private static ITransaction transaction=(ITransaction)ObjectFactory.getObject("transAction");
private UserDao userDao=(UserDao)ObjectFactory.getObject("userDao");
	public String selectUserByUserName(User user) {
		// TODO Auto-generated method stub
		if(userDao.selectUserByUserName(user)!=null){
			
			return "success";
		}
		else{
			
			
			return "fail";
		}
	}

}
