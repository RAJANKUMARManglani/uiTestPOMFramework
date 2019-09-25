package com.Dsci.TestScriptsSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import com.Dsci.SuiteBase.GenericLib;
import com.Dsci.SuiteBase.JavascriptHelper;

public class BOP extends GenericLib{
	
	public BOP(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String ExpectedPage1header = "Tell us about your business";
	public String ExpectedPage2header = "Choose Your Policy";
	   public static WebDriver driver;
	


  @BeforeTest
  public void beforeTest() {
	// Launch the browser and open the url
		  OpenApp("CH","https://solutions.mckinsey.com/dsci-qa/ef1d3125-0d84-4906-8a92-c2eb40f2c342?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5paXN0MjcxMUBnbWFpbC5jb20iLCJ0ZW5hbnQiOiJlZjFkMzEyNS0wZDg0LTQ5MDYtOGE5Mi1jMmViNDBmMmMzNDIiLCJzY29wZSI6Ik1BR0lDX0xJTksiLCJpYXQiOjE1NjkxNzM0NzcsImV4cCI6MTU2OTQzMjY3N30.TAam28TXAFnCHn8-9C90jkwmkRM9sQr_foRgOwJoK_s" );
	      System.out.print("App url is launched in chrome browser");
  }
  
  @Test
  public void BOPTest() 
  {
	  // Click on continue
      WebElement  BussinesslookupContinue =	getElementByXpath(System.getProperty("BussinessLookUpContinueButton"));
      BussinesslookupContinue.click();

      // Select No for Question 1 in Tell us about your business
      
      WebElement  AppAssistQuestion1 =	getElementByXpath(System.getProperty("AppAssistQuestion1"));
      // Wait for Element to be clickable
      WaitForElementClickable(AppAssistQuestion1, 10);
      
      AppAssistQuestion1.click();  
      
   // Verify header
  WebElement  BussinessLookheader =	getElementByXpath(System.getProperty("TellUsAboutBussinessHeader"));
  String actualheader =getElementText(BussinessLookheader);
  
  Assert.assertEquals(actualheader,ExpectedPage1header ,"Header of page is not correct");

  
  // Click on PolicyRecommendationContinueButton 
  WebElement  PolicyRecommendationContinueButton =	getElementByXpath(System.getProperty("PolicyRecommendationContinueButton"));
  PolicyRecommendationContinueButton.click();
  
  // Verify the header
  WebElement  ChooseYourPolicyHeader =	getElementByXpath(System.getProperty("ChooseYourPolicyHeader"));
  String actualChooseYourPolicyHeader =getElementText(ChooseYourPolicyHeader);
  Assert.assertEquals(actualChooseYourPolicyHeader, ExpectedPage2header ,"Header of page is not correct");
  
  // Click on Business Owners Policy to unselect
  WebElement UnselectBussinessOwnerPolicy   =	getElementByXpath(System.getProperty("UnselectBussinessOwnerPolicy"));
  UnselectBussinessOwnerPolicy.click();
  setImplicitWait(10,TimeUnit.SECONDS);
  
  // Click on ChooseYourPolicyContinueButton
  WebElement  ChooseYourPolicyContinueButton =	getElementByXpath(System.getProperty("ChooseYourPolicyContinueButton"));
  ChooseYourPolicyContinueButton.click();
  
  setImplicitWait(10,TimeUnit.SECONDS);
  
             //underwritting questions level 1
               getElementById(System.getProperty("UnderwrittingQuestion1")).click();
            //underwritting questions level 2
               getElementById(System.getProperty("UnderwrittingQuestion2")).click();
            //underwritting questions level 3
             getElementById(System.getProperty("UnderwrittingQuestion3")).click();
            //underwritting questions level 4
             getElementById(System.getProperty("UnderwrittingQuestion4")).click();
           //underwritting questions level 5
            getElementById(System.getProperty("UnderwrittingQuestion5")).click();
          //underwritting questions level 6
          getElementById(System.getProperty("UnderwrittingQuestion6")).click();
  
           // Enter the Longer than 5 years in How many years has the same management been in place?

  WebElement years  =getElementByXpath(System.getProperty("Underwrittingyears"));
  JavascriptHelper js1 = new JavascriptHelper(driver);
  js1.scrollToElement(years);
  setImplicitWait(10,TimeUnit.SECONDS);
  years.click();
  getElementById(System.getProperty("UnderwrittingMorethan5years")).click();
  

 // Click on underwritting continue button
  getElementById(System.getProperty("UnderwrittingContinueButton")).click();
  System.out.println("Click on underwritting continue button");

  
  
	  
	  
	  
  }
  
  
  
  

  @AfterTest
  public void afterTest() {
  }

}
