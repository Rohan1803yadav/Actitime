package com.Actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Actitime.GenericLiabrery.Baseclass;
import com.Actitime.GenericLiabrery.FileLiabrary;
import com.Actitime.pom.Homepage;
import com.Actitime.pom.TaskPage;
 
public class Create_Customer extends Baseclass {
	FileLiabrary flib=new FileLiabrary();
	@Test
	public void Createcustomer() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp=new TaskPage(driver);
		String custname = flib.readDataFromExcel("Sheet1", 2, 1);
		String description = flib.readDataFromExcel("Sheet1", 1, 2);
		tp.completetask(custname, description);
		String expected=custname
		