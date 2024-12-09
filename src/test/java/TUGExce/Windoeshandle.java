package TUGExce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windoeshandle {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();  
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\Driver_98\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();   
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
		System.out.println("parent windows  ->"  +parent);
		
        driver.findElement(By.id("newWindowBtn")).click();
         Set<String> Fisrt=  driver.getWindowHandles();
        for (String Fisrt1 : Fisrt) {
        	System.out.println(Fisrt1);
        if (!Fisrt1.equals(parent)) {
        	driver.switchTo().window(Fisrt1);
        	driver.findElement(By.id(""));
			
		}	
			
		}
        Thread.sleep(1000);
        
        driver.quit();
        
	}


}
