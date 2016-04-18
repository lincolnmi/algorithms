package Search.BitMap;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Jason on 2016/4/18.
 */
public class Data {

    public static void generateData(int size) {
        Random rd = new Random();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("qq.txt"));
            for (int i=0;i<size;i++) {
                bw.write(Math.abs(rd.nextInt(size))+"");
                bw.write("\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
