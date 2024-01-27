package poitasks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataEx2 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("./testdata/demowrite.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet xs = wb.createSheet();
		Scanner sc = new Scanner(System.in);
		for (int row = 0; row < 3; row++) {
			XSSFRow xr = xs.createRow(row);
			for (int cell = 0; cell < 2; cell++) {
				System.out.println("Enter value :");
				xr.createCell(cell).setCellValue(sc.nextLine());
			}
		}

		wb.write(fos);
		wb.close();
		fos.close();
		System.out.println("Writing complete");
	}

}
