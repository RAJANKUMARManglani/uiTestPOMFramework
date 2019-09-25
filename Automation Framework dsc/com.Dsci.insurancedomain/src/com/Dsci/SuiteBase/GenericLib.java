package com.Dsci.SuiteBase;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericLib {
	
	public  WebDriver driver;
	
	public  WebDriver OpenApp(String BrowserName, String url){
		
		fn_LaunchBrowser(BrowserName);
		fn_OpenURL(url);
		return driver;
		}
		public  void fn_OpenURL(String url){
		driver.get(url);
		driver.manage().window().maximize();
		}
		 
		public  WebDriver fn_LaunchBrowser(String browsername){
		if(browsername=="CH"){
			 try { 
				 System.out.println("CHROME BROWSER");
		    	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "com.Dsci.insurancedomain/TestBrowsers/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches","--disable-extensions");
					new DesiredCapabilities();
					DesiredCapabilities caps = DesiredCapabilities.chrome();
					caps.setCapability(ChromeOptions.CAPABILITY, options);
					
					Map<String, Object> prefs = new HashMap<String, Object>();
				
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put("download.prompt_for_download", "false");
					
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
			
					driver = new ChromeDriver(caps);
					driver.manage().window().maximize();
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
					return driver;	
		      } 

		      catch (Exception ex) { 
		        ex.printStackTrace();
		    	  throw new RuntimeException
		              ("couldnt create chrome driver"); 
		      } 
		}else if(browsername=="FF"){
			System.setProperty("webdriver.Firefox.driver", "TestBrowsers\\geckodriver.exe");

		driver= new FirefoxDriver();
		}else if(browsername=="IE"){
		System.setProperty("webdriver.ie.driver", "TestBrowsers\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		return driver;
		}
	
	

	private Logger log = LoggerHelper.getLogger(GenericLib.class);

	
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
