package Utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String getStringCellValue(XSSFWorkbook workbook, int sheetNumber, int rowNumber, int cellNumber) {
		return workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(cellNumber).toString();
	}

	public static Double getDoubleCellValue(XSSFWorkbook workbook, int sheetNumber, int rowNumber, int cellNumber) {
		return Double.valueOf(workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(cellNumber).toString());
	}

	public static Integer getIntegerCellValue(XSSFWorkbook workbook, int sheetNumber, int rowNumber, int cellNumber) {
		return Integer.valueOf(workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(cellNumber).toString());
	}
}
