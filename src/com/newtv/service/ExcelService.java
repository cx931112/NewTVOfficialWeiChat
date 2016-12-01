package com.newtv.service;

import java.util.List;

import com.newtv.entity.PlayBill;

public interface ExcelService {
public void deleteAllPlayBill() throws Exception;
public void savePlayBillAll(List<List<PlayBill>> list) throws Exception;

public List<PlayBill> getAllProgramByMon() throws Exception;
public List<PlayBill> getAllProgramByTue() throws Exception;
public List<PlayBill> getAllProgramByWed() throws Exception;
public List<PlayBill> getAllProgramByThu() throws Exception;
public List<PlayBill> getAllProgramByFri() throws Exception;
public List<PlayBill> getAllProgramBySat() throws Exception;
public List<PlayBill> getAllProgramBySun() throws Exception;
}
