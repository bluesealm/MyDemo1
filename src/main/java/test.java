import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @input:
 * @return:
 */
public class test {

    public static  void main(String args[]){
        XSSFWorkbook work = null;
        {
            try {
                FileInputStream inputStream=new FileInputStream(ExcelUtil.class.getResource("/qqList.xlsx").getFile());

                work = new XSSFWorkbook(inputStream);
                work.createSheet("sheet2");
                Sheet sheet=work.getSheetAt(0);

                Iterator<Row> iterator=sheet.rowIterator();
                HashMap map=new HashMap();
                while(iterator.hasNext()){
                    Row row=iterator.next();
                    String str=row.getCell(0).toString();
                    System.out.println(str);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Sheet sheet=work.getSheetAt(0);

        Iterator<Row> iterator=sheet.rowIterator();
        HashMap map=new HashMap();
    }

}
