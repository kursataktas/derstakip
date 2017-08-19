package com.humtk.controller.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.humtk.domain.Course;

public class ExcelAlinanDersler extends AbstractXlsView{
	 
	 @Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
		 HttpServletResponse response) throws Exception {
		  
		 response.setHeader("Content-Disposition", "attachment;filename=\"alinan dersler.xls\"");
		 List<Course> studentList = (List<Course>) model.get("courses");
		 Sheet sheet = workbook.createSheet("Alınan Dersler");
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("Dersin Kodu");
		 header.createCell(1).setCellValue("Dersin Adı");
		 header.createCell(2).setCellValue("Dersi Veren");
		  
		 int rowNum = 1;
		 for(Course course:studentList){
			 Row row = sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(course.getCourseCode());
			 row.createCell(1).setCellValue(course.getName());
			 row.createCell(2).setCellValue(course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName());
		 }
		 
	}
}