package com.sample.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Reading from excel file.
 * @author 
 *
 */
public class ReadExcelDemo
{
    public static void main(String[] args)
    {
    	 
        
        List<ExcelBean> exelRecords =  readExcelFile();
        for (ExcelBean excelBean : exelRecords) {
        	//Printing the records read from excel file.
			System.out.println(excelBean.toString());
		}
    }
    
    /**
     * 
     * @return
     */
	private static List<ExcelBean> readExcelFile() {
		List<ExcelBean> exelRecords = new ArrayList<ExcelBean>();
		try
        {
            FileInputStream file = new FileInputStream(new File("resource/Sample.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
           
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                
                
                ExcelBean excelBean = new ExcelBean();
                 Integer cellIndex = 1;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    String cellValue = "";
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            cellValue = String.valueOf(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                    }
                    
                    switch (cellIndex) {
					case 1:
						excelBean.setStrOne(cellValue);
						break;
					case 2:
						excelBean.setStrTwo(cellValue);
						break;
					case 3:
						excelBean.setStrThree(cellValue);
						break;
					case 4:
						excelBean.setStrFour(cellValue);
						break;
					default:
						break;
					}
                    cellIndex++;
                    
                }
                exelRecords.add(excelBean);
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		 return exelRecords;
	}
}