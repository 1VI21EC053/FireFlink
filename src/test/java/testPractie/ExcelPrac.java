package testPractie;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ninja.crm.generic.wedriverutility.JavaUtility;

public class ExcelPrac {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	   FileInputStream fis  = new FileInputStream("./src/test/resources/testdata.xlsx");
       Workbook wo = WorkbookFactory.create(fis);
       String sh = wo.getSheet("TESTER").getRow(1).getCell(1).getStringCellValue();
       System.out.println(sh);
       JavaUtility j = new JavaUtility();
      String date = j.getFutureDate(1234567);
       System.out.println(date);
       
	}

	
		
	}

