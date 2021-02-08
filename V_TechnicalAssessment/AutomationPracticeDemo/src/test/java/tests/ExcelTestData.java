package tests;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelTestData {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static String dataFilePath = "./data/data.xlsx";

    /**
     *
     * @param sheetName where i want to add the data from
     * @return a sheet which contains rows and columns of data
     */
    private static XSSFSheet readData(String sheetName){

        try {
            workbook = new XSSFWorkbook(dataFilePath);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }


    /**
     *
     * @param cell which contains apiece of data
     * @return a data value
     */
    private static String formatData(XSSFCell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    /**
     *
     * @param sheetName where i want to add the data from
     * @return string array of data values that can be used in our test
     */
    public static String[][] collectData (String sheetName) {

        //get the number of rows and columns in the sheet
        int rowsCount = readData(sheetName).getPhysicalNumberOfRows();
        int cellsCount = readData(sheetName).getRow(1).getPhysicalNumberOfCells();

        String[][] data = new String[rowsCount-1][cellsCount];

        for(int row = 0; row <= rowsCount-2; row++) {
            for(int cell = 0; cell <= cellsCount-1; cell++) {
                data[row][cell] = formatData(readData(sheetName).getRow(row+1).getCell(cell));
            }
        }
        return data;
    }




}
