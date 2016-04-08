package Search.RBTree;

import Search.BinarySearchTree.BST;

/**
 * Created by Jason on 2016/4/8.
 */
public class RBTreeClient {

    public static void main(String[] args) {
        String str = "SEARCHEXAMPLE";
        RBTree<Character,Integer> rbTree = new RBTree<Character, Integer>();
        int length = str.length();
        for (int i=0;i<length;i++) {
            rbTree.put(str.charAt(i),i);
        }
        rbTree.levelOrder();
    }

}
