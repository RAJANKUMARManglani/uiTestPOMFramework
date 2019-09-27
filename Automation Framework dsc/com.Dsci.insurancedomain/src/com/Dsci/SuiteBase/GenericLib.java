package com.Dsci.SuiteBase;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericLib {
	
	public  WebDriver driver;
	Logger log;
	public WebDriver setup(String browser) throws Exception{
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", path + "/TestBrowsers/geckodriver");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			
			
			try { 
		    	  System.setProperty("webdriver.http.factory", "apache");
		    	//set path to chromedriver.exe
					System.setProperty("webdriver.chrome.driver",path + "/TestBrowsers/chromedriver");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches","--disable-extensions");
					new DesiredCapabilities();
					DesiredCapabilities caps = DesiredCapabilities.chrome();
					caps.setCapability(ChromeOptions.CAPABILITY, options);
					caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
			                  UnexpectedAlertBehaviour.IGNORE);
					Map<String, Object> prefs = new HashMap<String, Object>();
				
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put("download.prompt_for_download", "false");
					
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
			
					driver = new ChromeDriver(caps);
					driver.manage().window().maximize();
					return driver;	
					
		      } 

		      catch (Exception ex) { 
		        ex.printStackTrace();
		    	  throw new RuntimeException
		              ("couldnt create chrome driver"); 
		      } 
			
			
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","TestBrowsers/MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
				else if(browser.equalsIgnoreCase("IE")){
					//set path to Edge.exe
					System.setProperty("webdriver.ie.driver","TestBrowsers/IEDriverServer.exe");
					//create Edge instance
					driver = new InternetExplorerDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	


	
	/**

	 * This is ImplicitWait method

	 * 

	 * @param timeout

	 * @param unit

	 */

	public void setImplicitWait(long timeout, TimeUnit unit) {

		log.info("Implicit Wait has been set to: " + timeout);

		driver.manage().timeouts().implicitlyWait(timeout, unit);

	}



	/**

	 * This will help us to get WebDriverWait object

	 * 

	 * @param timeOutInSeconds

	 * @param pollingEveryInMiliSec

	 * @return

	 */

	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));

		wait.ignoring(NoSuchElementException.class);

		wait.ignoring(ElementNotVisibleException.class);

		wait.ignoring(StaleElementReferenceException.class);

		wait.ignoring(NoSuchFrameException.class);

		return wait;

	}



	/**

	 * This method will make sure element is visible

	 * 

	 * @param element

	 * @param timeOutInSeconds

	 * @param pollingEveryInMiliSec

	 */

	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,

			int pollingEveryInMiliSec) {

		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");

		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);

		wait.until(ExpectedConditions.visibilityOf(element));

		log.info("element is visible now");

	}



	/**

	 * This method will make sure elementToBeClickable

	 * 

	 * @param element

	 * @param timeOutInSeconds

	 */

	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {

		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		log.info("element is clickable now");

	}



	/**

	 * This method will make sure invisibilityOf element

	 * 

	 * @param element

	 * @param timeOutInSeconds

	 * @return

	 */

	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {

		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));

		log.info("element is invisibile now");

		return status;

	}



	/**

	 * This method will wait for frameToBeAvailableAndSwitchToIt

	 * 

	 * @param element

	 * @param timeOutInSeconds

	 */

	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {

		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

		log.info("frame is available and switched");

	}



	/**

	 * This method will give is fluentWait object

	 * @param timeOutInSeconds

	 * @param pollingEveryInMiliSec

	 * @return

	 */

	private  Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {

		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(timeOutInSeconds))

				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);

		return fWait;

	}

	

	/**

	 * waiit for element visibilityOf using fluent wait

	 * @param element

	 * @param timeOutInSeconds

	 * @param pollingEveryInMiliSec

	 */

	public  WebElement waitForElementFluentWait(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){

		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);

		fwait.until(ExpectedConditions.visibilityOf(element));

		return element;

	}

	

	public void pageLoadTime(long timeout, TimeUnit unit){

		log.info("waiting for page to load for : "+ unit+ " seconds");

		driver.manage().timeouts().pageLoadTimeout(timeout, unit);

		log.info("page is loaded");

	}

	

	/**

	 * This method will make sure elementToBeClickable

	 * 

	 * @param element

	 * @param timeOutInSeconds

	 */

	public void waitForElement(WebElement element, int timeOutInSeconds) {

		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

		wait.until(ExpectedConditions.visibilityOf(element));

		log.info("element is visible now");

	}
	
	public void selectUsingValue(WebElement element,String value) {
		Select select=new Select(element);
		log.info("selecting text by visibleText textis:"+value);
		select.selectByValue(value);
		
	}
	public void selectUsingIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
		log.info("selecting text by index indexNo:"+index);
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		List<String> LnkList=new LinkedList<String>();
		for (WebElement ele : list) {
			LnkList.add(ele.getText());
		}
		return LnkList;
	}

	public  void doubleClickWebelement(WebElement doubleclickonWebElement)
			throws InterruptedException {
			Actions builder = new Actions(driver);
			builder.doubleClick(doubleclickonWebElement).perform();
			Thread.sleep(2000);

			}
	
	public  WebElement getElementById(String elementid) {
		
	WebElement el=	driver.findElement(By.id("elementid"));
	return el;	
	}
	public  WebElement getElementByXpath(String elementxpath) {
		
		WebElement el=	driver.findElement(By.xpath("elementxpath"));
		return el;
			}
   public  WebElement getElementByCssSelector(String elementcss) {
		
		WebElement el=	driver.findElement(By.xpath("elementcss"));
		return el;		
		}
   
   public  String getElementText(WebElement reference) {
	   
	  waitForElementFluentWait(reference,30, 5);
	  String textofElement = reference.getText();
	  return textofElement;
	    }
   
   

}
