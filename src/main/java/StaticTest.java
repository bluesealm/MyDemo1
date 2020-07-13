import org.testng.Assert;

public class StaticTest {
    static String  name="name";

    public static void main(String args[]){

        String  s1="无法将 aaa 转换为 System.Int32。参数名: type ---> 输入字符串的格式不正确。";
        String  s2="无法将 aaa 转换为 System.Int32。参数名: type ---> 输入字符串的格式不正确。";
        Assert.assertEquals(s1,s2,"true");
        System.out.println(s1.equals(s2));
}


}