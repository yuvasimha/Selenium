package com.gmail.compose;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjectModel.GmailPage;

public class UploadFile {
	
	WebDriver driver;

	public WebDriver UploadFile(WebDriver driver,String AutoitLocation){
		
		GmailPage gp = new GmailPage(driver);
		
		gp.composeButton().click();
		gp.attachmentButton().click();
		
		try {
			Thread.sleep(3000L);
			Process proc = Runtime.getRuntime().exec(AutoitLocation);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
	
}
