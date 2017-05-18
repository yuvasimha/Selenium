package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailPage {
	WebDriver driver;
	public GmailPage(WebDriver driver) {
		this.driver=driver;
	}
	By composeButton=By.xpath(".//div[text()='COMPOSE']");
	By attachmentButton=By.xpath(".//div[@class='M9']/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[4]/div/div[1]/div/div/div");
	By deleteComposedMail=By.xpath(".//div[@class='M9']/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[6]/div/div[1]/div/div");
	By attachmentBox=By.xpath(".//*[@id=':lb']/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[2]/div/div/div/div/div");
	
	public WebElement composeButton(){
    	return driver.findElement(composeButton);
	}
   
	public WebElement attachmentButton(){
    	return driver.findElement(attachmentButton);
	}
  
	public List<WebElement> attachmentBox(){
		return driver.findElements(deleteComposedMail);
	}
	
	public WebElement deleteComposeMail(){
		return driver.findElement(deleteComposedMail);
	}
}
