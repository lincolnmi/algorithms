package sort.HeapSort;

/**
 * Created by Jason on 2016/4/6.
 */
public class HeapSort {

    public static void process() {
        Heap heap = new Heap(100);
        int[] value = new int[10];
        for (int i=0;i<value.length;i++) {
            value[i] = i;
            heap.insert(value[i]);
        }
        for (int i=0;i<10;i++) {
            System.out.println(heap.delMax());
        }
    }

    public static void main(String[] args) {
        HeapSort.process();
    }

}
