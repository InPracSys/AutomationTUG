package TUGExce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TUG1.DashBoard1;
import TUG1.Flagged;
import TUG1.New;
import TUG1.Re_entry;
import TUG1.Reminder;
import TUG1.Worked;

public class DashBoardExe {

	  WebDriver driver;
	    @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://tugtest.riskassistapp.com");
	        Flagged F=new Flagged(driver);
	    }

	    @Test
	    public void executionDashboard() throws InterruptedException {
	    	 DashBoard1 d = new DashBoard1(driver);
	    	d.enterUsername();
	    	d.enterPassword();
	    	d.logInApplication();
	        d.clickOnClinical_I();
	        Thread.sleep(3000);
	        d.headerelemets();
	      
	        Thread.sleep(3000);
	      d.clickonDashBoarda();
	    }
//	    public void flaggedfunctions() throws InterruptedException {
//	    	Flagged F=new Flagged(driver);
//	    	F.enterUsername();
//	    	F.enterPassword();
//	    	F.logInApplication();
//	    	F.clickOnClinical_I();
//	    	F.clickonflagBoarda();
//	    }
//	    public void NEWFunction() throws InterruptedException {
//	    	New n=new New(driver);
//	    	n.enterUsername();
//	    	n.enterPassword();
//	    	n.logInApplication();
//	    	n.clickOnClinical_I();
//	    	n.ClickOnNEW();
//	    }
//	    public void ReEntry() throws InterruptedException {
//	    	Re_entry RE=new Re_entry(driver);
//	    	RE.enterUsername();
//	    	RE.enterPassword();
//	    	RE.logInApplication();
//	    	RE.clickOnClinical_I();
//	    	RE.Rentryclick();
//	    }
//	    public void Reminderclickfunction() throws InterruptedException {
//	    	Reminder Rm=new Reminder (driver);
//	    	Rm.enterUsername();
//	    	Rm.enterPassword();
//	    	Rm.logInApplication();
//	    	Rm.clickOnClinical_I();
//	    	Rm.Reminderclick();
//	    	
//	    }
//	    public void WorkedFunction() throws InterruptedException {
//	    	Worked wk=new Worked(driver);
//	    	wk.enterUsername();
//	    	wk.enterPassword();
//	    	wk.logInApplication();
//	    	wk.clickOnClinical_I();
//	    	Thread.sleep(5000);
//	    	wk.clickonWorked();
//	    }

//	    @AfterClass
//	    public void teardown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
	}

