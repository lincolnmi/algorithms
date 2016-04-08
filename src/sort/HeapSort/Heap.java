package sort.HeapSort;

/**
 * Created by Jason on 2016/4/6.
 */
public class Heap<T extends Comparable<T>> {
    private T[] array;
    private int size = 0;

    public Heap() {
        array = (T[]) new Comparable[size+1];
    }

    public Heap(int maxSize) {
        array = (T[]) new Comparable[maxSize+1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void insert(T value) {
        array[++size] = value;
        swim(size);
    }

    public T delMax() {
        T max = array[1]; //retrieve max from the top
        swap(1,size--);  // exchange with the last item
        array[size+1] = null;  //avoid loitering
        sink(1); //restore heap property
        return max;
    }

    public boolean less(int i,int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    public void swim(int k) {
        while (k>1 && less(k/2,k)) {
            swap(k/2,k);
            k /= 2;
        }
    }

    public void sink(int k) {
        while (2*k<=size) {
            int j = 2*k;
            if (j<size&&less(j,j+1)) {
                j++;
            }
            if (!less(k,j)) {
                break;
            } else {
                swap(k,j);
                k = j;
            }
        }
    }

    public void swap(int i,int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
