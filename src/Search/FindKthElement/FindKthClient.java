package Search.FindKthElement;

import sort.QuickSort.BasicQuickSort;

import java.util.Random;

/**
 * Created by Jason on 2016/4/8.
 */
public class FindKthClient {

    public static void main(String[] args) {
        int size = 50;
        int k = 10;
        Integer[] array = new Integer[size];
        Random rd = new Random();
        for (int i=0;i<size;i++) {
            array[i] = rd.nextInt(size) + 1;
        }
        BasicQuickSort<Integer> basicQuickSort = new BasicQuickSort<Integer>();
        basicQuickSort.sort(array,0,size-1);
        output(array);

        FindKthElement findKthElement = new FindKthElement();
        System.out.println(findKthElement.select(array,k));
    }

    private static void output(Integer[] array) {
        int size = array.length;
        for (int i=0;i<size;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
