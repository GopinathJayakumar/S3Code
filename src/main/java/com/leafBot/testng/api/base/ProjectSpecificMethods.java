package com.leafBot.testng.api.base;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.leafBot.selenium.api.base.SeleniumBase;
import com.leafBot.testng.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase{

	public String dataSheetName;
	
	@BeforeSuite
	public void loadObj() {
		loadObjects();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		eachNode = test.createNode(testCaseName);
		startApp("chrome", "http://leaftaps.com/opentaps");
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

	@DataProvider(name = "fetchData", indices = 1)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	
	
	@AfterSuite
	public void unloadObj() {
		unloadObjects();
	}

	








}