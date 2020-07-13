/**
 * @input:
 * @return:
 */

import jdk.internal.org.xml.sax.XMLReader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.List;

public class XMLUtil {

    public static String  getValue(String filePath,String label) throws IOException {
        SAXReader reader = new SAXReader();
        try {
          File file=new File(XMLUtil.class.getResource(filePath).getFile());
          try {
              Document doc = reader.read(new FileInputStream(file));
              List<Node> list = doc.selectNodes(label);
              Node node = (Node) list.get(0);
              String value = node.getStringValue();
              return value;
          }
          catch (Exception e){
              char[] c=new char[1024];
              FileReader stream=new FileReader(file);
              stream.read(c);
              return String.valueOf(c);
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

public static  void getDataSetValue(String filepath) throws FileNotFoundException {
        SAXReader reader=new SAXReader();
        File file = new File(XMLUtil.class.getResource(filepath).getFile());
        Document doc = null;
        try {
            doc = reader.read(new FileInputStream(file));
            String name= doc.getNodeTypeName();
            List<Node> list = doc.selectNodes("Symbol");
            System.out.println(list.get(0).getText());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
