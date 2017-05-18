package com.gmail.tests;

import org.testng.annotations.DataProvider;

import DDframework.ExcelUtils;

public class DataProviderClass {
	
	@DataProvider(name="Authentication")
	 
    public static Object[][] Authentication() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray("src\\ExcelData.xlsx","LoginData");
 
         return (testObjArray);
 
		}
	
	
	
}
