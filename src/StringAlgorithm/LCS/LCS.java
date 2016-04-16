package StringAlgorithm.LCS;

/**
 * Created by Jason on 2016/4/16.
 */
public class LCS {
    private static final char lefttop = '0';
    private static final char top = '1';
    private static final char left = '2';

    public static String getMaxSequence(String a,String b) {
        int len1 = a.length(), len2 = b.length();
        int[][] matrix = new int[len1+1][len2+1];
        char[][] path = new char[len1+1][len2+1];

        for (int i=1;i<=len1;i++) {
            for (int j=1;j<=len2;j++) {
                if (a.charAt(i-1)==b.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1]+1;
                    path[i][j] = lefttop;
                } else if (matrix[i-1][j]>matrix[i][j-1]) {
                    matrix[i][j] = matrix[i-1][j];
                    path[i][j] = top;
                } else {
                    matrix[i][j] = matrix[i][j-1];
                    path[i][j] = left;
                }
            }
        }
        int i = len1, j = len2;
        StringBuilder sb = new StringBuilder();
        while (!(i==0||j==0)) {
            char ch = path[i][j];
            switch (ch) {
                case lefttop:
                    sb.append(a.charAt(i-1));
                    i--;
                    j--;
                    break;
                case left:
                    j--;
                    break;
                case top:
                    i--;
                    break;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "abcbdab";
        String b = "bdcaba";
        System.out.println(getMaxSequence(a,b));
    }

}
