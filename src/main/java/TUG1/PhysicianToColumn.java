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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhysicianToColumn {
	  WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath="//input[@id='txtUserName']") private WebElement username;

	    @FindBy(xpath="//input[@id='txtPassword']") private WebElement pass;

	    @FindBy(xpath="//button[@class='btn-block LoginBtn']")private WebElement logedIn;

	    @FindBy(xpath="//div[@class='MainContainer']/div[2]/div/div[6]") private WebElement ClickClinic_I;

	    public PhysicianToColumn(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
	    public void FilterReportclick() throws InterruptedException {
	    	   WebElement FTLReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container-fluid ResultDiv']/div[1]/div/div/div[2]/input[2]"))); 
		   	      JavascriptExecutor adv = (JavascriptExecutor) driver;
		   	      adv.executeScript("arguments[0].scrollIntoView(true);", FTLReport);
		   	      Thread.sleep(2000);
		          adv.executeScript("arguments[0].click();", FTLReport); 
		          Thread.sleep(2000);
		          System.out.println("Click on Filter");
	    }
	    public void physician() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement phys = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[3]")));
	    	  JavascriptExecutor adv = (JavascriptExecutor) driver;
	   	      adv.executeScript("arguments[0].scrollIntoView(true);", phys);
	          adv.executeScript("arguments[0].click();", phys); 
	          Thread.sleep(4000);
	    
	          List<WebElement> PhyList = driver.findElements(By.xpath("//*[@id='td_0_Physician']/div/select/option"));
	          int listSize = PhyList.size();
	          System.out.println("Number of options: " + listSize);

	          for (WebElement option : PhyList) {
	              System.out.println(option.getText());
	          }
	          WebElement selectElement = driver.findElement(By.xpath("//*[@id='td_0_Physician']/div/select"));
	          Select s = new Select(selectElement);
	          s.selectByIndex(36); 
	          WebElement cancel= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]"));
	          cancel.click();
	    }

	    public void DIDSelect() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Dids = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[5]")));
	    	  JavascriptExecutor adv = (JavascriptExecutor) driver;
	   	      adv.executeScript("arguments[0].scrollIntoView(true);", Dids);
	          adv.executeScript("arguments[0].click();", Dids); 
	          Thread.sleep(2000);
	          Dids.click();
	          WebElement dateInput = driver.findElement(By.xpath("//*[@id='td_0_DID']/div/input")); // Adjust XPath as necessary
	          JavascriptExecutor js = (JavascriptExecutor) driver;
	          js.executeScript("arguments[0].value='02-12-2025';", dateInput);
	    }
	    public void GleasonFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Gleson = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[6]")));
	    	  JavascriptExecutor Gles = (JavascriptExecutor) driver;
	    	  Gles.executeScript("arguments[0].scrollIntoView(true);", Gleson);
	    	  Gles.executeScript("arguments[0].click();", Gleson); 
	          Thread.sleep(4000);
	    
	          List<WebElement> GlesList = driver.findElements(By.xpath("//*[@id='td_0_Gleason']/div/select/option"));
	          int listSize = GlesList.size();
	          System.out.println("Number of options: " + listSize);

	          for (WebElement options : GlesList) {
	              System.out.println(options.getText());
	          }
	          WebElement GlesonElement = driver.findElement(By.xpath("//*[@id='td_0_Physician']/div/select"));
	          Select s1 = new Select(GlesonElement);
	          s1.selectByIndex(16); 
	          Thread.sleep(2000);
	          WebElement cancelS= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelS.click();
	    }
	    public void RiskFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Risk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[7]")));
	    	  JavascriptExecutor ris = (JavascriptExecutor) driver;
	    	  ris.executeScript("arguments[0].scrollIntoView(true);", Risk);
	    	  ris.executeScript("arguments[0].click();", Risk); 
	          Thread.sleep(4000);
	    
	          List<WebElement> RiskList = driver.findElements(By.xpath("//td[@id='td_0_Risk']/div/select/option"));
	          int listSize = RiskList.size();
	          System.out.println("Number of options: " + listSize);

	          for (WebElement Riskoptions : RiskList) {
	              System.out.println(Riskoptions.getText());
	          }
	          WebElement GlesonElement = driver.findElement(By.xpath("//td[@id='td_0_Risk']/div/select"));
	          Select ss = new Select(GlesonElement);
	          ss.selectByIndex(3); 
	          Thread.sleep(2000);
	          WebElement cancel2= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancel2.click();
	    }
	    public void GermLineFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  	    	WebElement GermLine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[8]")));
	    	  JavascriptExecutor Germ = (JavascriptExecutor) driver;
	    	  Germ.executeScript("arguments[0].scrollIntoView(true);", GermLine);
	    	  Germ.executeScript("arguments[0].click();", GermLine); 
	          Thread.sleep(4000);
	    
	          List<WebElement> GermList = driver.findElements(By.xpath("//*[@id='td_0_Germline']/div/select/option"));
	          int listSize2 = GermList.size();
	          System.out.println("Number of options: " + listSize2);

	          for (WebElement Riskoptions : GermList) {
	              System.out.println(Riskoptions.getText());
	          }
	          WebElement GlesonElement = driver.findElement(By.xpath("//*[@id='td_0_Germline']/div/select"));
	          Select s2 = new Select(GlesonElement);
	          s2.selectByIndex(7); 
	          Thread.sleep(3000);
	          WebElement cancel3= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancel3.click();
	    }
	    public void ScrollHorizontal() throws InterruptedException {
	    	WebElement elementToScroll = driver.findElement(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	        Thread.sleep(3000);
	        js.executeScript("arguments[0].scrollLeft += 3250;", elementToScroll); 

	    }
	    public void SomaticFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Somatic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[9]")));
	    	  JavascriptExecutor Som = (JavascriptExecutor) driver;
	    	  Som.executeScript("arguments[0].scrollIntoView(true);", Somatic);
	    	  Som.executeScript("arguments[0].click();", Somatic); 
	          Thread.sleep(4000);
	    
	          List<WebElement> Somlist = driver.findElements(By.xpath("//td[@id='td_0_Somatic']/div/select/option"));
	          int listSize21 = Somlist.size();
	          System.out.println("Number of options: " + listSize21);

	          for (WebElement Somoptions : Somlist) {
	              System.out.println(Somoptions.getText());
	          }
	          WebElement SomaticElement = driver.findElement(By.xpath("//td[@id='td_0_Somatic']/div/select"));
	          Select som = new Select(SomaticElement);
	          som.selectByIndex(5); 
	          Thread.sleep(3000);
	          WebElement cancelSOm= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelSOm.click();
	    }
	    public void MetsFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Mets = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[12]")));
	    	  JavascriptExecutor Jmet = (JavascriptExecutor) driver;
	    	  Jmet.executeScript("arguments[0].scrollIntoView(true);", Mets);
	    	  Jmet.executeScript("arguments[0].click();", Mets); 
	          Thread.sleep(4000);
	    
	          List<WebElement> Metlist = driver.findElements(By.xpath("//td[@id='td_0_Mets']/div/select/option"));
	          int listSize3 = Metlist.size();
	          System.out.println("Number of options Met: " + listSize3);

	          for (WebElement Somoptions : Metlist) {
	              System.out.println(Somoptions.getText());
	          }
	          WebElement MetsElement = driver.findElement(By.xpath("//td[@id='td_0_Mets']/div/select"));
	          Select MEAT = new Select(MetsElement);
	          MEAT.selectByIndex(5); 
	          Thread.sleep(3000);
	          WebElement cancelMet= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelMet.click();
	    } 
	    public void TNMFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement TNMStage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[14]")));
	    	  JavascriptExecutor tnm = (JavascriptExecutor) driver;
	    	  tnm.executeScript("arguments[0].scrollIntoView(true);", TNMStage);
	    	  tnm.executeScript("arguments[0].click();", TNMStage); 
	          Thread.sleep(4000);
	    
	          List<WebElement> TNMlist1 = driver.findElements(By.xpath("//*[@id='td_0_TNM']/div/select[1]/option"));
	          int listSize3 = TNMlist1.size();
	          System.out.println("Number of options TNMStage: " + listSize3);

	          for (WebElement TNMptions : TNMlist1) {
	              System.out.println(TNMptions.getText());
	          }
	          WebElement TNMElement1 = driver.findElement(By.xpath("//*[@id='td_0_TNM']/div/select[1]"));
	          Select TnM = new Select(TNMElement1);
	          TnM.selectByIndex(5); 
	          Thread.sleep(2000);
	          
	          List<WebElement> TNMlist2 = driver.findElements(By.xpath("//*[@id='td_0_TNM']/div/select[2]/option"));
	          int listSize22 = TNMlist2.size();
	          System.out.println("Number of options TNMStage2: " + listSize22);

	          for (WebElement TNMptions2 : TNMlist2) {
	              System.out.println(TNMptions2.getText());
	          }
	          WebElement TNMElement2 = driver.findElement(By.xpath("//*[@id='td_0_TNM']/div/select[2]"));
	          Select TnM2 = new Select(TNMElement2);
	          TnM2.selectByIndex(2); 
	          Thread.sleep(2000);
	          List<WebElement> TNMlist3 = driver.findElements(By.xpath("//*[@id='td_0_TNM']/div/select[3]/option"));
	          int listSize33 = TNMlist1.size();
	          System.out.println("Number of options TNMStage3: " + listSize33);

	          for (WebElement TNMptions3 : TNMlist3) {
	              System.out.println(TNMptions3.getText());
	          }
	          WebElement TNMElement3 = driver.findElement(By.xpath("//*[@id='td_0_TNM']/div/select[3]"));
	          Select TnM3 = new Select(TNMElement3);
	          TnM3.selectByIndex(5); 
	          Thread.sleep(3000); 
	          WebElement TNMClick = driver.findElement(By.xpath("//*[@id='td_0_TNM']/div/i"));
	          TNMClick.click();
	          WebElement cancelTNM= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelTNM.click();
	    }
	    public void PrimarTXFunctions() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Primary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[15]")));
	    	  JavascriptExecutor TX = (JavascriptExecutor) driver;
	    	  TX.executeScript("arguments[0].scrollIntoView(true);", Primary);
	    	  TX.executeScript("arguments[0].click();", Primary); 
	          Thread.sleep(2000);
	    
	          List<WebElement> TXlist = driver.findElements(By.xpath("//*[@id='td_0_Primary Tx']/div/select/option"));
	          int listSize3 = TXlist.size();
	          System.out.println("Number of options Met: " + listSize3);

	          for (WebElement TXptions : TXlist) {
	              System.out.println(TXptions.getText());
	          }
	          WebElement TXElement = driver.findElement(By.xpath("//*[@id='td_0_Primary Tx']/div/select"));
	          Select PTX = new Select(TXElement);
	          PTX.selectByIndex(15); 
	          Thread.sleep(3000);
	          WebElement cancelMet= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelMet.click();
	    }
	    public void CurrentMedFun() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement Current = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[17]")));
	    	  JavascriptExecutor CU = (JavascriptExecutor) driver;
	    	  CU.executeScript("arguments[0].scrollIntoView(true);", Current);
	    	  CU.executeScript("arguments[0].click();", Current); 
	          Thread.sleep(2000); 
	          String elementText = Current.getText();
	          System.out.println("Text of the element: " + elementText);
	          }
	    public void ECOGColiumn() throws InterruptedException {
	   	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	  WebElement ECOG = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[18]")));
    	  JavascriptExecutor EcX = (JavascriptExecutor) driver;
    	  EcX.executeScript("arguments[0].scrollIntoView(true);", ECOG);
    	  EcX.executeScript("arguments[0].click();", ECOG); 
          Thread.sleep(2000);
    
          List<WebElement> ECOGlist = driver.findElements(By.xpath("//td[@id='td_0_ECOG']/div/select/option"));
          int listEcog = ECOGlist.size();
          System.out.println("Number of options Met: " + listEcog);

          for (WebElement Ecogoptions : ECOGlist) {  
              System.out.println(Ecogoptions.getText());
          }
          WebElement EcogElement = driver.findElement(By.xpath("//td[@id='td_0_ECOG']/div/select"));
          Select ECOX = new Select(EcogElement);
          ECOX.selectByIndex(4); 
          Thread.sleep(3000);
          WebElement cancelECOG= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
          cancelECOG.click();
          System.out.println("ECOG is selected");  
	    }
	  public void PSANumberGet() throws InterruptedException {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    	WebElement PSA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[19]")));
		    	  JavascriptExecutor CU = (JavascriptExecutor) driver;
		    	  CU.executeScript("arguments[0].scrollIntoView(true);", PSA);
		    	  CU.executeScript("arguments[0].click();", PSA); 
		          Thread.sleep(2000); 
		          String PSAELE = PSA.getText();
		          System.out.println("Text of the PSAnumber: " + PSAELE);
	  }
	  public void LastPSAdateGet() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement PSADate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[20]")));
	    	  JavascriptExecutor CU = (JavascriptExecutor) driver;
	    	  CU.executeScript("arguments[0].scrollIntoView(true);", PSADate);
	    	  CU.executeScript("arguments[0].click();", PSADate); 
	          Thread.sleep(2000); 
	          String PSAELE = PSADate.getText();
	          System.out.println("Text of the date: " + PSAELE);
}
	    public void StatusColumn() throws InterruptedException {
		   	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	  WebElement Status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[24]")));
	    	  JavascriptExecutor Stat = (JavascriptExecutor) driver;
	    	  Stat.executeScript("arguments[0].scrollIntoView(true);", Status);
	    	  Stat.executeScript("arguments[0].click();", Status); 
	          Thread.sleep(2000);
	    
	          List<WebElement> StatusGlist = driver.findElements(By.xpath("//td[@id='td_0_Status']/div/select/option"));
	          int listStatus = StatusGlist.size();
	          System.out.println("Number of options Met: " + listStatus);

	          for (WebElement Statusoptions : StatusGlist) {  
	              System.out.println(Statusoptions.getText());
	          }
	          WebElement StatusElement = driver.findElement(By.xpath("//td[@id='td_0_Status']/div/select"));
	          Select Stauss = new Select(StatusElement);
	          Stauss.selectByIndex(4); 
	          Thread.sleep(3000);
	          WebElement cancelStaus= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelStaus.click();
	          System.out.println("Staus ++ is selected");  
		    }
	   public void WorketColumn() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement WorkStatus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[25]")));
		    	 JavascriptExecutor CU = (JavascriptExecutor) driver;
		    	 CU.executeScript("arguments[0].scrollIntoView(true);", WorkStatus);
		    	 CU.executeScript("arguments[0].click();", WorkStatus); 
		         Thread.sleep(2000); 
		         String WorkedStatuss = WorkStatus.getText();
		         System.out.println("Text of the WORKED  : "   + WorkedStatuss);
	}
	    public void NavColumn() throws InterruptedException {
		   	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	  WebElement Nav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[26]")));
	    	  JavascriptExecutor SNav = (JavascriptExecutor) driver;
	    	  SNav.executeScript("arguments[0].scrollIntoView(true);", Nav);
	    	  SNav.executeScript("arguments[0].click();", Nav); 
	          Thread.sleep(2000);
	    
	          List<WebElement> Navlist = driver.findElements(By.xpath("//td[@id='td_0_Nav']/div/select/option"));
	          int listNav = Navlist.size();
	          System.out.println("Number of options Met: " + listNav);

	          for (WebElement Navoptions : Navlist) {  
	              System.out.println(Navoptions.getText());
	          }
	          WebElement NavElement = driver.findElement(By.xpath("//td[@id='td_0_Nav']/div/select"));
	          Select NavSelect = new Select(NavElement);
	          NavSelect.selectByIndex(2); 
	          Thread.sleep(3000);
	          WebElement cancelNav= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelNav.click();
	          System.out.println("Nav ++ is selected");  
		    }
	    public void ClinicColumn() throws InterruptedException {
		   	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	  WebElement Clinic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[27]")));
	    	  JavascriptExecutor Clini = (JavascriptExecutor) driver;
	    	  Clini.executeScript("arguments[0].scrollIntoView(true);", Clinic);
	    	  Clini.executeScript("arguments[0].click();", Clinic); 
	          Thread.sleep(2000);
	    
	          List<WebElement> ClinicStatus = driver.findElements(By.xpath("//*[@id='td_0_Clinic']/div/select/option"));
	          int ClinicSize = ClinicStatus.size();
	          System.out.println("Number of options Met: " + ClinicSize);

	          for (WebElement Clinicoptions : ClinicStatus) {  
	              System.out.println(Clinicoptions.getText());
	          }
	          WebElement ClinicElement = driver.findElement(By.xpath("//*[@id='td_0_Clinic']/div/select"));
	          Select NavSelect = new Select(ClinicElement);
	          NavSelect.selectByIndex(3); 
	          Thread.sleep(3000);
	          WebElement cancelClinic= driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]/span"));
	          cancelClinic.click();
	          System.out.println("Clinic Status ++ is selected");  
		    }
	    public void LastDOS() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement DOS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[28]")));
		    	 JavascriptExecutor Last = (JavascriptExecutor) driver;
		    	 Last.executeScript("arguments[0].scrollIntoView(true);", DOS);
		    	 Last.executeScript("arguments[0].click();", DOS); 
		         Thread.sleep(2000); 
		         String DOSStatuss = DOS.getText();         
		         
		         System.out.println("Text of the dos date :  "+DOSStatuss);
	    }
	    public void NexttDOS() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement NextDOS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[29]")));
		    	 JavascriptExecutor Last = (JavascriptExecutor) driver;
		    	 Last.executeScript("arguments[0].scrollIntoView(true);", NextDOS);
		    	 Last.executeScript("arguments[0].click();", NextDOS); 
		         Thread.sleep(2000); 
		         String DOSNextStatus = NextDOS.getText();
		         System.out.println("Text of the nextdos  : "   + DOSNextStatus);
		         WebElement check= driver.findElement(By.xpath("//td[@id='td_0_Next DOS']/span/i"));
		         check.click();
		         int row = driver.findElements(By.xpath("//p-table[@sortmode='multiple']/div/div/table/tbody/tr")).size();
		         System.out.println("Number of rows: " + row);
		         int col = driver.findElements(By.xpath("//p-table[@sortmode='multiple']/div/div/table/tbody/tr[1]/td")).size();
		         System.out.println("Number of columns: " + col);
		         for (int r = 1; r <= row; r++) {
		             for (int c = 1; c <= col; c++) {
		                 String value = driver.findElement(By.xpath("//p-table[@sortmode='multiple']/div/div/table/tbody/tr        [" + r + "]/td[" + c + "]")).getText();
		                 System.out.print("==>" + value + " ");
		             }
		             System.out.println();
		         }
		         Thread.sleep(1000);   
		         WebElement Close= driver.findElement(By.xpath("/html/body/p-dynamicdialog/div/div/div[1]/div/a/span"));
		         Close.click();
	    }
	    
	    public void Notes() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement Note = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-table[@id='PCATable']/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[30]")));
		    	 JavascriptExecutor Nts = (JavascriptExecutor) driver;
		    	 Nts.executeScript("arguments[0].scrollIntoView(true);", Note);
		    	 Nts.executeScript("arguments[0].click();", Note); 
		         Thread.sleep(2000); 
		         String NoteStatus = Note.getText();
		         System.out.println("Text of the Notes"  + NoteStatus);
		         Thread.sleep(2000);
		         WebElement Ntes= driver.findElement(By.xpath("//td[@id='td_0_Note']/span"));
		         Ntes.click();
		         WebElement Ntext= driver.findElement(By.xpath("//p-editor[@id='txtNurseNotes']/div/div[2]/div[1]"));
		         Ntext.click();
		         Ntext.sendKeys("This is Text notes for the Nurcing ");
		         WebElement NDate= driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[2]/div[2]/div[2]/div/div/p-calendar/span/input"));
		         NDate.click();
		         NDate.sendKeys("09/10/2024");
		         WebElement NWeek= driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[2]/div[2]/div[3]/input[2]"));
		         NWeek.click();
		         Thread.sleep(2000);
		         WebElement Cancels= driver.findElement(By.xpath("//*[@id='clinical-I']/div/div/div[2]/div[2]/div[2]/input[6]")); //input[3] is saved
		         Cancels.click();
		         
		         
	    }
	    
}