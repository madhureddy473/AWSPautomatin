package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

/**
* Data Driven class is used to read data from excel sheet and run the tests with multiple data sets.
*/


public class DataDriven {


    /**
     *
      * @param filePath
     * @param fileName
     * @param sheetName
     * @param TestcaseID
     * @return
     * @throws IOException
     */
  public HashMap<String, String> readExcel(String filePath, String fileName, String sheetName, String TestcaseID) throws IOException{

      File file = new File(filePath+"/"+fileName); //changes "\\" to "/"  to support linux
      FileInputStream inputStream = new FileInputStream(file);
      Workbook mgoworkbook = null;
      String fileExtensionName = fileName.substring(fileName.indexOf("."));
      if(fileExtensionName.equals(".xlsx")){
          mgoworkbook = new XSSFWorkbook(inputStream);     }
      else if(fileExtensionName.equals(".xls")){
          mgoworkbook = new HSSFWorkbook(inputStream);      }
      Sheet agentsheet = mgoworkbook.getSheet(sheetName);
      int rowCount = agentsheet.getLastRowNum()-agentsheet.getFirstRowNum();

      //This arraylist is to store the cell values of the first row
      ArrayList<String> first_row = new ArrayList<String>();
      Row row = agentsheet.getRow(0);
      for (int j = 0; j < row.getLastCellNum(); j++) {
          String cell = String.valueOf(agentsheet.getRow(0).getCell(j));
          first_row.add(cell);
      }

      //This arraylist is to store the cell values of the respective testcase case row
      ArrayList<String> current_row = new ArrayList<String>();
      for (int k = 1; k <= rowCount; k++) {
          String cell_value = agentsheet.getRow(k).getCell(0)
                  .getStringCellValue();
          if (TestcaseID.equalsIgnoreCase(cell_value)) {
              for (int j = 0; j < row.getLastCellNum(); j++) {
                  Cell cell = agentsheet.getRow(k).getCell(j);
                  String Cell_Value;
                  if(cell!=null) {
                      if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                          BigDecimal Numeric_value = new BigDecimal(cell.getNumericCellValue());
                          Cell_Value = Numeric_value.toPlainString();
                      } else {
                          Cell_Value = cell.toString();
                      }
                      current_row.add(Cell_Value);
                  }
              }
          }
      }

      //This hashmap is to map and store the first row with the respective row
      HashMap<String, String> map = new HashMap<String, String>();
      int i = 0;
      while (i < current_row.size()) {
          map.put(first_row.get(i), current_row.get(i));
          i++;
      }
      return map;
  }


  public static void main(String...strings) throws IOException{
     DataDriven excelFile = new DataDriven();
     String filePath = System.getProperty("user.dir")+"/src/test/DataSheets";
     HashMap<String, String> test = excelFile.readExcel(filePath,"MasterData.xlsx","RegisterDevice", "UnregisterDevice");
     System.out.println(test.get("userId") + " and " + test.get("email"));
  }


    /**
     * This method is to decode base64
     * @param password String input password
     * @return decrypted string password
     */
    public String decodeBase64(String password){
        byte[] decryptPassword = Base64.getDecoder().decode(password);
        return new String(decryptPassword);
    }

}