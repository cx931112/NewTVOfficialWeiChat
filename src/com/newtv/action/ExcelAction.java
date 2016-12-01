package com.newtv.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.newtv.entity.PlayBill;
import com.newtv.factory.ObjectFactory;
import com.newtv.service.ExcelService;
import com.newtv.weixin.util.PraseExcelGetListUtil;

public class ExcelAction extends HttpServlet {
	private ExcelService excelService=(ExcelService)ObjectFactory.getObject("excelService");
	public String prase(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
          String message="文件上传成功！";
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name + "=" + value);

				} else {
					String filename = item.getName();
					if (filename == null || filename.trim().equals("")) {
						throw new Exception();
					}
					InputStream in = item.getInputStream();
					List<List<PlayBill>> allPlaybills= PraseExcelGetListUtil
							.GetExcelList(in, filename);
                      excelService.deleteAllPlayBill();
                      excelService.savePlayBillAll(allPlaybills);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			message="文件解析出错！";
			
			
		}
		
		request.setAttribute("message", message);
		
		return "success";

	}
	public String getprogram(HttpServletRequest request,HttpServletResponse response)throws Exception{
	
			
			List<PlayBill> playbillsmon=excelService.getAllProgramByMon();
			List<PlayBill> playbillstue=excelService.getAllProgramByTue();
			List<PlayBill> playbillswed=excelService.getAllProgramByWed();
			List<PlayBill> playbillsthu=excelService.getAllProgramByThu();
			List<PlayBill> playbillsfri=excelService.getAllProgramByFri();
			List<PlayBill> playbillssat=excelService.getAllProgramBySat();
			List<PlayBill> playbillssun=excelService.getAllProgramBySun();

			request.setAttribute("playbillsmon", playbillsmon);
			
			request.setAttribute("playbillstue", playbillstue);

			request.setAttribute("playbillswed", playbillswed);

			request.setAttribute("playbillsthu", playbillsthu);

			request.setAttribute("playbillsfri", playbillsfri);

			request.setAttribute("playbillssat", playbillssat);

			request.setAttribute("playbillssun", playbillssun);

			return "success";
			

		
	}
}
