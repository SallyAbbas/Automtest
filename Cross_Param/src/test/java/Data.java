
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sal
 */
public class Data {
     Double[] array= new Double[3];
    Double txt1;
    Double txt2;
    int txt3;

        private static final WebDriver driver = null;
    public Double[] store_data()throws Exception{
       try {
          
  FileInputStream file = new FileInputStream(new File("E:\\Seleinum _workspace\\Data2.xls")); 
  HSSFWorkbook workbook = new HSSFWorkbook(file);
  HSSFSheet sh = workbook.getSheetAt(0);
for (int i=0; sh.getLastRowNum() > i; i++){
      array[0] = sh.getRow(i).getCell(0).getNumericCellValue();
      array[1] = sh.getRow(i).getCell(1).getNumericCellValue();
      array[2]= sh.getRow(i).getCell(2).getNumericCellValue();
}
       }catch (FileNotFoundException fnfe) {
 } catch (IOException ioe) {
 }
       return array;
    }
    
}
