package practice.alignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jason on 2016/4/20.
 */
public class Alignment {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str.length()==0) {
            return result;
        }
        char[] sequences = str.toCharArray();
        Permutation(result,0,sequences);
        Collections.sort(result);
        return result;
    }

    private void Permutation(ArrayList<String> result,int idx,char[] sequences) {
        if (idx==sequences.length-1) {
            result.add(new String(sequences));
        } else {
            for (int i=idx;i<sequences.length;i++) {
                if (isSwap(sequences,idx,i)) {
                    swap(sequences, i, idx);
                    Permutation(result, idx + 1, sequences);
                    swap(sequences, i, idx);
                }
            }
        }
    }

    private boolean isSwap(char[] sequences,int i,int j) {
        for (int idx=i;idx<j;idx++) {
            if (sequences[idx]==sequences[j]) {
                return false;
            }
        }
        return true;
    }

    private void swap(char[] sequences,int i,int j) {
        char temp = sequences[i];
        sequences[i] = sequences[j];
        sequences[j] = temp;
    }

    public static void main(String[] args) {
        Alignment alignment = new Alignment();
        String s = "abc";
        ArrayList<String> result = alignment.Permutation(s);
        for (String str:result) {
            System.out.println(str);
        }
    }

}
