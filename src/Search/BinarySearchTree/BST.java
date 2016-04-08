package Search.BinarySearchTree;

/**
 * Created by Jason on 2016/4/8.
 */
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node {
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int N;

        public Node(Key key,Value value,int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node==null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp<0) {
                return get(node.left,key);
            } else if (cmp>0) {
                return get(node.right,key);
            } else {
                return node.value;
            }
        }
    }

    public void put()
}
