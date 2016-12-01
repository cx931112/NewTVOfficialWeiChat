package com.newtv.dao;

import java.util.List;

import com.newtv.entity.PlayBill;

public interface ExcelDao {
public void deleteAllPlayBill();
public void savePlayBill(PlayBill playBill);
public List<PlayBill> getAllProgramByMon();
public List<PlayBill> getAllProgramByTue();
public List<PlayBill> getAllProgramByWed();
public List<PlayBill> getAllProgramByThu();
public List<PlayBill> getAllProgramByFri();
public List<PlayBill> getAllProgramBySat();
public List<PlayBill> getAllProgramBySun();
}
