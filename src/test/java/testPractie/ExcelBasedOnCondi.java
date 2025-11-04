package testPractie;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelBasedOnCondi {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String ecpec = "trc_03";
		
		String data1="";
		String data2="";
		String data3="";
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\TESTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		 int lastrows = sh.getLastRowNum();
		 for (int i = 0; i <=lastrows; i++) {
			 String data="";
			
				data= sh.getRow(i).getCell(0).getStringCellValue();
				
				if(data.equals(ecpec)){
					data1=sh.getRow(i).getCell(0).getStringCellValue();
		         data2=sh.getRow(i).getCell(1).getStringCellValue();
				 data3=sh.getRow(i).getCell(2).getStringCellValue();
			} 
				System.out.println(data1);
				System.out.println(data2);
				System.out.println(data3);
			}
			 
			 
			
		}

	}


