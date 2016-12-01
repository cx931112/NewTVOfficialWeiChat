package com.newtv.weixin.util;


import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import com.newtv.entity.PlayBill;

public class PraseExcelGetListUtil {
     public static List<List<PlayBill>> GetExcelList(InputStream in,String filename) throws IOException {
		List<List<PlayBill>> list=new ArrayList<List<PlayBill>>();
		
		if(filename.endsWith(".xls")){
			HSSFWorkbook hssfWorkbook=new HSSFWorkbook(in);
			int sheetNumbers=hssfWorkbook.getNumberOfSheets();
			
			for(int sheetNum=0;sheetNum<sheetNumbers;sheetNum++){
				
				HSSFSheet sheet=hssfWorkbook.getSheetAt(sheetNum);
				if(sheet==null){
					continue;
				}
				String sheetName=sheet.getSheetName();
				
//				int firstRowNum=sheet.getFirstRowNum();
				
				int lastRowNum=sheet.getLastRowNum();
				
				List<PlayBill> playbills=new ArrayList<PlayBill>();
			    for(int rowNum=3;rowNum<=lastRowNum;rowNum++){
			    	Row row=sheet.getRow(rowNum);
			    	if(row==null){
			    		continue;
			    	}
			    	int firstCellNum=row.getFirstCellNum();
//			        int lastCellNum=row.getLastCellNum();
	                
	                
	                for(int i=0;i<7;i++){
	                	PlayBill playBill=new PlayBill();
	                	System.out.println("sheetName:"+sheetName);
	                	String day=null;
	                	
                        String start_time=getStringValue(row.getCell(firstCellNum+i*7+0));
                        System.out.println("start_time:"+start_time);
                       
                        String end_time=getStringValue(row.getCell(firstCellNum+i*7+1));
                        System.out.println("end_time:"+end_time);
                        String program=getStringValue(row.getCell(firstCellNum+i*7+2));
                        System.out.println("program:"+program);
//                        String program_time=getStringValue(row.getCell(firstCellNum+i*7+3));
//                        System.out.println("program_time:"+program_time);
//                        String remark=getStringValue(row.getCell(firstCellNum+i*7+4));
//                        System.out.println("remark:"+remark);
//                        String grade=getStringValue(row.getCell(firstCellNum+i*7+5));
//                        System.out.println("grade:"+grade);
//                        String blank=getStringValue(row.getCell(firstCellNum+i*7+6));
//                        System.out.println("blank:"+blank);
	                	switch(i){
	                	case 0:day="星期一";break;
	                	case 1:day="星期二";break;
	                	case 2:day="星期三";break;
	                	case 3:day="星期四";break;
	                	case 4:day="星期五";break;
	                	case 5:day="星期六";break;
	                	case 6:day="星期日";break;
	                	
	                	}
	                	System.out.println("day:"+day);
	                		playBill.setDay(day);
	                		playBill.setChannelname(sheetName);
	                		playBill.setStart_time(start_time);
	                		playBill.setEnd_time(end_time);
	                		playBill.setProgram(program);
//	                		playBill.setProgram_time(program_time);
//	                		playBill.setRemark(remark);
//	                		playBill.setGrade(grade);
//	                		playBill.setBlank(blank);
	                		if((playBill.getStart_time().equals("00:00:00")&&playBill.getEnd_time().equals("00:00:00"))){
	                		    continue;
	                		}
	                		if((playBill.getStart_time().equals("")||playBill.getEnd_time().equals(""))){
	                			continue;
	                		}
                         playbills.add(playBill);
	                	
	                }
	                
			    }
			    
			    list.add(playbills);
			}
		}
		else if(filename.endsWith(".xlsx")){
			
			
		}

	    System.out.println("一共存入了："+list.size()+"页数据");
		return list;
		
		
    	 
     }
     public static String getStringValue(Cell cell){
    	 if(cell==null){
    		 return "";
    	 }
    	 else{
    		 if(cell.getCellType()==Cell.CELL_TYPE_STRING){
    			 return cell.getStringCellValue();
    		 }
    		 else{
    			 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    			 return sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
    		 }
    	 }
    	 
//    4、	 DecimalFormat df = new DecimalFormat("#");
//    	 
//    	 if (cell == null)
// 			return "";
// 		switch (cell.getCellType()) {
// 		case Cell.CELL_TYPE_NUMERIC:
// 			if(DateUtil.isCellDateFormatted(cell)){
// 				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
// 				return sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
// 			}
// 			return df.format(cell.getNumericCellValue());
// 		case Cell.CELL_TYPE_STRING:
// 			
// 			return cell.getStringCellValue();
// 		case Cell.CELL_TYPE_FORMULA:
// 			return cell.getCellFormula();
// 		case Cell.CELL_TYPE_BLANK:
// 			return "";
// 		case Cell.CELL_TYPE_BOOLEAN:
// 			return cell.getBooleanCellValue() + "";
// 		case Cell.CELL_TYPE_ERROR:
// 			return cell.getErrorCellValue() + "";
// 		}
// 		return "";
//	2、	return value;
//    	 String cellValue = "";      
//         switch (cell.getCellType()) {      
//         case Cell.CELL_TYPE_STRING://字符串类型   
//             cellValue = cell.getStringCellValue();      
//             if(cellValue.trim().equals("")||cellValue.trim().length()<=0)      
//                 cellValue=" ";      
//             break;      
//         case Cell.CELL_TYPE_NUMERIC: //数值类型   
//             cellValue = String.valueOf(cell.getNumericCellValue());      
//             break;      
//         case Cell.CELL_TYPE_FORMULA: //公式   
//             cell.setCellType(Cell.CELL_TYPE_NUMERIC);      
//             cellValue = String.valueOf(cell.getNumericCellValue());      
//             break;      
//         case Cell.CELL_TYPE_BLANK:      
//             cellValue=" ";      
//             break;      
//         case Cell.CELL_TYPE_BOOLEAN:      
//             break;      
//         case Cell.CELL_TYPE_ERROR:      
//             break;      
//         default:      
//             break;      
//         }      
//         return cellValue;      
 
    	 
//   3、 	   if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
//               // 返回布尔类型的值
//               return String.valueOf(cell.getBooleanCellValue());
//           } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//               // 返回数值类型的值
//               return String.valueOf(cell.getNumericCellValue());
//           } else {
//               // 返回字符串类型的值
//               return String.valueOf(cell.getStringCellValue());
//           }
       }
    	 
     
}