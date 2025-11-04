package testPractie;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ninja.crm.ObjectRepository.LoginPage;
import com.ninja.crm.generic.fileutility.PropertiesUtility;

public class PracticeOnPom {

	public static void main(String[] args) throws IOException  {
		WebDriver driver = new ChromeDriver();
		PropertiesUtility ppu = new PropertiesUtility();
		String URL = ppu.getDataFromProperties("Url");
		String un = ppu.getDataFromProperties("Username");
		String pw = ppu.getDataFromProperties("Password");
	   LoginPage lp = new LoginPage(driver);
	   lp.LoginToAppp(URL, un, pw);
	}
}
