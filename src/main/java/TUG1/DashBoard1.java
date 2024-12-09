package TUG1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard1 {

	  WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath="//input[@id='txtUserName']") private WebElement username;

	    @FindBy(xpath="//input[@id='txtPassword']") private WebElement pass;

	    @FindBy(xpath="//button[@class='btn-block LoginBtn']")private WebElement logedIn;

	    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]") private WebElement ClickClinic_I;

	    public DashBoard1(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        PageFactory.initElements(driver, this);
	    }

	    public void enterUsername() {
	        wait.until(ExpectedConditions.visibilityOf(username));
	        username.sendKeys("kumar");
	    }

	    public void enterPassword() {
	        wait.until(ExpectedConditions.visibilityOf(pass));
	        pass.sendKeys("Guess@123");
	    }

	    public void logInApplication() {
	        wait.until(ExpectedConditions.elementToBeClickable(logedIn));
	        logedIn.click();
	    }

	    public void clickOnClinical_I() {
	    	String parent=driver.getWindowHandle();
			System.out.println("parent windows  ->"  +parent);
			
	        driver.findElement(By.xpath("//div[@class='MainContainer']/div[2]/div/div[6]")).click();
	         Set<String> Fisrt=  driver.getWindowHandles();
	         for (String windowHandle : Fisrt) {
	        	 System.out.println(windowHandle);
	             if (!windowHandle.equals(parent)) {
	                 driver.switchTo().window(windowHandle);
	                 System.out.println("Switched to window: " + windowHandle);
	             }
	    }}
	    public void switchToIframe() {
	        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='zsFeedbackUser']")));
	        driver.switchTo().frame(iframe);
	        System.out.println("Switched to iframe");
	    }

//	    public void fILTERreportclick() throws InterruptedException {
//	        WebElement filterReport = driver.findElement(By.xpath("(//input[@type='button'])[2]"));
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.elementToBeClickable(filterReport));
//
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].scrollIntoView(true);", filterReport);
//
//	        Thread.sleep(1000);
//             js.executeScript("arguments[0].click();", filterReport);
//
//	        System.out.println("Filter is opened");
//	    }
	    public void headerelemets() throws InterruptedException {
	    	List<WebElement> headerItems = driver.findElements(By.xpath("//div[@class='RightMenuOther']/app-clinical-i-prostrate-cancer/form/div[1]/div/div"));
	    	int count = headerItems.size();
	        System.out.println("Number of header elements: " + count);
	        
	    	   for (WebElement headerItem : headerItems) {
	    	        JavascriptExecutor js = (JavascriptExecutor) driver;
	    	        js.executeScript("arguments[0].scrollIntoView(true);", headerItem);
                    Thread.sleep(3000);
	    	        String headerText = headerItem.getText();
	    	        System.out.print("Header Item Text: " + headerText);
	    	        
	    	   }
	    	    System.out.println("All header elements processed.");
	    	    
	    }
	    public void clickonDashBoarda() throws InterruptedException {
	        // Locate the element using findElement
	        WebElement dashbd = driver.findElement(By.xpath("/html/body/app-root/app-home-risk-assit/div/div[2]/div/div[6]/div/a/div/span[2]"));
	        Thread.sleep(3000);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(dashbd).click().perform();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", dashbd);
	       
	        Thread.sleep(3000);
	    }
}
