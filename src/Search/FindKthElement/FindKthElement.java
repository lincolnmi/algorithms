package Search.FindKthElement;

/**
 * Created by Jason on 2016/4/8.
 */
public class FindKthElement<T extends Comparable<T>> {

    public T select(T[] array,int k,int left,int right) {
        int j = partition(array,left,right);
        if (j<k) {
            return select(array,k,j+1,right);
        } else if (j>k) {
            return select(array,k,left,j-1);
        } else {
            return array[j];
        }
    }

    private int partition(T[] array, int left, int right) {
        int i = left, j = right+1;
        T v = array[left];
        while (true) {
            while (less(v,array[--j])) {
                if (j==left) {
                    break;
                }
            }
            while (less(array[++i],v)) {
                if (i==right) {
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

    private boolean less(T a, T b) {
        return a.compareTo(b)<0;
    }

    private void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
