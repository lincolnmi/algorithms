package StringAlgorithm.KMP;

/**
 * Created by Jason on 2016/4/18.
 */
public class KMP {

    public boolean isSubStr(String pattern,String s) {
        int[] next = getNext(pattern);
        int n = pattern.length();
        int m = s.length();
        for (int i=0,j = 0;i<m;i++) {
            while (j>0&&pattern.charAt(j)!=s.charAt(i)) {
                j = next[j-1];
            }
            if (pattern.charAt(j)==s.charAt(i)) {
                j++;
            }
            if (j==n) {
                return true;
            }
        }
        return false;
    }

    public int[] getNext(String str) {
        int length = str.length();
        int[] next = new int[length];
        next[0] = 0;
        //max prefix length
        for (int i=1,k=0;i<length;i++) {
            while (k>0 && str.charAt(k)!=str.charAt(i)) {
                k = next[k-1];
            }
            if (str.charAt(k)==str.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        KMP kmp = new KMP();
        int[] next = kmp.getNext(pattern);
        for (int i:next) {
            System.out.print(i+" ");
        }
        System.out.println();
        boolean flag = kmp.isSubStr(pattern,s);
        System.out.println(flag);
    }

}
