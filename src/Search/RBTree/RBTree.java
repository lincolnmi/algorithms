package Search.RBTree;

import java.util.ArrayList;

/**
 * Created by Jason on 2016/4/8.
 */

/*
an definition
1. none of the node is connected to two red link that means it cannot exist two consecutive right link
2. only the left link can be red that means the right link cannot be red
3. perfect black balance that means the size of black link from null link to root are all equal
 */
public class RBTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left,right;
        int N;
        boolean color;

        public Node(Key key,Value value,int N,boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }

    }

    public boolean isRed(Node node) {
        if (node==null) {
            return false;
        } else {
            return node.color==RED;
        }
    }

    private Node rotateLeft(Node h) {
        //rotate
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        //change color
        x.color = h.color;
        h.color = RED;
        //update child size
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        //rotate
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        //change color
        h.color = RED;
        x.color = h.color;
        //update child size
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node node) {
        if (node==null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public void put(Key key,Value value) {
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h==null) {
            return new Node(key,value,1,RED);
        } else {
            int cmp = key.compareTo(h.key);
            if (cmp<0) {
                h.left = put(h.left,key,value);
            } else if (cmp>0) {
                h.right = put(h.right,key,value);
            } else {
                h.value = value;
            }
            if (isRed(h.right)&&!isRed(h.left)) {
                h = rotateLeft(h);
            }
            if (isRed(h.left)&&isRed(h.left.left)) {
                h = rotateRight(h);
            }
            if (isRed(h.left)&&isRed(h.right)) {
                flipColors(h);
            }
            h.N = size(h.left) + size(h.right) + 1;
            return h;
        }
    }

    public void levelOrder() {
        if (root==null) {
            return;
        }
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(root);
        int start = 0, count = 1;
        while (start<nodes.size()) {
            int temp = 0;
            while (start<count) {
                Node node = nodes.get(start++);
                if (node.left!=null) {
                    nodes.add(node.left);
                    temp++;
                }
                if (node.right!=null) {
                    nodes.add(node.right);
                    temp++;
                }
                System.out.print("("+node.key+","+node.color+") ");
            }
            count += temp;
            System.out.println();
        }
    }

}
