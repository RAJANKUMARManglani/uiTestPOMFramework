package com.Dsci.SuiteBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Dsci.SuiteBase.GenericLib;
import com.Dsci.ReadPropertyFile.ReadPropertyFile;

public class ProjectspecificFunctions extends GenericLib{
	public String ExpectedPage5header = "Coverages & Pricing" ;

	public void additionalInterstTillPayment() throws FileNotFoundException, IOException {
		JavascriptHelper js1 = new JavascriptHelper(driver);
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

}
