package kuang;

import java.io.*;
import java.util.stream.Stream;

public class TestIO {
    public static void main(String[] args) throws IOException {
        File src = new File("srcFile");
        File dst = new File("dst");

        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(dst);
        char[] buffer = new char[25];

        int len = 0;
        while ((len = fr.read(buffer))!=-1){
            fw.write(buffer,0,len);
            fw.flush();
        }



    }
}
