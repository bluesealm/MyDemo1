import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class TestDemo {
    @Test
    @Parameters({"Name", "Age", "Hobby"})
    public void testcase1(String name, String Age) {

    }

    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][]{
                {Vector.class, new String[]{"java.util.AbstractList", "java.util.AbstractCollection"}},
                {String.class, new String[]{"1", "2"}},
                {Integer.class, new String[]{"1", "2"}
                }
        };
    }

    @Test
    public void extractFile() {
        File file = new File("D:\\limeng\\test automation reference\\test.xlsx");
        try {
            FileInputStream fs = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet xsheet = workbook.getSheetAt(0);

            Iterator<Row> rows = xsheet.rowIterator();

            while (rows.hasNext()) {
                Row row = (Row) rows.next();

                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.print(cell+",");
                }
                System.out.println(",");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void recordDealData() {

    }

}
