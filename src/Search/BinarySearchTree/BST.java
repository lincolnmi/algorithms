package Search.BinarySearchTree;

import java.util.ArrayList;

/**
 * Created by Jason on 2016/4/8.
 */
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    //definite the binary node
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

    //query an element
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

    //insert an element
    public void put(Key key,Value value) {
        root = put(root,key,value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node==null) {
            return new Node(key,value,1);
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp<0) {
                node.left = put(node.left,key,value);
            } else if (cmp>0) {
                node.right = put(node.right,key,value);
            } else {
                node.value = value;
            }
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    //get the minimum key
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left==null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    //delete min element
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left==null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    //delete max element
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right==null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    //delete an element
    public void delete(Key key) {
        root = delete(root,key);
    }

    private Node delete(Node node, Key key) {
        if (node==null) {
            return null;
        } else {
            int cmp = key.compareTo(node.key);
            if (cmp<0) {
                node.left = delete(node.left,key);
            } else if (cmp>0) {
                node.right = delete(node.right,key);
            } else {
                if (node.right==null) {
                    return node.left;
                }
                if (node.left==null) {
                    return node.right;
                }
                Node t = node;
                node = min(t.right);
                /*
                here we should set right node and then set left node,
                if not, the right min node has the left node
                deleteMin(t.right) will fail
                */
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    public void levelOrder() {
        if (root==null) {
            return;
        } else {
            ArrayList<Node> keys = new ArrayList<Node>();
            int start = 0, count = 1;
            keys.add(root);
            while (start<keys.size()) {
                int temp = 0;
                while (start<count) {
                    Node node = keys.get(start++);
                    System.out.print(node.key + " ");
                    if (node.left != null) {
                        keys.add(node.left);
                        temp++;
                    }
                    if (node.right != null) {
                        keys.add(node.right);
                        temp++;
                    }
                }
                count += temp;
                System.out.println();
            }
        }
    }

}
