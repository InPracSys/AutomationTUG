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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterCriteria {

	  WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath="//input[@id='txtUserName']") private WebElement username;

	    @FindBy(xpath="//input[@id='txtPassword']") private WebElement pass;

	    @FindBy(xpath="//button[@class='btn-block LoginBtn']")private WebElement logedIn;

	    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]") private WebElement ClickClinic_I;

	    public FilterCriteria(WebDriver driver) {
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
	    public void clickonFitler() throws InterruptedException {
	        WebElement filterC = driver.findElement(By.xpath("//span[normalize-space(text())='FILTER CRITERIA']"));

   	        JavascriptExecutor js = (JavascriptExecutor) driver;
   	        js.executeScript("arguments[0].click();", filterC);
   	        List<WebElement> ListElemenets=driver.findElements(By.xpath("//div[@class='TopInnerRow']/div[2]/input"));
   	     int size = ListElemenets.size();
   	     Thread.sleep(3000);
   	     System.out.println("Size of filter elemenets  "   +size);
   	     for (WebElement element : ListElemenets) {
             System.out.println("Element Value: " + element.getAttribute("value"));
             
   	    }  
//   	     driver.findElement(By.xpath("//input[@name='FIRST_NAME']")).sendKeys("Viiiii");          
//   	     driver.findElement(By.xpath("//input[@name='PT_LastName']")).sendKeys("MMw");
//   	     driver.findElement(By.xpath("//input[@name='PT_MRN']")).sendKeys("123000");
//   	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//         WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Search row ng-star-inserted']/div/div[2]/div/div/div[1]/select"))); 
//   	    
//   	      JavascriptExecutor js3 = (JavascriptExecutor) driver;
//          js3.executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
//          Thread.sleep(2000);
//          js3.executeScript("arguments[0].click();", dropdownElement); 
//        
//          Select s =new Select(dropdownElement);
//          s.selectByIndex(3);
//          driver.findElement(By.xpath("//div[@class='Search row ng-star-inserted']/div/div[2]/div/div/div[1]/input")).sendKeys("025");
//          
//          JavascriptExecutor jg = (JavascriptExecutor) driver;
//          WebElement checkbox = driver.findElement(By.xpath("//input[@id='Male_Chk']"));
//          
//          js.executeScript("arguments[0].click();", checkbox);
//          if (checkbox.isSelected()) {
//              System.out.println("Checkbox is selected");
//          } else {
//              System.out.println("Checkbox is not selected");
//          }          
//   	      JavascriptExecutor js4 = (JavascriptExecutor) driver;
//   	      WebElement dropdownRace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Search row ng-star-inserted']/div/div[2]/div/div[3]/div/div/div/select"))); 
//          Select s1 =new Select(dropdownRace);
//          List<WebElement> options = s1.getOptions(); 
//
//          System.out.println("Options in the dropdown:");
//          for (WebElement option : options) {
//              System.out.println("List of elements        =====>" + option.getText());
//          }
//          int size2 = options.size();
//          System.out.println("Number of options in the dropdown: " + size2);
//
//          s1.selectByIndex(3);
//          JavascriptExecutor js5 = (JavascriptExecutor) driver;
//   	      WebElement FilterBy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Search row ng-star-inserted']/div/div[3]/div/div/div[1]/div/select"))); 
//          Select s2 =new Select(FilterBy);
//          List<WebElement> Filter = s2.getOptions(); 
//
//          System.out.println("Options in the dropdown:");
//          for (WebElement FilterByC : Filter) {
//              System.out.println("List of elements        =====>" + FilterByC.getText());
//          }p\
//          int size3 = Filter.size();
//          System.out.println("Number of options in the dropdown: " + size3);
//          if (size3==35) {
//        	  System.out.println("Test case is passed");
//          } else {
//        		  System.out.println("Test cases is faiiled");
//        	  
//        	  }
//          s2.selectByIndex(3);
   	     
	    }
	 public void filterreport() throws InterruptedException {
		   WebElement FTLReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container-fluid ResultDiv']/div[1]/div/div/div[2]/input[2]"))); 
	   	    
	   	      JavascriptExecutor adv = (JavascriptExecutor) driver;
	   	      adv.executeScript("arguments[0].scrollIntoView(true);", FTLReport);
	          Thread.sleep(2000);
	          adv.executeScript("arguments[0].click();", FTLReport); 
	 }
	 public void Resetbutton() throws InterruptedException {
		 WebElement Resetclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container-fluid ResultDiv']/div[1]/div/div/div[2]/input[1]"))); 
	   	  JavascriptExecutor adv = (JavascriptExecutor) driver;
  	      adv.executeScript("arguments[0].scrollIntoView(true);", Resetclick);
          Thread.sleep(2000);
          adv.executeScript("arguments[0].click();", Resetclick); 
          System.out.println("Reset the page");
	 }
	 public void clickonSave() throws InterruptedException {
		 WebElement ClickOnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container-fluid ResultDiv']/div[1]/div/div/div[2]/p-splitbutton/div"))); 
	   	  JavascriptExecutor adv = (JavascriptExecutor) driver;
 	      adv.executeScript("arguments[0].scrollIntoView(true);", ClickOnSave);
         Thread.sleep(2000);
         adv.executeScript("arguments[0].click();", ClickOnSave); //textarea[@id='txtPCAFilterName']
         driver.findElement(By.xpath("//textarea[@id='txtPCAFilterName']")).sendKeys("This is text message for the testing purpose");  
         System.out.println("Save the page");
	 }
//	 public void advancefunction() throws InterruptedException {
//		
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	         WebElement Advance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TopInnerRow']/div[2]/input[2]"))); 
//	   	    
//	   	      JavascriptExecutor adv = (JavascriptExecutor) driver;
//	   	      adv.executeScript("arguments[0].scrollIntoView(true);", Advance);
//	          Thread.sleep(2000);
//	          adv.executeScript("arguments[0].click();", Advance); 
//	          List<WebElement> advlist = driver.findElements(By.xpath("//div[@class='Search row ng-star-inserted']/div/div/div/ul/li")); 
//
//	          for (WebElement AdvaceRun : advlist) {
//	              System.out.println("==>" + AdvaceRun.getText());
//	          }
//	          int size3 = advlist.size();
//	          System.out.println("Number of options in the dropdown: " + size3);
//	          if (size3==23) {
//	        	  System.out.println("Test case is passed");
//	          } else {
//	        		  System.out.println("Test cases is faiiled");
//	        	      System.out.println("                                                                                                                       ");
//	        	  }
//	        
//		 
//	 }
//	 public void SavedQuerys() throws InterruptedException {
//			
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	         WebElement Save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TopInnerRow']/div[2]/input[3]"))); 
//	   	    
//	   	      JavascriptExecutor adv = (JavascriptExecutor) driver;
//	   	      adv.executeScript("arguments[0].scrollIntoView(true);", Save);
//	          Thread.sleep(2000);
//	          adv.executeScript("arguments[0].click();", Save); 
//	          List<WebElement> Savelist = driver.findElements(By.xpath("//div[@class='Search row ng-star-inserted']/div/div/div/ul/li")); 
//
//	          for (WebElement SaveQuery : Savelist) {
//	              System.out.println("==>" + SaveQuery.getText());
//	          }
//	          int size3 = Savelist.size();
//	          System.out.println("Number of options in the dropdown: " + size3);
//	          if (size3==5) {
//	        	  System.out.println("Test case is passed");
//	          } else {
//	        		  System.out.println("Test cases is faiiled");
//	        	  
//	        	  }
//	 }
//	 public void SavedList() throws InterruptedException {
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	         WebElement Saved = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TopInnerRow']/div[2]/input[4]"))); 
//	   	    
//	   	      JavascriptExecutor adv = (JavascriptExecutor) driver;
//	   	      adv.executeScript("arguments[0].scrollIntoView(true);", Saved);
//	          Thread.sleep(2000);
//	          adv.executeScript("arguments[0].click();", Saved); 
//	          List<WebElement> Savedslist = driver.findElements(By.xpath("//label[@class='control-label ng-star-inserted']")); 
//	           
//	          	          for (WebElement SavedListElemt : Savedslist) {
//	          	              System.out.println("==>" + SavedListElemt.getText());
//	          	          }
//	          	          int size3 = Savedslist.size();
//	          	          System.out.println("Number of options in the dropdown: " + size3);
//	          	          if (size3==1) {
//	          	        	  System.out.println("Test case is passed");
//	          	          } else { 
//	          	        		  System.out.println("Test cases is faiiled");
//	          	          } 
//	          	        	
//	          	          }
	        public void RowAndColumn() throws InterruptedException {
	        	 List<WebElement> column = driver.findElements(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[1]/div/table/colgroup/col"));

	          	   int columnCount = column.size();
	          	   System.out.println("Number of rows in the table: " + columnCount);
	          	 System.out.println("Table column:");
	          	 Thread.sleep(1000);
	         
	          	 int expectedColmCount = 30; 
	          	   if (columnCount == expectedColmCount) {  // Replace expectedRowCount with the actual expected count
	          	       System.out.println("Test case passed: The table contains the expected number of column.");
	          	   } else {
	          	       System.out.println("Test case failed: The table contains " + columnCount + " columns, expected " + expectedColmCount + ".");
	          	   }
	          	 List<WebElement> Rows = driver.findElements(By.xpath("//*[@id='PCATable']/div/div[1]/div[1]/div[2]/table/tbody/tr"));

	          	   int RowCount = Rows.size();
	          	   System.out.println("Number of rows is "   + RowCount);
	 }

	  
}
