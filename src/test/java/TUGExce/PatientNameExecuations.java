package TUGExce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TUG1.Flagged;
import TUG1.PatientNameClick;

public class PatientNameExecuations {

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
	    public void NameClick() throws InterruptedException {
	    	PatientNameClick pnc=new PatientNameClick(driver);
	    	pnc.enterUsername();
	    	pnc.enterPassword();
	    	pnc.logInApplication();
	    	pnc.clickOnClinical_I();
//	    	pnc.ClickOnSelectName();
//	    	pnc.ReminderMessage();
//	    	pnc.patientnameclick();
//	    	pnc.HeaderListOfElemeents();
//	    	pnc.ConsentFunctions();
	    	pnc.ReminderDates();
	    }
}
