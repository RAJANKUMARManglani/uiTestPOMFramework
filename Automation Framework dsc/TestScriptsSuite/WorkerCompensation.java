package com.Dsci.TestScriptsSuite;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.Dsci.ReadPropertyFile.ReadPropertyFile;
import com.Dsci.SuiteBase.GenericLib;
import com.Dsci.SuiteBase.JavascriptHelper;
import org.testng.annotations.BeforeTest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WorkerCompensation extends GenericLib{
	public String ExpectedPage1header = "Tell us about your business";
	public String ExpectedPage2header = "Choose Your Policy";
	public String ExpectedPage3header = "Policy Level";
	public String ExpectedPage4header = "Company Officers" ;
	public String ExpectedPage5header = "Coverages & Pricing" ;

	 WebDriver driver;
   @BeforeTest

 public void setUp() throws Exception {
        // setup("chrome");
		//driver= new GenericLib().driver;
	   // System Property for Chrome Driver   
	   String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.chrome.driver",path + "/TestBrowsers/chromedriver");
         
            // Instantiate a ChromeDriver class.     
       WebDriver driver=new ChromeDriver();  
         
          // Launch Website 
       driver.get("https://dsc.mvp01.dev.nvt.mckinsey.cloud/dsci/ef1d3125-0d84-4906-8a92-c2eb40f2c342?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InJhamFubTIuNzExQGdtYWlsLmNvbSIsInRlbmFudCI6ImVmMWQzMTI1LTBkODQtNDkwNi04YTkyLWMyZWI0MGYyYzM0MiIsInNjb3BlIjoiTUFHSUNfTElOSyIsImlhdCI6MTU3MDYwNjUxOSwiZXhwIjoxNTcwODY1NzE5fQ.cY_fULRrOUHWhDmBiO9QZcOvVwJZ4stX9JJMXzPkl6g");
        //Maximize the browser  
         driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }


	@Test
	  public void WorkerCompensationTest() throws FileNotFoundException, IOException 
	{
		// Call common function for Bussinesslook up page
	//	ProjectspecificFunctions common = new ProjectspecificFunctions();
	//	common.Bussinesslookup();
	    //  setImplicitWait(20,TimeUnit.SECONDS);

		  // Click on continue
	      WebElement  BussinesslookupContinue =	driver.findElement(By.xpath((ReadPropertyFile.ReadElementObjectRepo("BussinessLookUpContinueButton"))));
	      JavascriptHelper js1 = new JavascriptHelper(driver);
	      js1.scrollToElement(BussinesslookupContinue);
	      JavascriptHelper obj = new JavascriptHelper(driver);
	      obj.clickElement(BussinesslookupContinue);
	      setImplicitWait(20,TimeUnit.SECONDS);
  
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
                  
                   // Click on workerCompensation to select
                   WebElement SelectWorkercompensationpolicy =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("SelectWorkercompensationpolicy"));
                   SelectWorkercompensationpolicy.click();
                   
                   // Click on ChooseYourPolicyContinueButton
                   WebElement  ChooseYourPolicyContinueButton =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ChooseYourPolicyContinueButton"));
                   ChooseYourPolicyContinueButton.click();
                   
                   setImplicitWait(10,TimeUnit.SECONDS);
                   
                   // Verify the PolicyLevel header
                   WebElement  PolicyLevelHeader =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelHeader"));
                   String actualPolicyLevelHeader =getElementText(PolicyLevelHeader);
                   Assert.assertEquals(actualPolicyLevelHeader, ExpectedPage3header ,"Header of page is not correct");
                   
                   // Click on Policy level question 1
                   WebElement PolicyLevelAns1 =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns1"));
                   PolicyLevelAns1.click();
                   System.out.println("Selected no for Do you have employees (such as a cashier) who are dedictated to selling your product in a retail portion of your establishment (or a separate storefront you own) and do not work at all in your production area?");
                   
                   // Click on Policy level question 2
                   WebElement PolicyLevelAns2 =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns2"));
                   PolicyLevelAns2.click();
                   System.out.println("Selected Yes for Do you employ salespeople to visit potential customers? ");

                   // Enter Number of traveling salespeople 
                   WebElement  PolicyLevelAns21 =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns21"));
                   PolicyLevelAns21.clear();
                   PolicyLevelAns21.sendKeys("2");
                   System.out.println("Enter 2 Number of traveling salespeople ");
                   
                   //Enter Salespeople Payroll
                   WebElement  PolicyLevelAns22 =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns22"));
                   js1.scrollToElement(PolicyLevelAns22);
                   PolicyLevelAns22.sendKeys("10000");
                   System.out.println("Enter 10000 Salespeople Payroll ");

                   // Answer for quest Is your annual employee turnover less than 30%?
                   WebElement PolicyLevelAns3 =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns3"));
                   PolicyLevelAns3.click();
                   System.out.println("Selected no for Is your annual employee turnover less than 30%? ");

                   // Answer for question Do you provide your employees with health benefits?
                   WebElement PolicyLevelAns4 =getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns4"));
                   PolicyLevelAns4.click();
                   System.out.println("Selected no for Do you provide your employees with health benefits? ");
   
                   // Answer for question Do you have an experience modification factor, published by a Workers' Compensation rating bureau (NCCI, WCIRB, etc)?
                   WebElement  PolicyLevelAns5 =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns5"));
                   js1.scrollToElement(PolicyLevelAns5);
                   PolicyLevelAns5.click();
                   System.out.println("Selected Yes for Do you have an experience modification factor, published by a Workers' Compensation rating bureau (NCCI, WCIRB, etc)?"); 
                   
                    // Enter the Experience Mod
                   WebElement  PolicyLevelAns51 =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelAns51"));
                   PolicyLevelAns51.clear();
                   PolicyLevelAns51.sendKeys("0.35");
                   System.out.println("Enter 0.35 in Experience Mod ");
                   
                   // Click on PolicyLevelContinueButton
                   WebElement PolicyLevelContinueButton =getElementById(ReadPropertyFile.ReadElementObjectRepo("PolicyLevelContinueButton"));
                   PolicyLevelContinueButton.click();
                   
                   setImplicitWait(15,TimeUnit.SECONDS);
                   

                   // Verify company officer header
                   
                   WebElement  CompanyofficerHeader =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("CompanyofficerHeader"));
                   String actualCompanyofficerHeader =getElementText(CompanyofficerHeader);
                   Assert.assertEquals(actualCompanyofficerHeader, ExpectedPage4header ,"Header of page is not correct");
                   
                    // Enter company officer name
                   WebElement  OfficerNameText =	getElementById(ReadPropertyFile.ReadElementObjectRepo("OfficerNameText"));
                   OfficerNameText.clear();
                   OfficerNameText.sendKeys("first");
                   System.out.println("Enter first in company officer name ");
                   
                   // Select No for covered radio button
                   WebElement  OfficerCoveredAns =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("OfficerCoveredAns"));
                   js1.scrollToElement(OfficerCoveredAns);
                   OfficerCoveredAns.click();  
                   System.out.println("Selected Yes for covered radio button ");    
                   
                   // Click on Continue button
                   getElementById(ReadPropertyFile.ReadElementObjectRepo("CompanyOfficerContinuebutton")).click();
                   System.out.println("Click on CompanyOfficerContinuebutton ");    

                   // Enter Production payroll
                   WebElement  MonthlyPayrolltextbox =	getElementById(ReadPropertyFile.ReadElementObjectRepo("MonthlyPayrolltextbox"));
                   MonthlyPayrolltextbox.clear();
                   MonthlyPayrolltextbox.sendKeys("100000");
                   System.out.println("Enter Production payroll");
                   
                   // Enter the No of production employees
                   WebElement  NoofProdEmployeeText =	getElementById(ReadPropertyFile.ReadElementObjectRepo("NoofProdEmployeeText"));
                   NoofProdEmployeeText.clear();
                   NoofProdEmployeeText.sendKeys("2");
                   System.out.println("Enter No of production employees");
                   
                   // Enter clerical Payroll 
                   WebElement  clericalPayrollTextbox =	getElementById(ReadPropertyFile.ReadElementObjectRepo("clericalPayrollTextbox"));
                   clericalPayrollTextbox.clear();
                   clericalPayrollTextbox.sendKeys("25000");
                   System.out.println("Enter clericalPayroll");
                   
                   // Enter the No of clerical employees
                   WebElement  NoofClearicalEmployeeText =	getElementById(ReadPropertyFile.ReadElementObjectRepo("NoofClearicalEmployeeText"));
                   NoofClearicalEmployeeText.clear();
                   NoofClearicalEmployeeText.sendKeys("2");
                   System.out.println("Enter  No of Clearical Employee");
                   
                   // Click on CompanyPayrollContinuebutton                   
                   js1.clickElement(getElementById(ReadPropertyFile.ReadElementObjectRepo("CompanyPayrollContinuebutton")));
                   System.out.println("click on Company Payroll Continue button");
                   setImplicitWait(20,TimeUnit.SECONDS);
                   
                   // Select No for Additional Interest question
                   getElementById(ReadPropertyFile.ReadElementObjectRepo("AdditionalInterstQuestion")).click();
                   System.out.println("Select No for AdditionalInterstQuestion ");    
                   
                   // Click on Continue on Additional Interset page
                   getElementById(ReadPropertyFile.ReadElementObjectRepo("AdditionalContinuebutton")).click();
                   System.out.println("click on Additional Continue button ");   
                   
                   // Wait for element CoveragePricingheader to visible
                   WebElement  CoveragePricingheader =	getElementById(ReadPropertyFile.ReadElementObjectRepo("CoveragePricingheader"));
                   WaitForElementVisibleWithPollingTime(CoveragePricingheader,30,10) ;
                   String actualCoveragePricingheader =getElementText(CoveragePricingheader);
                   Assert.assertEquals(actualCoveragePricingheader, ExpectedPage5header ,"Header of page is not correct");
                   
                   // store Policy Applied by user in Pricing page in actualWorkercompensationHeader
                   WebElement  WorkercompensationHeader =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("WorkercompensationHeader"));
                   String actualWorkercompensationHeader =getElementText(WorkercompensationHeader);
                   
                   // Store price of policy in pricing page
                   WebElement  PriceofPolicy =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PriceofPolicy"));
                   String actualPriceofPolicy =getElementText(PriceofPolicy);
                   
                   // Click on Pricingpage continue button
                   js1.clickElement(getElementById(ReadPropertyFile.ReadElementObjectRepo("PricingpageContinue")));
                   System.out.println("Click on PricingpageContinue button");    

                   // Click on Pay in full payment plan
                   getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ChoosePaymentplan")).click();
                   System.out.println("click on ChoosePaymentplan ");   
                   // Click on Paymentdetails Continue Button
                   js1.clickElement(getElementById(ReadPropertyFile.ReadElementObjectRepo("PaymentdetailsContinueButton")));
                   System.out.println("click on Payment details Continue Button ");   
                   setImplicitWait(20,TimeUnit.SECONDS);
                   
                   // Navigate to review page
                   WebElement  ReviewPageDisclosurename =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("ReviewPageDisclosurename"));
                   js1.scrollToElement(ReviewPageDisclosurename);
                   ReviewPageDisclosurename.clear();
                   ReviewPageDisclosurename.sendKeys("jack");
                   
                   // Select the acknowledge checkmark in checkmarkpage
                   getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("AcknowledgeCheckbox")).click();
                   System.out.println("Select acknowledge checkmark in checkmarkpage  "); 
                   setImplicitWait(10,TimeUnit.SECONDS);
                   
                   // Click on AcknowledgeContinueButton
                   js1.clickElement(getElementById(ReadPropertyFile.ReadElementObjectRepo("AcknowledgeContinueButton")));
                   System.out.println("Click on Acknowledge Continue Button "); 
                   setImplicitWait(15,TimeUnit.SECONDS);
                   
                   // Validate final payment price & Policy name
                   WebElement  PolicyNameAssert =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("PolicyNameAssert"));
                   String ExpectedPolicyNameAssert =getElementText(PolicyNameAssert);
                   Assert.assertEquals(actualWorkercompensationHeader, ExpectedPolicyNameAssert ,"Policy name is not matched with pricing page & Final payment page");

                   // Store price of policy in Final payment page
                   WebElement  FinalPaymentAssertAmount =	getElementByXpath(ReadPropertyFile.ReadElementObjectRepo("FinalPaymentAssertAmount"));
                   String ExpectedFinalPaymentAssertAmount =getElementText(FinalPaymentAssertAmount);
                   Assert.assertEquals(actualPriceofPolicy, ExpectedFinalPaymentAssertAmount ,"Policy Pricing is not matched in pricing page & Final payment page");
		
	 }
  
  
  @AfterTest
  public void teardown() {
	  
	  // close the browser
      driver.quit();

  }

} 
