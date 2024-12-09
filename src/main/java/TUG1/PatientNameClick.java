package TUG1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class PatientNameClick {
	  WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath="//input[@id='txtUserName']") private WebElement username;

	    @FindBy(xpath="//input[@id='txtPassword']") private WebElement pass;

	    @FindBy(xpath="//button[@class='btn-block LoginBtn']")private WebElement logedIn;

	    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]") private WebElement ClickClinic_I;

	    public PatientNameClick(WebDriver driver) {
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
	             }}
 
	      }
//	    public void ClickOnSelecttName() throws InterruptedException {
//	    	WebElement CheckBoxSelect=   driver.findElement(By.xpath("//*[@id='PCATable']/div/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/input"));
//	    	JavascriptExecutor jss = (JavascriptExecutor) driver;
//	    	jss.executeScript("arguments[0].click();", CheckBoxSelect);
//	    	WebElement SelectFunction=   driver.findElement(By.xpath("//*[@id=\"PCATable\"]/div/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/i"));
//	    	JavascriptExecutor js = (JavascriptExecutor) driver;
//	    	js.executeScript("arguments[0].click();", SelectFunction);
//	    	
//	    	WebElement dropdown1=driver.findElement(By.xpath("//p-dialog[@id='clinical-I']/div/div/div[2]/form/div/div/div/div[3]/div/select"));
//	    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	    	jss.executeScript("arguments[0].click();", dropdown1);
//	    	Thread.sleep(1000);
//	    	Select s = new Select(dropdown1);
//	    	s.selectByIndex(2);
//	    	driver.findElement(By.xpath("//textarea[@id='txtMsgNote']")).sendKeys("+++Message for the+++");
//	    	System.out.println("Patient sent Text message"); 
//	    	driver.findElement(By.xpath("//textarea[@id='txtNMessageRqtNote']")).sendKeys("+++Nurse+++");
//	    	System.out.println("Nurse sent Text message");
//	    	Thread.sleep(1000);
//	    
//	    }
//	    public void ReminderMessage() throws InterruptedException {
//	    	WebElement dateselect =driver.findElement(By.xpath("//*[@id=\"clinical-I\"]/div/div/div[2]/form/div/div/div/div[6]/div[1]/p-calendar/span/input"));
//	    	JavascriptExecutor js2 = (JavascriptExecutor) driver;
//	    	js2.executeScript("arguments[0].click();", dateselect);
//	    	dateselect.sendKeys("09/09/2024");
//	    	//Click on Save function
//	      	//WebElement SaveReminder =driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[2]/form/div/div/div/input"));
//	      	//SaveReminder.click();
//	    	
//	    	WebElement WeekReminder =driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[2]/form/div/div/div/div[6]/div[2]/div/input[2]"));
//	    	JavascriptExecutor WR = (JavascriptExecutor) driver;
//	    	WR.executeScript("arguments[0].click();", WeekReminder);
//	    	Thread.sleep(4000);
//	    	//close the pop-up
//	    	WebElement CloseReminder =driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[1]/div/a"));
//	    	JavascriptExecutor PopUp= (JavascriptExecutor) driver;
//	    	PopUp.executeScript("arguments[0].click();", CloseReminder);
//	    }
	    public void patientnameclick() {
	    	WebElement patientnameclick =driver.findElement(By.xpath("//span[@title='Adkxxx, Albxxx']"));
	    	JavascriptExecutor Ptname= (JavascriptExecutor) driver;
	    	Ptname.executeScript("arguments[0].click();", patientnameclick);
	    	System.out.println("patient name is clicked");
	    	
	    	List<WebElement> BasicInfo = driver.findElements(By.xpath("//div[@id='div_navigationtab']/ul[1]/li"));
	    	int totalElements = BasicInfo.size();
	    	System.out.println("Total number of elements in the list: " + totalElements);
	    	System.out.println("Text of the first 6 elements:");
	    	for (int i = 0; i < 6 && i < totalElements; i++) {  
	    	    String elementText = BasicInfo.get(i).getText();
	    	    System.out.println("Element " + (i + 1) + ": " + elementText);
	    	}
         
	    	}
	    //HeaderElements
	 public void HeaderListOfElemeents() {  
		 List<WebElement> listElements = driver.findElements(By.xpath("//div[@id='div_navigationtab']/ul[2]/li"));

		   int ListElements=listElements.size();
		   for (WebElement element : listElements) {
			    String elementText = element.getText();
			    System.out.println("Element text: " + elementText);
			    System.out.println("=================================================================================================================================");
			}}
	 //ReminderDate
     public void ReminderDates() throws InterruptedException {
    	 Thread.sleep(3000);
    	 WebElement RemPop_up=driver.findElement(By.xpath("//*[@id='td_0_REM Date']/span/span/i"));
    	 JavascriptExecutor Reminderdate = (JavascriptExecutor) driver;
    	 Reminderdate.executeScript("arguments[0].click();", RemPop_up);
         
//    	 WebElement Caledr=driver.findElement(By.xpath("//*[@id='dt_PCA_ReminderDate0']"));
//    	 Caledr.sendKeys("01/08/2024");  ELEMENT IS NOT CLICKBLE     
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	 WebElement RemWrite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tr_Document_row0']/td[3]/span/img[1]")));
         Thread.sleep(2000);
    	 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    	 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", RemWrite);
    	 jsExecutor.executeScript("arguments[0].click();", RemWrite);

    	 WebElement RemText = driver.findElement(By.xpath("//*[@id='tr_Document_row0']/td[2]/span/textarea"));
    	 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", RemText);
    	 jsExecutor.executeScript("arguments[0].click();", RemText);

    	 RemText.sendKeys(":- The patient is ...... appointments");
    	 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
    	 WebElement ClickSave = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tr_Document_row0']/td[3]/span/i[2]")));
//         Thread.sleep(2000);
//    	 JavascriptExecutor jsSave = (JavascriptExecutor) driver;
//    	 jsSave.executeScript("arguments[0].scrollIntoView(true);", ClickSave);
//    	 jsSave.executeScript("arguments[0].click();", ClickSave);  
     }

//		   //pca
//		   WebElement element = driver.findElement(By.xpath("//div[@id='div_navigationtab']/ul[2]/li[3]"));
//		   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		   jsExecutor.executeScript("arguments[0].click();", element);
          
//		   //ChartRevie
//		   WebElement elementchart = driver.findElement(By.xpath("//div[@id='div_navigationtab']/ul[2]/li[4]"));
//		   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		   jsExecutor.executeScript("arguments[0].click();", elementchart);
//		   int Rowss = driver.findElements(By.xpath("//*[@id='TblPCAFlowSheet']/div/div/div/div[2]/table/tbody/tr")).size();
//		   int COLms = driver.findElements(By.xpath("//*[@id='TblPCAFlowSheet']/div/div/div/div[2]/table/tbody/tr[1]/td")).size();
//			
//			for (int r=1; r<=Rowss;r++) {
//				for (int c=1;c<=COLms;c++) {
//		
//				String value = driver.findElement(By.xpath("//*[@id='TblPCAFlowSheet']/div/div/div/div[2]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
//				System.out.print("==>"  + value);
//				}
//				System.out.println( );
//				}
//				System.out.println("==================================\\\\\\\\\\======================================================================");
				
//			//SnapShot
//		   WebElement SnapShot = driver.findElement(By.xpath("//div[@id='div_navigationtab']/ul[2]/li[5]"));
//		   JavascriptExecutor jsSnap = (JavascriptExecutor) driver;
//		   jsSnap.executeScript("arguments[0].click();", SnapShot);
//		   
//		   //Treatments
//		   WebElement TreatMents = driver.findElement(By.xpath("//div[@id='div_navigationtab']/ul[2]/li[6]"));
//		   JavascriptExecutor treatment = (JavascriptExecutor) driver;
//		   treatment.executeScript("arguments[0].click();", TreatMents);
//		   int Rows1 = driver.findElements(By.xpath("//*[@id='clinical_I_PCA_Tx']/div/div/div/div[2]/table/tbody/tr")).size();
//		   int COLm1 = driver.findElements(By.xpath("//*[@id='clinical_I_PCA_Tx']/div/div/div/div[2]/table/tbody/tr[1]/td")).size();
//			
//			for (int r=1; r<=Rows1;r++) {
//				for (int c=1;c<=COLm1;c++) {
//		
//				String value = driver.findElement(By.xpath("//*[@id='clinical_I_PCA_Tx']/div/div/div/div[2]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
//				System.out.print("==>"  + value);
//				}
//				System.out.println( );
//				}
//				System.out.println("==================================\\\\\\\\\\======================================================================");
//				
//		   //TimeLine
//		   driver.findElement(By.xpath("//div[@id='div_navigationtab']/ul[2]/li[3]")).click();
//	    	int rows=driver.findElements(By.xpath("//*[@id='div_Engagement']/div[1]/div/table/tbody/tr")).size();
//			System.out.println(rows);
//			
//			int cols=driver.findElements(By.xpath("//*[@id='div_Engagement']/div[1]/div/table/tbody/tr[1]/td")).size();
//			System.out.println(cols);
//			
//			for (int r=1; r<=rows;r++) {
//				for (int c=1;c<=cols;c++) {
//		
//				String value = driver.findElement(By.xpath("//*[@id='div_Engagement']/div[1]/div/table/tbody/tr["+r+"]/td["+c+"]")).getText();
//				System.out.println("==>"+ value);
//				
//				}
//				System.out.println("====================================================================================================================================");
//			}
	    } 
//	 public void ConsentFunctions() throws InterruptedException {
//		 WebElement consent = driver.findElement(By.xpath("//*[@id='div_navigationtab']/ul[1]/li[8]/span/span[1]"));
//		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		 jsExecutor.executeScript("arguments[0].click();", consent);
//		 //sent sms to get consent
//		 Thread.sleep(1000);
//		 WebElement CheckBox1= driver.findElement(By.xpath("//div[@class='consent-actions']/div[1]/label/input"));
//		 JavascriptExecutor CheckBx = (JavascriptExecutor) driver;
//		 jsExecutor.executeScript("arguments[0].click();", CheckBox1);
//		 WebElement CheckBox2= driver.findElement(By.xpath("//div[@class='consent-actions']/div[1]/button"));
//		 JavascriptExecutor CheckBx1 = (JavascriptExecutor) driver;
//		 jsExecutor.executeScript("arguments[0].click();", CheckBox2);
//			WebElement patientnameclick =driver.findElement(By.xpath("//span[@title='Adkxxx, Albxxx']"));
//	    	JavascriptExecutor Ptname= (JavascriptExecutor) driver;
//	    	Ptname.executeScript("arguments[0].click();", patientnameclick);
//	    	System.out.println("patient name is clicked");
//	    	
//	    	 WebElement consent2 = driver.findElement(By.xpath("//*[@id='div_navigationtab']/ul[1]/li[8]/span/span[1]"));
//			 JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
//			 jsExecutor.executeScript("arguments[0].click();", consent2);
//		//Verble consent obtained function
//			 WebElement Vconsent = driver.findElement(By.xpath("//*[@id='div_navigationtab']/ul[1]/li[8]/span/span[1]"));
//			 JavascriptExecutor VjsExecutor = (JavascriptExecutor) driver;
//			 jsExecutor.executeScript("arguments[0].click();", Vconsent);
//		
//			 Thread.sleep(1000);
//			 WebElement VerCheckBox1= driver.findElement(By.xpath("//div[@class='consent-actions']/div[2]/label/input"));
//			 JavascriptExecutor VCheckBx = (JavascriptExecutor) driver;
//			 jsExecutor.executeScript("arguments[0].click();", VerCheckBox1);
//			 WebElement CheckBox4V= driver.findElement(By.xpath("//div[@class='consent-actions']/div[2]/button"));
//			 JavascriptExecutor CheckBx4V = (JavascriptExecutor) driver;
//			 jsExecutor.executeScript("arguments[0].click();", CheckBox4V);
//				WebElement Vpatientnameclick =driver.findElement(By.xpath("//span[@title='Adkxxx, Albxxx']"));
//		    	JavascriptExecutor VPtname= (JavascriptExecutor) driver;
//		    	Ptname.executeScript("arguments[0].click();", Vpatientnameclick);
//		    	System.out.println("patient name is clicked");
//		    	
//		    	 WebElement Vconsent2 = driver.findElement(By.xpath("//*[@id='div_navigationtab']/ul[1]/li[8]/span/span[1]"));
//				 JavascriptExecutor VjsExecutor2 = (JavascriptExecutor) driver;
//				 jsExecutor.executeScript("arguments[0].click();", Vconsent2);
//	 }
	   

