package utilities;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
        try {
            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
            if (sh == null) {
                sh = wb.createSheet(SheetName);
            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(new Consumer<Cell>() {
				@Override
				public void accept(Cell cell) {
				    columns.put(cell.getStringCellValue(), cell.getColumnIndex());
				}
			});

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * This method is to write data to respective row and column based on the input
     * @param text  input string from test class
     * @param className input string
     * @param column column number
     * @throws Exception
     */
    public void setCellData(String text, String className, String column) throws Exception {
        try{

            int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
            Row row = sh.getRow(0);

            for (int k = 1; k <= rowCount; k++) {
                String cell_value = sh.getRow(k).getCell(0)
                        .getStringCellValue();
                if (className.equalsIgnoreCase(cell_value)) {
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        if(sh.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase(column)){
                            Cell cell = sh.getRow(k).getCell(j);
                            cell.setCellValue(text);
                            fileOut = new FileOutputStream(excelFilePath);
                            wb.write(fileOut);
                            fileOut.flush();
                            fileOut.close();
                            break;
                        }
                    }
                }
            }
        }catch(Exception e){
            throw (e);
        }
    }


    /************************************* Unused methods ***********************************/


    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return"";
        }
    }

    public String getCellData(String columnName, int rownum) throws Exception {
        return getCellData(rownum, columns.get(columnName));
    }


}
