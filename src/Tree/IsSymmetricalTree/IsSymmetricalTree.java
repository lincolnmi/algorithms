package Tree.IsSymmetricalTree;

import Tree.BSTToDList.TreeNode;

/**
 * Created by Jason on 2016/4/20.
 */
public class IsSymmetricalTree {

    public boolean isSymmetrical(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSymmetrical(root.left,root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left==null) {
            return right==null;
        }
        if (right==null) {
            return false;
        }
        if (left.val!=right.val) {
            return false;
        }
        return isSymmetrical(left.right,right.left) && isSymmetrical(left.left,right.right);
    }

}
