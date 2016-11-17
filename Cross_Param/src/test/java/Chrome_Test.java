
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sally_mohamed
 */
public class Chrome_Test {
     private static WebDriver driver = null;
 

    /**
     *
     * @throws java.lang.Exception
     */
    @Test
   public  void main() throws Exception {
   System.setProperty("webdriver.chrome.driver","C:\\Users\\Sally_Mohamed\\Downloads\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://www.calculator.net");
         
   Src.lnk_math_calc(driver).click();		
   Src.lnk_percent_calc(driver).click();

      
 try {
    
  FileInputStream file = new FileInputStream(new File("E:\\Seleinum _workspace\\Data2.xls"));
  HSSFWorkbook workbook = new HSSFWorkbook(file);
  HSSFSheet sh = workbook.getSheetAt(0);
for (int i=0; sh.getLastRowNum() > i; i++){
   Double txt1 = sh.getRow(i).getCell(0).getNumericCellValue();
   Double txt2 = sh.getRow(i).getCell(1).getNumericCellValue();
   int txt3 = (int) sh.getRow(i).getCell(2).getNumericCellValue();
   Src.lnk_math_calc(driver).click();		
   Src.lnk_percent_calc(driver).click();
   Src.txt_num_1(driver).clear();
   Src.txt_num_1(driver).sendKeys(txt1+"");
   Src.txt_num_2(driver).clear();
   Src.txt_num_2(driver).sendKeys(txt2+"");   
   Src.btn_calc(driver).click();
   String result = Src.web_result(driver).getText();          

      
      if(result.equalsIgnoreCase(txt3+"")){
          System.out.println(" The Result is Pass");
      }
      else {
          System.out.println(" The Result is Fail");
          
      }
  
      }
  driver.close();
        
 } catch (FileNotFoundException fnfe) {
 } catch (IOException ioe) {
 }
   }
    
}
