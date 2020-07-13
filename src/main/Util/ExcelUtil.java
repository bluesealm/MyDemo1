import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * @input:
 * @return:
 */
public class ExcelUtil {

 public static Iterator getExcelContent(String sheetName,String filePath){

     XSSFWorkbook work= null;
     Iterator<Row> iterator=null;
     try {
         File file=new File(ExcelUtil.class.getResource(filePath).getFile());
         work = new XSSFWorkbook(new FileInputStream(file));
         Sheet sheet=work.getSheet(sheetName);
         iterator=sheet.rowIterator();
     } catch (IOException e) {
         e.printStackTrace();
     }
    return iterator;
 }
}
