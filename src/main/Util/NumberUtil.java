import org.apache.poi.hssf.usermodel.HSSFCell;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @input:
 * @return:
 */
public class NumberUtil {

    public static Object getNumber(String number) {
        int numberInt = 0;
        if (isFloat(number)) {
            float port = Float.valueOf(number);
            numberInt = (int) port;
            return numberInt;
        } else{
            return number;
          }
    }
    //判断一个字符是否都为数字
    public static boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }

    // 判断一个字符串是否都为数字
    public static boolean  isFloat(String strNum) {
        Pattern pattern = Pattern.compile("[0-9].{1,}");
        Matcher matcher = pattern.matcher((CharSequence) strNum);
        return matcher.matches();
    }

    // 判断一个字符串是否含有数字
    public boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    public static boolean judgeContainsStr(String cardNum) {
        String regex=".*([A-Z]|[a-z])+.*";
        Matcher m=Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }
}
