package com.gmail.compose;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetUp {
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
	
	@SuppressWarnings("finally")
	public WebDriver TestSetup(WebDriver driver){
		this.driver=driver;
		try{
			input = new FileInputStream("src\\config.properties");
			prop.load(input);
			if(prop.getProperty("browser").equals("Chrome")){
				System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverLocation"));				
				driver= new ChromeDriver();
			}else if(prop.getProperty("browser").equals("Firefox")){
				System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxDriverLocation"));				
				driver= new FirefoxDriver();
			}else if(prop.getProperty("browser").equals("IE")){
				System.setProperty("webdriver.ie.driver",prop.getProperty("ieDriverLocation"));				
				driver= new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return driver;
		}
	}

	
}
