package TUGExce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TUG1.PhysicianToColumn;


public class PhysicianToColumnsExecution {
	
	 WebDriver driver;
	    @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://tugtest.riskassistapp.com");
	       
	    }
	    @Test
	    public void PhysicianToOtherColumn() throws InterruptedException {
	    	PhysicianToColumn phy= new PhysicianToColumn(driver);
	    	phy.enterUsername();
	    	phy.enterPassword();
	    	phy.logInApplication();
	    	phy.clickOnClinical_I();  
	    	phy.FilterReportclick();
	      //  phy.physician();
	    	//phy.DIDSelect(); //Date is not clickable
	    	//phy.GleasonFunctions();
	    	//phy.RiskFunctions();
	    	//phy.GermLineFunctions();
	    	phy.ScrollHorizontal();
	    	//phy.SomaticFunctions();
	    	//phy.MetsFunctions();
	    	//phy.TNMFunctions();
	    	//phy.PrimarTXFunctions();
	    	//phy.CurrentMedFun();
	    	//phy.ECOGColiumn();
//	    	phy.PSANumberGet();
//	    	phy.LastPSAdateGet();
//	    	phy.StatusColumn();
//	    	phy.WorketColumn();
//	    	phy.NavColumn();
//        	phy.ClinicColumn();
	    	phy.LastDOS();
	    	//phy.NexttDOS();
	    	phy.Notes();
	    }

}
