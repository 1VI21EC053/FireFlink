package testPractie;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class multidata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
          Sheet sh = wb.getSheet("New testers id ");
          int lastrow = sh.getLastRowNum();
                       
          for (int i = 1; i <=lastrow; i++) {
        	 short lastCol = sh.getRow(i).getLastCellNum();
        	  for (int j = 0; j <lastCol; j++) {
        		  String alldta = sh.getRow(i).getCell(j).getStringCellValue();
        		  System.out.print(alldta+" ");
			}
        	  System.out.println("");
        	 
			
		}
	}

}
