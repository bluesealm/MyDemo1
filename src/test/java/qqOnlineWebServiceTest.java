import javafx.scene.transform.MatrixType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

public class qqOnlineWebServiceTest {
    HttpClientUtil clientUtil=HttpClientUtil.getInstance();
    @Test
    public void qqCheckOnline() throws IOException {
        Iterator<Row> iterator=ExcelUtil.getExcelContent("qq","/qqList.xlsx");
        HashMap map=new HashMap();

        while(iterator.hasNext()){
            Row row=iterator.next();
            float qqno= Float.valueOf(String.valueOf(row.getCell(0)));
            int qqnoInteger=(int) qqno;

            String expectedResult=row.getCell(1).toString();
            map.put("qqCode",qqnoInteger);
            String response=clientUtil.doGet("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx/qqCheckOnline",map);

            FileUtil.writeObj(response);
            String actualResult=XMLUtil.getValue("/11.txt","string");
            Assert.assertEquals(actualResult,expectedResult);
        }
    }


}
