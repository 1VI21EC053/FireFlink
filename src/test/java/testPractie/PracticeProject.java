package testPractie;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PracticeProject {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\commandata.properties");
       Properties pobj = new Properties();
       pobj.load(fis);
       String BROWSER = pobj.getProperty("Broswer");
       String URL  = pobj.getProperty("url");
       System.out.println(URL);
       
 
	}
}

