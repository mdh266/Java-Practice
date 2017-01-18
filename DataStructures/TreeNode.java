/* 
 TreeNode class for binary search trees
*/

public class TreeNode
{
	private int val;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int val)
	{
		this.val = val;	
		this.left = null;
		this.right = null;
	}
	
	public void setLeft(TreeNode left)
	{
		this.left = left;
	}
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	} 

	public int getValue()
	{
		return val;
	}

	public void setValue(int val)
	{
		this.val = val;
	}

	public boolean hasLeft()
	{
		if(this.left == null)
			return false;
		else
			return true;
	}

 	public boolean hasRight()
	{
		if(this.right == null)
			return false;
		else
			return true;
	} 

	public TreeNode leftChild()
	{
		return left;
	}

	public TreeNode rightChild()
	{
		return right;
	}
	
	
}
