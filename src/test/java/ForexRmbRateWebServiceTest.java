import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @input:
 * @return:
 */
public class ForexRmbRateWebServiceTest {
    @Test
    public void getForexRmbRateTest(){

        String response=HttpClientUtil.doGet("http://www.webxml.com.cn/WebServices/ForexRmbRateWebService.asmx/getForexRmbRate",new HashMap());
        FileUtil.writeObj(response);
        String actualResult= null;
        try {
            XMLUtil.getDataSetValue("/11.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(actualResult);
    }

    @Test
    public void getForexRmbRateProTest(){

    }
}
