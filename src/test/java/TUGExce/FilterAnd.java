package TUGExce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TUG1.FilterCriteria;
import TUG1.Flagged;

public class FilterAnd {
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
	public void filtercriteria() throws InterruptedException {
	FilterCriteria ftr=new FilterCriteria(driver);
	ftr.enterUsername();
	ftr.enterPassword();
	ftr.logInApplication();
	ftr.clickOnClinical_I();
	ftr.clickonFitler();
//	ftr.advancefunction();
//	ftr.SavedQuerys();
//	ftr.SavedList();
	ftr.filterreport();
//	ftr.Resetbutton();
	ftr.RowAndColumn();
	
	}

}
