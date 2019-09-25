package com.Dsci.TestScriptsSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.Dsci.ReadPropertyFile.ReadPropertyFile;
import com.Dsci.SuiteBase.GenericLib;
import com.Dsci.SuiteBase.JavascriptHelper;

public class BOP extends GenericLib{
	
	


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
  public void BOPTest() throws FileNotFoundException, IOException 
  {
	  // Click on continue
      WebElement  BussinesslookupContinue =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("BussinessLookUpContinueButton"));
      BussinesslookupContinue.click();

      // Select No for Question 1 in Tell us about your business
      
      WebElement  AppAssistQuestion1 =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("AppAssistQuestion1"));
      // Wait for Element to be clickable
      WaitForElementClickable(AppAssistQuestion1, 10);
      
      AppAssistQuestion1.click();  
      
   // Verify header
  WebElement  BussinessLookheader =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("TellUsAboutBussinessHeader"));
  String actualheader =getElementText(BussinessLookheader);
  
  Assert.assertEquals(actualheader,ExpectedPage1header ,"Header of page is not correct");

  
  // Click on PolicyRecommendationContinueButton 
  WebElement  PolicyRecommendationContinueButton =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyRecommendationContinueButton"));
  PolicyRecommendationContinueButton.click();
  
  // Verify the header
  WebElement  ChooseYourPolicyHeader =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ChooseYourPolicyHeader"));
  String actualChooseYourPolicyHeader =getElementText(ChooseYourPolicyHeader);
  Assert.assertEquals(actualChooseYourPolicyHeader, ExpectedPage2header ,"Header of page is not correct");
  
  // Click on Business Owners Policy to unselect
  WebElement UnselectBussinessOwnerPolicy   =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("UnselectBussinessOwnerPolicy"));
  UnselectBussinessOwnerPolicy.click();
  setImplicitWait(10,TimeUnit.SECONDS);
  
  // Click on ChooseYourPolicyContinueButton
  WebElement  ChooseYourPolicyContinueButton =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ChooseYourPolicyContinueButton"));
  ChooseYourPolicyContinueButton.click();
  
  setImplicitWait(10,TimeUnit.SECONDS);
  
             //underwritting questions level 1
               getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion1")).click();
            //underwritting questions level 2
               getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion2")).click();
            //underwritting questions level 3
             getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion3")).click();
            //underwritting questions level 4
             getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion4")).click();
           //underwritting questions level 5
            getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion5")).click();
          //underwritting questions level 6
          getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingQuestion6")).click();
  
           // Enter the Longer than 5 years in How many years has the same management been in place?

  WebElement years  =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("Underwrittingyears"));
  JavascriptHelper js1 = new JavascriptHelper(driver);
  js1.scrollToElement(years);
  setImplicitWait(10,TimeUnit.SECONDS);
  years.click();
  getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingMorethan5years")).click();
  

             // Click on underwritting continue button
             getElementById(ReadPropertyFile.ReadElementObjectRepo("UnderwrittingContinueButton")).click();
              System.out.println("Click on underwritting continue button");
 
              // Click on Bussiness underwritting Question 1
              getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion1")).click();
               System.out.println("Click on No Business Owners Underwriting Question1 ");
               
               // Click on Bussiness underwritting Question 2
               getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion2")).click();
                System.out.println("Click on No Business Owners Underwriting Question2 ");
                // Click on Bussiness underwritting Question 3
                getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion3")).click();
                 System.out.println("Click on No Business Owners Underwriting Question3 ");
                 // Click on Bussiness underwritting Question 4
                 getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion4")).click();
                  System.out.println("Click on No Business Owners Underwriting Question4 ");
                  // Click on Bussiness underwritting Question 5
                  getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion5")).click();
                   System.out.println("Click on No Business Owners Underwriting Question5 ");
                   // Click on Bussiness underwritting Question 6
                   getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion6")).click();
                    System.out.println("Click on No BusinessOwnersUnderwritingQuestion6 ");
                    
                    // Click on Bussiness underwritting Question 7
                    WebElement BusinessOwnersUnderwritingQuestion7 =    getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion7"));
                    js1.scrollToElement(BusinessOwnersUnderwritingQuestion7);
                    BusinessOwnersUnderwritingQuestion7.click();
                    System.out.println("Click on Bussiness underwritting Question 7");
                    // Select the 3+times a day option in Bussiness underwritting Question 7
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion7Select3plus")).click();
                    System.out.println("Select the 3+times a day option in Bussiness underwritting Question 7 ");
                    
                    
                    // Click on Bussiness underwritting Question 8
                    getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion7")).click();
                    System.out.println("Click on Bussiness underwritting Question 8");
                    
                    // Select daily for Bussiness underwritting Question 8
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritingQuestion8Selectdaily")).click();
                    System.out.println("Select the daily for Bussiness underwritting Question 8 ");
                    
                    // Click on Continue button in Bussiness owners underwritting page
                    
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BusinessOwnersUnderwritinContinue")).click();
                    System.out.println("Click on BusinessOwnersUnderwritinContinue ");
                    

                    // User navigated to Building & location page
                    WebElement BuildingsAnnualsale =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsAnnualsale"));
                    BuildingsAnnualsale.sendKeys("100000");
                    System.out.println("Enter 1000000 in annual sales at location");
                    
                    // Select no for Has your business been at this location for at least 5 years?
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion1")).click();
                    System.out.println("Click on no for Has your business been at this location for at least 5 years?");
                    
                    // Select No for Is this location located in an indoor mall?
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion2")).click();
                    System.out.println("Click on no for Is this location located in an indoor mall?");
                    
                    // Select No for Are you located in a building with a restaurant?
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion3")).click();
                    System.out.println("Click on no for Are you located in a building with a restaurant?");
                    
                    // Click on continue button in buildings section
                    getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("LocationsContinuebutton")).click();
                    System.out.println("Click on continue button in buildings section");
                    
                    // Enter Building description
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BuildingDescriptionText")).sendKeys("coffee shop");
                    System.out.println("Enter  Building description");
                    
                    // Enter the Value of business equipment (best estimate)
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BuildingValueofequipment")).sendKeys("100000");
                    System.out.println("Enter the Value of business equipment");
                    
                    // Select construction type as joisted masonry
                    getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion4")).click();
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion4select")).click();
                    System.out.println("Select construction type as joisted masonry");
                    
                    // enter the year built
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopYearBuilt")).sendKeys("2016");
                    System.out.println("enter the year built as 2016");
                    
                    // select no for Is this building owned by your business?
                    WebElement BopLocBuildingsQuestion5 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion5"));
                    js1.scrollToElement(BopLocBuildingsQuestion5);
                    BopLocBuildingsQuestion5.click();
                    System.out.println("select no for Is this building owned by your business?");

                    
                    // select no for Do you want coverage in the event your coolers break down and your product is spoiled?
                    WebElement BopLocBuildingsQuestion6 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion6"));
                    js1.scrollToElement(BopLocBuildingsQuestion6);
                    BopLocBuildingsQuestion6.click();
                    System.out.println("select no for Do you want coverage in the event your coolers break down and your product is spoiled?");
                    
                    // Select No for Do you occupy the entire building?
                    WebElement BopLocBuildingsQuestion7 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion7"));
                    js1.scrollToElement(BopLocBuildingsQuestion7);
                    BopLocBuildingsQuestion7.click();
                    System.out.println("Select No for Do you occupy the entire building?");
                    
                    // Select yes for Do you have a fire suppression sprinkler system that covers at least 50% of your space?
                    WebElement BopLocBuildingsQuestion8 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion8"));
                    js1.scrollToElement(BopLocBuildingsQuestion8);
                    BopLocBuildingsQuestion8.click();
                    System.out.println("Select yes for Do you have a fire suppression sprinkler system that covers at least 50% of your space?");
                    
                    //select yes for Is there an alarm system?
                    WebElement BopLocBuildingsQuestion9 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion9"));
                    js1.scrollToElement(BopLocBuildingsQuestion9);
                    BopLocBuildingsQuestion9.click();
                    System.out.println("Select yes for Is there an alarm system?");
                    
                    //Select No for Does the alarm system ring at an offsite location that is monitored by a 3rd party?
                    WebElement BopLocBuildingsQuestion91 =    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsQuestion91"));
                    js1.scrollToElement(BopLocBuildingsQuestion91);
                    BopLocBuildingsQuestion91.click();
                    System.out.println("Select No for Does the alarm system ring at an offsite location that is monitored by a 3rd party?");
                    
                    // click on Building continue button
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsContinue")).click();;
                    System.out.println("click on Building continue button");
                    
                    // Click on location & building continue button
                    getElementById(ReadPropertyFile.ReadElementObjectRepo("BopLoc&BuildingsFinalContinue")).click();;
                    System.out.println("Click on location & building continue button");
                    

  // Call common function for completing the purchase
                    ProjectspecificFunctions obj = new ProjectspecificFunctions();
                    obj.additionalInterstTillPayment();
                    




                    

                    
                    
                    
  
	  
	  
	  
  }
  
  
  
  

  @AfterTest
  public void afterTest() {
  }

}
