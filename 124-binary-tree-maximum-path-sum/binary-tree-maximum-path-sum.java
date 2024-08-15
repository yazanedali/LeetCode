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
   private int res;
public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        res = root.val;
        dfs(root);
        return res;
    }
    int dfs(TreeNode root)
    {
        if (root == null)
            return 0;
        int leftmax = Math.max(dfs(root.left),0); //to avoid -ve value
        int rightnax = Math.max(dfs(root.right),0); // to avoid -ve value
        res = Math.max(res , root.val + leftmax + rightnax);
        System.out.println(root.val + Math.max(leftmax, rightnax));
        //return the maximum gain that can be achieved by including the current node
        return root.val + Math.max(leftmax, rightnax);
    }
}