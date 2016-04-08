package sort.QuickSort;

import java.util.Random;

/**
 * Created by Jason on 2016/4/7.
 */
public class Client {

    public static Integer[] getRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random rd = new Random();
        for (int i=0;i<size;i++) {
            array[i] = rd.nextInt(size);
        }
        return array;
    }

    public static Integer[] getAscendingArray(int size) {
        Integer[] array = new Integer[size];
        for (int i=0;i<size;i++) {
            array[i] = i;
        }
        return array;
    }

    public static Integer[] getDescendingArray(int size) {
        Integer[] array = new Integer[size];
        for (int i=0;i<size;i++) {
            array[i] = size - i;
        }
        return array;
    }

    public static Integer[] getDuplicateArray(int size) {
        Integer[] array = new Integer[size];
        for (int i=0;i<size;i++) {
            array[i] = 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 10000;
        Integer[] randomArray = getRandomArray(size);
        Integer[] ascendingArray = getAscendingArray(size);
        Integer[] descendingArray = getDescendingArray(size);
        Integer[] duplicateArray = getDuplicateArray(size);

        BasicQuickSort<Integer> basicQuickSort = new BasicQuickSort<Integer>();
        RandomQuickSort<Integer> randomQuickSort = new RandomQuickSort<Integer>();
        RandomThreeQuickSort<Integer> randomThreeQuickSort = new RandomThreeQuickSort<Integer>();

        System.out.println("randomArray");
        System.out.println(getRunTime(basicQuickSort, randomArray.clone()));
        System.out.println(getRunTime(randomQuickSort, randomArray.clone()));
        System.out.println(getRunTime(randomThreeQuickSort, randomArray.clone()));
        System.out.println("ascendingArray");
        System.out.println(getRunTime(basicQuickSort, ascendingArray.clone()));
        System.out.println(getRunTime(randomQuickSort, ascendingArray.clone()));
        System.out.println(getRunTime(randomThreeQuickSort, ascendingArray.clone()));
        System.out.println("descendingArray");
        System.out.println(getRunTime(basicQuickSort, descendingArray.clone()));
        System.out.println(getRunTime(randomQuickSort, descendingArray.clone()));
        System.out.println(getRunTime(randomThreeQuickSort, descendingArray.clone()));
        System.out.println("duplicate");
        System.out.println(getRunTime(basicQuickSort, duplicateArray.clone()));
        System.out.println(getRunTime(randomQuickSort, duplicateArray.clone()));
        System.out.println(getRunTime(randomThreeQuickSort, duplicateArray.clone()));

    }

    private static void output(Integer[] array) {
        int size = array.length;
        for (int i=0;i<size;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static long getRunTime(SortAlgorithm<Integer> sortAlgorithm, Integer[] array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(array.clone(), 0, array.length - 1);
        long end = System.currentTimeMillis();
        return end-start;
    }

}
