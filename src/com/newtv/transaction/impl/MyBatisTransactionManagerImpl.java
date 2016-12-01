package com.newtv.transaction.impl;

import org.apache.ibatis.session.SqlSession;

import com.newtv.exception.DataAccessException;
import com.newtv.transaction.ITransaction;
import com.newtv.util.MybatisUtil;

public class MyBatisTransactionManagerImpl implements ITransaction {

	public void beginTransaction() {
		SqlSession session=null;
		try {
			session=MybatisUtil.getSession();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void commit() {
		SqlSession session=null;
		try {
			session=MybatisUtil.getSession();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("数据访问失败",e);
		}		
	}

	public void rollback() {
		SqlSession session=null;
		try {
			session=MybatisUtil.getSession();
			session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

}
