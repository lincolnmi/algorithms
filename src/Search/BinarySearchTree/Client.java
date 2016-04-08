package Search.BinarySearchTree;

/**
 * Created by Jason on 2016/4/8.
 */
public class Client {

    public static void main(String[] args) {
        String str = "SEARCHEXAMPLE";
        BST<Character,Integer> bst = new BST<Character, Integer>();
        int length = str.length();
        for (int i=0;i<length;i++) {
            bst.put(str.charAt(i),i);
        }
        bst.levelOrder();
        System.out.println("after delete element E");
        bst.delete('E');
        bst.levelOrder();
    }

}
