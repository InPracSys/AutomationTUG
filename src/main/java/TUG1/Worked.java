package TUG1;

import java.time.Duration;
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

public class Worked {
	  WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath="//input[@id='txtUserName']") private WebElement username;

	    @FindBy(xpath="//input[@id='txtPassword']") private WebElement pass;

	    @FindBy(xpath="//button[@class='btn-block LoginBtn']")private WebElement logedIn;

	    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]") private WebElement ClickClinic_I;

	    public Worked(WebDriver driver) {
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
	  public void clickonWorked() throws InterruptedException {
	        WebElement Worked = driver.findElement(By.xpath("//span[normalize-space()='WORKED']"));
	        Thread.sleep(3000);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(Worked).click().perform();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", Worked);
	       
	        Thread.sleep(3000);
	    }

}
