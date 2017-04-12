/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
	1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].
		4
	   / \				
	  5   2
    	 / \
    	3   1





右结点会是空 or 叶子


*/

public TreeNode UpsideDownBinaryTree(TreeNode root) {  
	if(root == null)
		return null;
	TreeNode parent = root;
	TreeNode left = root.left;
	TreeNode right = root.right;
	if(left != null){
		TreeNode ret = UpsideDownBinaryTree(left);
		ret.left = left;
		left.left = right;
		left.right = parent;
        return ret;  
	}
	return root;

}

// parent is the parent of current node , right is the right brogher of current node
// save left child,  take right brother as left child,  save right child for next round, take parent as right child, point parent to current node, point node to left


public TreeNode UpsideDownBinaryTreeW2(TreeNode root) {  
    TreeNode node = root, parent = null, right = null;  
    while (node != null) {  
        TreeNode left = node.left;  
        node.left = right;  
        right = node.right;  
        node.right = parent;  
        parent = node;  
        node = left;  
    }  
    return parent;  
}  