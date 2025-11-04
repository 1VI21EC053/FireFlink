package testPractie;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ninja.crm.generic.fileutility.ExcelUtility;
import com.ninja.crm.generic.fileutility.PropertiesUtility;
import com.ninja.crm.generic.wedriverutility.WebdriverUtility;

public class CreateCmapagineDetails {

	public static void main(String[] args) throws IOException {
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/ninjacmlogincommondata.properties");
		Properties po=new Properties();
		po.load(fis);
	    String url = po.getProperty("Url");
	    String un = po.getProperty("Username");
	    String pw = po.getProperty("password");*/
	    ChromeOptions set=new ChromeOptions();
	    Map<String,Object> prefs=new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        set.setExperimentalOption("prefs", prefs);
	    
		
		PropertiesUtility p = new PropertiesUtility();
		String url=p.getDataFromProperties("Url");	
		String un = p.getDataFromProperties("Username");
		String pw = p.getDataFromProperties("password");
	    WebDriver driver = new ChromeDriver(set);
	    driver.manage().window().maximize();
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    WebdriverUtility w= new WebdriverUtility();
	    w.setImplicitlyWait(driver, 2);
	    driver.get(url);
	    driver.findElement(By.id("username")).sendKeys(un);
	    driver.findElement(By.id("inputPassword")).sendKeys(pw);
	    driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
	    driver.findElement(By.linkText("Campaigns")).click();
	    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	    
	/*	 FileInputStream fis2= new FileInputStream("./src/test/resources/testdata.xlsx");
		   Workbook wo = WorkbookFactory.create(fis2);
		   String campname = wo.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		 System.out.println(campname);
		   String size = wo.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		    System.out.println(size);  
		    String status = wo.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		    String targ = wo.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		    String dis = wo.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();*/
	    
	    
	    
	    ExcelUtility e = new ExcelUtility();
	    String campname = e.getDataFromexcelFile("Sheet1", 1, 0);
	    String size = e.getDataFromexcelFile("Sheet1", 1, 1);
	    String status = e.getDataFromexcelFile("Sheet1", 1, 2);
	    String targ = e.getDataFromexcelFile("Sheet1", 1, 3);
	    String dis = e.getDataFromexcelFile("Sheet1", 1, 4);
	     driver.findElement(By.name("campaignName")).sendKeys(campname);
	    driver.findElement(By.name("targetSize")).sendKeys(size);
	    driver.findElement(By.name("campaignStatus")).sendKeys(status);
	    driver.findElement(By.name("targetAudience")).sendKeys(targ);
	    driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(dis);
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
			 
			 driver.quit();

	}

}
