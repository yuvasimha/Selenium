package com.gmail.compose;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DDframework.ExcelUtils;
import pageObjectModel.LoginPageNew;
import pageObjectModel.LoginPageOld;

public class GmailLogin {
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
	
	@SuppressWarnings("finally")
	public WebDriver gmailLogin(WebDriver driver,String FileLocation, String SheetName, int RowNum){
		
		ExcelUtils eu = new ExcelUtils();
		try {
			String[] RowData = eu.getRowData(FileLocation, SheetName, RowNum);
			this.driver = gmailLogin(driver,RowData[1],RowData[2]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return this.driver;
		}
	}
	
	
	@SuppressWarnings("finally")
	public WebDriver gmailLogin(WebDriver driver, String UserName, String Password){
		
		this.driver=driver;
		
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			
			driver.get(prop.getProperty("URL"));
			if(driver.getTitle().equals("Gmail - Free Storage and Email from Google"))
				driver.findElement(By.linkText("Sign In")).click();
			
			LoginPageOld lpo = new LoginPageOld(driver);
			LoginPageNew lpn = new LoginPageNew(driver);
			
			if(driver.findElements(By.id("Email")).size()!=0){	
				lpo.userName().sendKeys(UserName);
				lpo.userNameNext().click();
				lpo.password().sendKeys(Password);
				lpo.signInButton().click();
			}else if(driver.findElements(By.id("identifierId")).size()!=0){
				lpn.userName().sendKeys(UserName);
				lpn.userNameNext().click();
				lpn.password().sendKeys(Password);
				lpn.signInButton().click();
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return this.driver;
		}
	}
}
