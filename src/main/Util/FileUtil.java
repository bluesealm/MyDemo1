import java.io.*;

public class FileUtil {
    public static void writeObj(String content){
        try {
            File file=new File(FileUtil.class.getResource("/11.txt").getFile());

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.flush();
            writer.close();

            byte[] c=content.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
