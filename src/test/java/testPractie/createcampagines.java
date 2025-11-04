package testPractie;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class createcampagines {

	@Test
	public void createCampaignsWithMandatoryFields() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties po=new Properties();
		po.load(fis);
	    String url = po.getProperty("Url");
	    String un = po.getProperty("Username");
	    String pw = po.getProperty("password");
	    ChromeOptions set=new ChromeOptions();
	    Map<String,Object> prefs=new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        set.setExperimentalOption("prefs", prefs);
	    
	    WebDriver driver = new ChromeDriver(set);
	   driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(url);
	    driver.findElement(By.id("username")).sendKeys(un);
	    driver.findElement(By.id("inputPassword")).sendKeys(pw);
	    driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
	    driver.findElement(By.linkText("Campaigns")).click();
	    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	    
	    
		  FileInputStream fis2= new FileInputStream("./src/test/resources/testdata.xlsx");
		   Workbook wo = WorkbookFactory.create(fis2);
		   String campname = wo.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		 System.out.println(campname);
		   String size = wo.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		    System.out.println(size);    
	     driver.findElement(By.name("campaignName")).sendKeys(campname);
	    driver.findElement(By.name("targetSize")).sendKeys(size);
	    driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	    
	    
	    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='alert']"))));
		   WebElement text = driver.findElement(By.xpath("//div[@role='alert']"));
			String notif = text.getText();
			if(text.isDisplayed()) {
				System.out.println(notif);
			}
			else {
				System.out.println("sorry not working");
			}
			driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--success']")).click();
			
			 Actions a = new Actions(driver);
			 a.moveToElement(driver.findElement(By.xpath("(//div[@class='user-icon-container'])[2]"))).perform();
			 driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
	}

}
