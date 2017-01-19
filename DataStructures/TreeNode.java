/** TreeNode class for binary search tree*/
public class TreeNode<T>
{
	// value stored in this node.
	private T val;
	
	// left child
	private TreeNode<T> left;

	// right child.
	private TreeNode<T> right;

	// Constructor sets value of node to val, and child to null.
	public TreeNode(T val)
	{
		this.val = val;	
		this.left = null;
		this.right = null;
	}
	
	// Sets the left child of this node.
	public void setLeft(TreeNode<T> left)
	{
		this.left = left;
	}
	
	// Sets the right child of this node.
	public void setRight(TreeNode right)
	{
		this.right = right;
	} 

	// Returns the value stored in this node.
	public T getValue()
	{
		return val;
	}

	// Sets the value of this node.
	public void setValue(T val)
	{
		this.val = val;
	}

	// Returns boolean of whether the node has a left child.
	public boolean hasLeft()
	{
		if(this.left == null)
			return false;
		else
			return true;
	}

	// Returns boolean of whether the node has a right child.
 	public boolean hasRight()
	{
		if(this.right == null)
			return false;
		else
			return true;
	} 

	// Returns the left child of this node.
	public TreeNode<T> leftChild()
	{
		return left;
	}

	// Returns the right child of this node.
	public TreeNode<T> rightChild()
	{
		return right;
	}	
}
