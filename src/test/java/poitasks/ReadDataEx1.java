package poitasks;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadDataEx1 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./testdata/data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet xs = wb.getSheet("sheet1");
		// XSSFSheet xs = wb.getSheetAt(0);
		int totalrows = xs.getLastRowNum();

		for (int row = 0; row < totalrows; row++) {
			XSSFRow xr = xs.getRow(row);
			int totalcell = xr.getLastCellNum();
			for (int cell = 1; cell < totalcell; cell++) {
				XSSFCell xc = xr.getCell(cell);
				// String value = xc.toString();
				System.out.print(xc + "\t");
			}
			System.out.println();
		}

		wb.close();
		fis.close();
	}

}
