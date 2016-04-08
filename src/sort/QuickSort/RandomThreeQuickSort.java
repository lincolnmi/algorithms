package sort.QuickSort;

import java.util.Random;

/**
 * Created by Jason on 2016/4/7.
 */
public class RandomThreeQuickSort<T extends Comparable<T>> implements SortAlgorithm<T>{
    public void sort(T[] array,int left,int right) {
        if (left>=right) {
            return;
        }
        int j = partition(array,left,right);
        sort(array,left,j-1);
        sort(array,j+1,right);
    }

    private int partition(T[] array, int left, int right) {
        Random rd = new Random();
        int idx1 = rd.nextInt(right-left+1) + left;
        int idx2 = rd.nextInt(right-left+1) + left;
        int idx3 = rd.nextInt(right-left+1) + left;
        swap(array,(idx1+idx2+idx3)/3,left);
        int i = left, j = right+1;
        T v = array[left];
        while (true) {
            while (less(array[++i],v)) {
                if (i==right) {
                    break;
                }
            }
            while (less(v,array[--j])) {
                if (j==left) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            swap(array,i,j);
        }
        swap(array,left,j);
        return j;
    }

    private void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private boolean less(T a, T b) {
        return a.compareTo(b)<0;
    }
}
