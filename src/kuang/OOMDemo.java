package kuang;

import java.util.ArrayList;
import java.util.List;

public class OOMDemo {
    Byte[] array = new Byte[1*1024*1024];

    public static void main(String[] args) {
        List<OOMDemo> list = new ArrayList<>();
        int cnt = 0;
        try {
            while (true){
                list.add(new OOMDemo());
                cnt++;
            }
        }catch (OutOfMemoryError e){
            System.out.println("cnt = " + cnt);
        }
    }
}
