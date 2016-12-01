package com.newtv.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.newtv.dao.ExcelDao;
import com.newtv.entity.PlayBill;
import com.newtv.factory.ObjectFactory;
import com.newtv.service.ExcelService;
import com.newtv.transaction.ITransaction;

public class ExcelServiceImpl implements ExcelService{
	private static ITransaction transaction=(ITransaction)ObjectFactory.getObject("transAction");
	private ExcelDao excelDao=(ExcelDao)ObjectFactory.getObject("excelDao");
	public void deleteAllPlayBill() throws Exception {
		// TODO Auto-generated method stub
		try{
			transaction.beginTransaction();
		excelDao.deleteAllPlayBill();
		transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}

	}
	public void savePlayBillAll(List<List<PlayBill>> list) throws Exception  {
		// TODO Auto-generated method stub
		try{
			transaction.beginTransaction();
          for(int i=0;i<list.size();i++){
              List<PlayBill> playbills=list.get(i);
              for(int k=0;k<playbills.size();k++){
                 PlayBill playbill=playbills.get(k);
                 excelDao.savePlayBill(playbill);
              }
          }
          transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
//		try{
//		PlayBill playBill=new PlayBill();
//		playBill.setStart_time("00:00:00");
//		playBill.setEnd_time("00:00:00");
//		
//		transaction.beginTransaction();
//		excelDao.savePlayBill(playBill);
//		transaction.commit();
//		}

		
	}
	public List<PlayBill> getAllProgramByMon() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

			playbills=excelDao.getAllProgramByMon();

		return playbills;
	}
	public List<PlayBill> getAllProgramByTue() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramByTue();

	return playbills;
	}
	public List<PlayBill> getAllProgramByWed() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramByWed();

	return playbills;
	}
	public List<PlayBill> getAllProgramByThu() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramByThu();

	return playbills;
	}
	public List<PlayBill> getAllProgramByFri() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramByFri();

	return playbills;
	}
	public List<PlayBill> getAllProgramBySat() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramBySat();

	return playbills;
	}
	public List<PlayBill> getAllProgramBySun() throws Exception {
		// TODO Auto-generated method stub
		List<PlayBill> playbills=new ArrayList<PlayBill>();

		playbills=excelDao.getAllProgramBySun();

	return playbills;
	}

	
	
	
	
	
}
