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
    int camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            camera++;
        }
        return camera;
    }
    public int minCamera(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left==-1 || right==-1){  //Is Node pe camera ki need hai
            camera++;
            return 1;  //Means camera is setup on this node
        }
        if(left==1 || right==1){  //Inme se koi ek ke pass ya dono pe camera hai or dusra covered hai.
            return 0; // Iska matlab mei covered hu.
        }
        else{
            return -1;   //Need a camera.
        }
    }
}
