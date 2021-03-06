import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @input:
 * @return:
 */

public class ValidateEmailWebServiceTest {
    @Test(dataProvider = "email")
    public void ValidateEmailAddress(String[] email) throws IOException {
        HttpClientUtil clientUtil=HttpClientUtil.getInstance();
        HashMap map=new HashMap();
        map.put("theEmail",email[0]);
        String response=clientUtil.doGet("http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx/ValidateEmailAddress",map);
        FileUtil.writeObj(response);
        String actualResult=XMLUtil.getValue("11.txt","unsignedByte");
        Assert.assertEquals(actualResult,email[1]);
        System.out.println(response);
    }


    @DataProvider(name = "email")
    public Object[][] provider() {
        Object[][] obj = new Object[][]{{"112@qq.com","1"},{"111","5"}};
        return obj;
    }

    @Test
    public void ValidateEmailAddressProTest() throws IOException {
        HttpClientUtil clientUtil=HttpClientUtil.getInstance();
        Iterator<Row> rowIterator=ExcelUtil.getExcelContent("mail","qqList.xlsx");
        while(rowIterator.hasNext()){
            Row row=(Row) rowIterator.next();
            HashMap map=new HashMap();

            map.put("theEmail",row.getCell(0));

            map.put("theEmailPort",NumberUtil.getNumber(row.getCell(1).toString()));

            Object expectedResult=NumberUtil.getNumber(row.getCell(2).toString());

            String response=clientUtil.doGet("http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx/ValidateEmailAddressPro",map);

            FileUtil.writeObj(response);
            String actualResult=XMLUtil.getValue("11.txt","unsignedByte");
            Assert.assertEquals(String.valueOf(expectedResult).replace("\n","").trim(),actualResult.replace("\r\n","").trim());
        }

    }

}

























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































