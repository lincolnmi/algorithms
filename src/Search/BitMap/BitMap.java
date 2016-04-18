package Search.BitMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jason on 2016/4/18.
 */
public class BitMap {

    private int array[];
    private final int shift = 5;

    public BitMap(int size) {
        array = new int[size/8+1];
    }

    public void insert(int x) {
        int idx = x >> shift;
        int value = x & (1<<shift);
        array[idx] |= 1<<value;
    }

    public boolean isExist(int x) {
        int idx = x >> shift;
        int value = x & (1<<shift);
        int flag = (array[idx] | 1<<value);
        return (flag==1)?true:false;
    }

    public void insertAll() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("qq.txt"));
            String str = null;
            while ((str=br.readLine())!=null) {
                insert(Integer.valueOf(str));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int size = 10000000;
        Data.generateData(size);
        Runtime rt = Runtime.getRuntime();
        System.out.println("当前 Java 虚拟机中占用内存量：" + (rt.totalMemory() - rt.freeMemory())/1000/1000 + "M");
        BitMap bitMap = new BitMap(size);
        System.out.println("当前 Java 虚拟机中占用内存量：" + (rt.totalMemory() - rt.freeMemory())/1000/1000 + "M");

        bitMap.insertAll();
        System.out.println("data generate done!");
        System.out.println(bitMap.isExist(size));
    }

}
