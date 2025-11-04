package testPractie;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopertieDdt {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\User\\Documents\\commandata.properties");
         Properties pobj = new Properties();
         pobj.load(fis);
         String BROWSER = pobj.getProperty("Browser");
         String URL = pobj.getProperty("url");
         String UN=pobj.getProperty("username");
         String PW=pobj.getProperty("password");
         System.setProperty("webdriver.edge.driver","./src/test/resources/msedgedriver.exe");
//        
			System.out.println(BROWSER);
         WebDriver driver=null;
         
         if (BROWSER.equals("chrome")) {
        	 driver = new ChromeDriver();
			
		} else if (BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
			
		}else if (BROWSER.equals("edge")){

			driver = new EdgeDriver();}
         
         else { driver = new ChromeDriver();

		}
         driver.get(URL);
         driver.findElement(By.id("email")).sendKeys(UN);
         driver.findElement(By.id("pass")).sendKeys(PW);
         driver.findElement(By.name("login")).click();
         driver.quit();
        
         
	}

}
