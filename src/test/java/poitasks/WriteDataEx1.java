package poitasks;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataEx1 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("./testdata/demo1.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet xs = wb.createSheet();
		XSSFRow xr1 = xs.createRow(0);
		XSSFRow xr2 = xs.createRow(1);
		xr1.createCell(0).setCellValue("demo value 1");
		xr1.createCell(1).setCellValue("demo value 2");
		
		xr2.createCell(0).setCellValue("demo 3");
		xr2.createCell(1).setCellValue("demo 4");

		wb.write(fos);
		wb.close();
		fos.close();
		System.out.println("Done Writing");
	}

}
