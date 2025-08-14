// this is only logic beacuse it is a premium question

// logic


// IN BST
public class inorderSuccessor {
	TreeNode successorNode=null;
	public TreeNode inorderSuccessor(TreeNode roor, TreeNode p)
	{
		if(root==null)
		{
			return null
		}
		if(root.val>p.val)
		{
			successorNode=root;
			Successor(root.left, p);
		}
		else
		{
			Successor(root.right, p)
		}
		return successorNode;
	}
	public static void main(String[] args) {
		
	}

}
