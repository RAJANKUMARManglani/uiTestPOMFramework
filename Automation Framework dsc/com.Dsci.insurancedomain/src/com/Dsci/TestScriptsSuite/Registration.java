package com.Dsci.TestScriptsSuite;

import org.testng.annotations.Test;

import com.Dsci.ReadPropertyFile.ReadPropertyFile;
import com.Dsci.SuiteBase.GenericLib;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Registration extends GenericLib{
 
	 WebDriver driver;
    @BeforeMethod

  public void setUp() throws Exception {
	  setup("Firefox");
		driver= new GenericLib().driver;

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

  @AfterMethod
  public void tearDown() {
      driver.quit();
  }
}
