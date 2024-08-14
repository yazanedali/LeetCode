/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)  //if both nodes are empty

        return true; 
        if (p == null || q == null || (p.val!=q.val)) 
        return false; //I mean just one is null or p.value!=q.value

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}