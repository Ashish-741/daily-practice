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
    public void flatten(TreeNode root) {
        MakeLL(root);
        // return ;
    }
    public TreeNode MakeLL(TreeNode root){  //Null hai toh return null.
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){  //Single node hai toh root hi return.
            return root;
        }
        TreeNode left_Tail=MakeLL(root.left);
        TreeNode right_Tail=MakeLL(root.right);
        if(root.left!=null){
            left_Tail.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        return right_Tail !=null ? right_Tail:left_Tail;
    }
}//114
