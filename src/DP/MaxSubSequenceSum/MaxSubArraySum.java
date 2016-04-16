package DP.MaxSubSequenceSum;

/**
 * Created by Jason on 2016/4/16.
 */
public class MaxSubArraySum {

    public static int getMaxSum(int... array) {
        int length = array.length;
        if (length==0) {
            return 0;
        } else {
            int sum = array[0], maxValue = array[0];
            for (int i=1;i<length;i++) {
                sum = Math.max(sum+array[i],array[i]);
                maxValue = Math.max(maxValue,sum);
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,-7,3,-2,6};
        System.out.println(getMaxSum(array));
    }
}
