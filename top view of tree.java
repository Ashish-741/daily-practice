import java.util.*;

public class topview {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> topView(TreeNode root) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            List<Integer> ll = new ArrayList<>();
            view(root, 0, map);

            for (int val : map.values()) {
                ll.add(val);
            }
            return ll;
        }

        public void view(TreeNode root, int curr, TreeMap<Integer, Integer> map) {
            if (root == null) {
                return;
            }
            if (!map.containsKey(curr)) {
                map.put(curr, root.val);
            }
            view(root.left, curr - 1, map);
            view(root.right, curr + 1, map);
        }
    }
}
