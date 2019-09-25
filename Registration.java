package com.Dsci.TestScriptsSuite;

import org.testng.annotations.Test;

import com.Dsci.ReadPropertyFile.ReadPropertyFile;
import com.Dsci.SuiteBase.GenericLib;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Registration extends GenericLib{
 
	public static WebDriver driver;
@BeforeClass
  public void beforeTest() throws Exception {
	  System.out.println("before test");
	  setup("chrome");
	  driver.get("https://solutions.mckinsey.com/dsci-qa/ef1d3125-0d84-4906-8a92-c2eb40f2c342/");
  }
  
  @Test
  public void RegistrationTest() throws IOException, FileNotFoundException 
  {
	  
	  //Enter emailaddress 
      WebElement  Emailaddress =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("Emailaddress"));
      Emailaddress.clear();
      Emailaddress.sendKeys("abcde@yopmail.com");
      
      // Click on date picker
      WebElement  CalenderPickerDateeffective =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("CalenderPickerDateeffective"));
      CalenderPickerDateeffective.click();
      
      //Click on current active date
      WebElement  EffectiveDate =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("EffectiveDate"));
      EffectiveDate.click();
      
      // Enter the zipcode
      WebElement  ZipCode =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ZipCode"));
      ZipCode.clear();
      ZipCode.sendKeys("80204");
      
      // Click on recapacha
      
      driver.switchTo().frame(2);
      WebElement  Recapacha =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("Recapacha"));
      Recapacha.click();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
