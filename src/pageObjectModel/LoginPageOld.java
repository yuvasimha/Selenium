package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageOld {

	WebDriver driver;
	public LoginPageOld(WebDriver driver) {
		this.driver=driver;
	}
	By userName=By.id("Email");
	By password=By.id("Passwd");
	By userNameNext=By.id("next");
	By signInButton=By.id("signIn");
	
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
