package testPractie;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ninja.crm.generic.fileutility.ExcelUtility;
import com.ninja.crm.generic.fileutility.PropertiesUtility;

public class RandomNo {

	public static void main(String[] args) throws IOException {

		/*
		 * FileInputStream fis = new
		 * FileInputStream("./src/test/resources/ninjacmlogincommondata.properties");
		 * Properties po=new Properties(); po.load(fis); String url =
		 * po.getProperty("Url"); String un = po.getProperty("Username"); String pw =
		 * po.getProperty("password");
		 */

		PropertiesUtility p = new PropertiesUtility();
		String url = p.getDataFromProperties("Url");
		String un = p.getDataFromProperties("Username");
		String pw = p.getDataFromProperties("password");

		ChromeOptions set = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		set.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(set);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("inputPassword")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		/*
		 * 
		 * FileInputStream fis2= new
		 * FileInputStream("C:\\Users\\User\\Desktop\\TESTDATA.xlsx"); Workbook wo =
		 * WorkbookFactory.create(fis2); String prodname =
		 * wo.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		 * System.out.println(prodname); String quan =
		 * wo.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
		 */

		ExcelUtility e = new ExcelUtility();
		String prodname = e.getDataFromexcelFile("Sheet1", 1, 0);
		String quan = e.getDataFromexcelFile("Sheet1", 1, 1);

		System.out.println(quan);
		Random r = new Random();
		int rand = r.nextInt(1000);

		driver.findElement(By.name("productName")).sendKeys(prodname + rand);

		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quan);
		WebElement selprod = driver.findElement(By.xpath("(//select)[1]"));
		Select s = new Select(selprod);
		s.selectByValue("Furniture");
		WebElement selven = driver.findElement(By.xpath("(//select)[2]"));
		Select s2 = new Select(selven);
		s2.selectByValue("VID_447");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='alert']"))));
		WebElement text = driver.findElement(By.xpath("//div[@role='alert']"));
		String notif = text.getText();
		if (text.isDisplayed()) {
			System.out.println(notif);
		} else {
			System.out.println("sorry not working");
		}
		driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--success']"))
				.click();

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='user-icon']"))).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
	}

}
