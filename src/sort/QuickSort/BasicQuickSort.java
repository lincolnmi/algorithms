package sort.QuickSort;

/**
 * Created by Jason on 2016/4/7.
 */
public class BasicQuickSort<T extends Comparable> implements SortAlgorithm<T> {

    public void sort(T[] array,int left,int right) {
        if (right<=left) {
            return;
        }
        int j = partition(array,left,right);
        sort(array,left,j-1);
        sort(array,j+1,right);
    }

    private int partition(T[] array, int left, int right) {
        int i = left, j = right+1;
        T v = array[left];
        while(true) {
            //scan from left
            while (less(array[++i],v)) {
                if (i==right) {
                    break;
                }
            }
            //scan from right
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
        swap(array,left,j);    // put array[j] = v
        return j;     //array[0..j-1]<=array[j]<=array[j+1..right]
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
