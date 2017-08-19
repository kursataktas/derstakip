package com.humtk.controller.student;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.humtk.domain.StudentCourseDailyAttendance;

public class ExcelDevamsizlik extends AbstractXlsView{
	 
	 @Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
		 HttpServletResponse response) throws Exception {
		 
		 response.setHeader("Content-Disposition", "attachment;filename=\"devamsizlik.xls\"");
		 List<StudentCourseDailyAttendance> attendance = (List<StudentCourseDailyAttendance>) model.get("attendances");
		 Sheet sheet = workbook.createSheet("Devamsizlik");
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("Dersin Adi");
		 header.createCell(1).setCellValue("Tarih");
		 header.createCell(2).setCellValue("Var/Yok");

		 int rowNum = 1;
		 for(StudentCourseDailyAttendance sa: attendance){
			 Row row = sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(sa.getCourse().getName());
			 row.createCell(1).setCellValue(sa.getDateStr());
			 row.createCell(2).setCellValue(sa.isAttendance()?"Var":"Yok");
		 }
		 
		 
	}
}