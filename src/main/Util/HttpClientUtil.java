import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.*;

public class HttpClientUtil {

    static HttpClientUtil clientUtil=new HttpClientUtil();
    public static HttpClientUtil  getInstance(){
         return clientUtil;
     }

    public static String doGet(String url, HashMap map)  {
        CloseableHttpClient  httpclinet =HttpClientBuilder.create().build();
        CloseableHttpResponse  respone=null ;
        HttpGet  httpGet=null;
        try {
         Builder config= RequestConfig.custom();
         URIBuilder uriBuilder = new URIBuilder(url);
         List<NameValuePair> list = new LinkedList<>();

         if(map!=null) {
             Iterator mapIterator = map.entrySet().iterator();
             while (mapIterator.hasNext()) {
                 Map.Entry entry = (Map.Entry) mapIterator.next();
                 BasicNameValuePair param1 = new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString());
                 list.add(param1);
             }
         }
         uriBuilder.setParameters(list);
         httpGet=new HttpGet (uriBuilder.build());
         respone = httpclinet.execute(httpGet);

         HttpEntity entity = respone.getEntity();

         String respHtml = EntityUtils.toString(entity, "UTF-8");

        /* BufferedInputStream ins = new BufferedInputStream(entity.getContent());
         byte[] c = new byte[2048];
         ins.read(c);*/
         return respHtml;
     }
     catch(IOException | URISyntaxException io){

     }
     finally {
            try {
                respone.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpGet.releaseConnection();
     }
        return "";
    }



    public static String jsonPost(String url,String key,String value) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).build();
        httpPost.setConfig(config);

        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair(key, value);
        list.add(param1);

        // 使用URL实体转换工具

        UrlEncodedFormEntity entityParam = null;
        try {
            entityParam = new UrlEncodedFormEntity(list);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        httpPost.setEntity(entityParam);

        CloseableHttpResponse response = null;
        String respHtml = null;
        try {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();


            if (statusCode == 200) {
                HttpEntity reEntity = response.getEntity();
                respHtml = EntityUtils.toString(reEntity, "UTF-8");
            }
            return respHtml;
        } catch (IOException io) {
                io.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpPost.releaseConnection();
        }

        return "";
    }
    public static void filePost(String  url,File file){
        CloseableHttpClient httpClient =HttpClientBuilder.create().build();
        HttpPost httpPost=new HttpPost(url);

        RequestConfig config=RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(10000).build()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ;
        httpPost.setConfig(config);

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

        FileEntity entity= new FileEntity(file);

        httpPost.setEntity(entity);
        CloseableHttpResponse response =null;

        try {
             response = httpClient.execute(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpPost.releaseConnection();
            }
            }


}
