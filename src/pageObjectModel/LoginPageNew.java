package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageNew {

	WebDriver driver;
	public LoginPageNew(WebDriver driver) {
		this.driver=driver;
	}
	By userName=By.id("identifierId");
	By password=By.xpath(".//*[@id='password']/div[1]/div/div[1]/input");
	By userNameNext=By.id("identifierNext");
	By signInButton=By.xpath(".//div[@id='passwordNext']");
	
  public WebElement userName(){
    	return driver.findElement(userName);
  }
   
  public WebElement password(){
    	return driver.findElement(password);
  }
  
  public WebElement userNameNext(){
  	return driver.findElement(userNameNext);
  }
  
  public WebElement signInButton(){
	  	return driver.findElement(signInButton);
	}
}
