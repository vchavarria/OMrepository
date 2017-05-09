package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoadUtil {
	// private static XSSFSheet ExcelWSheet;
	private XSSFWorkbook excelWBook;
	// private static XSSFCell Cell;
	// private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public void setExcelFile(String Path) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
			// Access the required test data sheet
			this.excelWBook = excelWBook;
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public XSSFWorkbook getExcelWBook() {
		return this.excelWBook;
	}

	// public static String getCellData(int RowNum, int ColNum) throws Exception
	// {
	// try {
	// Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	// String CellData = Cell.getStringCellValue();
	// return CellData;
	// } catch (Exception e) {
	// return "";
	// }
	// }
	//
	// // This method is to write in the Excel cell, Row num and Col num are the
	// // parameters
	// public static void setCellData(String Result, int RowNum, int ColNum)
	// throws Exception {
	// try {
	// Row = ExcelWSheet.getRow(RowNum);
	// Cell = Row.getCell(ColNum,
	// org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
	// if (Cell == null) {
	// Cell = Row.createCell(ColNum);
	// Cell.setCellValue(Result);
	// } else {
	// Cell.setCellValue(Result);
	// }
	// // Constant variables Test Data path and Test Data file name
	// FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData +
	// Constant.File_TestData);
	// ExcelWBook.write(fileOut);
	// fileOut.flush();
	// fileOut.close();
	// } catch (Exception e) {
	// throw (e);
	// }
	// }
}
