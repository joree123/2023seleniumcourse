package utils;

import java.io.IOException;
import java.io.File;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.FileConstants;


public class ExcelUtils {
	
	public static String[] readLoginTestData(int row) throws InvalidFormatException, IOException {
		
		XSSFWorkbook loginWorkBook = new XSSFWorkbook(new File(FileConstants.LOGIN_TESTDATA_FILE_PATH));
		XSSFSheet loginCreds = loginWorkBook.getSheet("UserCredentials");
		XSSFRow rows = loginCreds.getRow(row);
		String[] creds = new String[rows.getLastCellNum()];
		for(int ro = row; ro <= rows.getLastCellNum(); ro++) {
			creds[ro] = rows.getCell(ro+1).getStringCellValue();
		}
		
		return creds;
	}

	
}

