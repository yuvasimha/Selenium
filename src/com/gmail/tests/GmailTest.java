package com.gmail.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gmail.compose.DriverSetUp;
import com.gmail.compose.GmailLogin;
import com.gmail.compose.UploadFile;

import ExceptionsHandling.DataNotFoundException;
import pageObjectModel.GmailPage;

@Listeners(TestNGListeners.TestngListeners.class)
public class GmailTest {
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
	
	@BeforeMethod
	public void setup(){
		DriverSetUp ds = new DriverSetUp();
		driver = ds.TestSetup(driver);
		
	}
	
	@Test(dataProvider="Authentication",dataProviderClass=DataProviderClass.class,priority=1,description="Testing Gmail Login Functionality")
	public void GmailLoginTestCase(String status,String UserName,String password) throws InterruptedException{
		//System.out.println(status+"  "+UserName +"   "+password);
		if(UserName == null)
			UserName="";
		if(password == null)
			password="";
		GmailLogin gl = new GmailLogin();
		driver = gl.gmailLogin(driver, UserName, password);
		Thread.sleep(3000L);
		String title = driver.getTitle();
		assert(title.contains(UserName));
		
		
	}
	
	
	@Test(priority=2,description="Testing Gmail attachment Upload Functionality")
	public void GmailUploadTestCase2(){		
		
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			
			GmailLogin gl = new GmailLogin(); 
			if(prop.getProperty("ExcelLocation")== null ||  prop.getProperty("ExcelLocation").equals(""))
				throw new DataNotFoundException("ExcelLocation");
			driver = gl.gmailLogin(driver,prop.getProperty("ExcelLocation"),"LoginData",1);
			
			UploadFile up = new UploadFile();
			if(prop.getProperty("uploadExe") == null || prop.getProperty("uploadExe").equals(""))
				throw new DataNotFoundException("UploadExe");
			driver = up.UploadFile(driver, prop.getProperty("uploadExe"));
			
			GmailPage gp = new GmailPage(driver);
			assert(gp.attachmentBox().size()>0);
			gp.deleteComposeMail().click();
			
		}catch(DataNotFoundException e){
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Test(priority=2,description="Testing Gmail attachment Upload Functionality")
	public void GmailUploadTestCase(){		
		
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			
			GmailLogin gl = new GmailLogin(); 
			if(prop.getProperty("ExcelLocation")== null ||  prop.getProperty("ExcelLocation").equals(""))
				throw new DataNotFoundException("ExcelLocation");
			driver = gl.gmailLogin(driver,prop.getProperty("ExcelLocation"),"LoginData",1);
			
			UploadFile up = new UploadFile();
			if(prop.getProperty("uploadExe") == null || prop.getProperty("uploadExe").equals(""))
				throw new DataNotFoundException("UploadExe");
			driver = up.UploadFile(driver, prop.getProperty("uploadExe"));
			
			GmailPage gp = new GmailPage(driver);
			assert(gp.attachmentBox().size()>0);
			gp.deleteComposeMail().click();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	@AfterMethod
	public void CleanUp(){
		driver.close();
	}
}
