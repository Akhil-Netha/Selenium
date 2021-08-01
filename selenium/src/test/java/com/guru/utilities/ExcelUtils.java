package com.guru.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getTableArray(String path, String sheetName) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);

		Workbook fileObj = new XSSFWorkbook(inputStream);

		Sheet sheetObj = fileObj.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
		Row firstrow = sheetObj.getRow(0);
		int columns = firstrow.getLastCellNum();
		Object[][] data = new Object[rowCount + 1][columns];
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheetObj.getRow(i);
			for (int j = 0; j < columns; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					CellType cellType = cell.getCellType();
					if (cellType.equals(CellType.STRING)) {
						data[i][j] = cell.getStringCellValue();
					} else if (cellType.equals(CellType.NUMERIC)) {
						data[i][j] = cell.getNumericCellValue();
					} else if (cellType.equals(CellType.BOOLEAN)) {
						data[i][j] = cell.getBooleanCellValue();
					}
				}
			}
		}
		return data;
	}

}