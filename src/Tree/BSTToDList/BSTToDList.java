package Tree.BSTToDList;

import java.util.Stack;

/**
 * Created by Jason on 2016/4/20.
 */
public class BSTToDList {

    public static TreeNode process(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root!=null) {
            TreeNode pre = null, p = root;
            boolean isFirst = true;
            while (p!=null||!stack.isEmpty()) {
                while (p!=null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                if (isFirst) {
                    root = p;
                    pre = root;
                    isFirst = false;
                } else {
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }
                p = p.right;
            }
        }
        return root;
    }

    public static void outputDList(TreeNode root) {
        TreeNode current = root;
        while (current!=null) {
            System.out.println(current.val+" ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        root.left = a4;
        a4.left = a2;
        a2.left = a1;
        a2.right = a3;
        a4.right = a6;
        a6.left = a5;
        a6.right = a7;
        root = process(root);
        outputDList(root);
    }

}
