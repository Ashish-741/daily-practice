import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<VerticalPair> q = new LinkedList<>();
        TreeMap<Integer, List<VerticalPair>> map = new TreeMap<>();
        q.add(new VerticalPair(root, 0, 0));

        while (!q.isEmpty()) {
            VerticalPair vp = q.poll();
            map.computeIfAbsent(vp.v, k -> new ArrayList<>()).add(vp);

            if (vp.node.left != null) {
                q.add(new VerticalPair(vp.node.left, vp.l + 1, vp.v - 1));
            }
            if (vp.node.right != null) {
                q.add(new VerticalPair(vp.node.right, vp.l + 1, vp.v + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            List<VerticalPair> ll = map.get(key);
            Collections.sort(ll, (o1, o2) -> {
                if (o1.l == o2.l) {
                    return o1.node.val - o2.node.val; // sort by value if same row
                }
                return o1.l - o2.l; // sort by row
            });

            List<Integer> list = new ArrayList<>();
            for (VerticalPair v : ll) {
                list.add(v.node.val);
            }
            ans.add(list);
        }
        return ans;
    }

    class VerticalPair {
        TreeNode node;
        int l; // row
        int v; // col

        public VerticalPair(TreeNode node, int l, int v) {
            this.node = node;
            this.l = l;
            this.v = v;
        }
    }
}
