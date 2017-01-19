import java.util.*;


/**Generic binary search tree.*/
public class BinSearchTree_Recursive
{
	
	/// The root of the tree
	private TreeNode<Integer> root;	

	/** Constructor sets head to null.*/
	public BinSearchTree_Recursive()
	{
		root = null;
	}

	/** Adds a node with val to the tree. */
	public void addNode(int val)
	{
		if(root == null)
			root = new TreeNode<Integer>(val);
		else
			addNode(root, val); 
	}

	/** Inner recursive add node function.*/
	private void addNode(TreeNode<Integer> node, int val)
	{
		// Create the child then add it to the parent
		// under which it belongs.
		TreeNode<Integer> child = new TreeNode<Integer>(val);

		if(node.getValue() > val)
		{
			if(node.hasLeft() == false)
				node.setLeft(child);
			else
				this.addNode(node.leftChild(), val);
		}
		else
		{
			if(node.hasRight() == false)
				node.setRight(child);
			else
				this.addNode(node.rightChild(), val);
		}
	}

	/** Deletes the node with value val.*/	
	public void delete(int val)
	{
		root = delete(root,val);
	}

	/** Inner delete will recursively traversetree and remove node with value val.*/
	private TreeNode<Integer> delete(TreeNode<Integer> node, int val)
	{		
			// set the left node = to the left node unless its
			// the node to remove
			if(node.getValue() > val)
				node.setLeft(delete(node.leftChild(), val));

			// set the right node = to the right node unless its
			// the node to remove
			else if(node.getValue() < val)
				node.setRight(delete(node.rightChild(), val));

			// node to remove
			else // node.val = val
			{
				// left child is null, (or both null)
				if(node.hasLeft() == false)
				{	
						return node.rightChild();
				}
				// right child is null, (or both null)
				else if(node.hasRight() == false)
				{
						return node.leftChild();
				}
				else
				{
					// set this node value equal to the 
					// smallest descendent of right child
					// and delete that node
					int temp = this.min(node.rightChild());
					deleteMin(node.rightChild());
					node.setValue(temp);				
				}
			}
			return node;
	}
	
	/** Deletes the descendent node that has the smallest value.*/
	public TreeNode<Integer> deleteMin(TreeNode<Integer> node)
	{
		// recursively go down the tree setting
		// each node's left child equal to the left child
		// if it has one and return that node
		if(node.hasLeft() == true)
		{
			node.setLeft(deleteMin(node.leftChild()));
			return node;
		}
		else
		{
			// if this node has no left child, return the right child
			// then the parents left child will become the deleted node's
			// right child which is what we want.
			return node.rightChild();
		}
	}

	/** Returns the height of the tree.*/
	public int height()
	{
		return height(root);
	}

	/** Inner recursive call to find the height of the tree.*/
	private int height(TreeNode<Integer> node)
	{
		if(node == null)
			return 0;
		else
		{
			return 1 + Math.max(height(node.leftChild()),
													height(node.rightChild()));
		}
	}

	/** Returns the minimum element of the tree.*/
	public int min()
	{
		TreeNode<Integer> curr = root;
		return this.min(curr);
	}

	/** Inner recursive call to find the minimum of the tree.*/
	private int min(TreeNode<Integer> curr)
	{
		while(curr.hasLeft())
			curr = curr.leftChild();

		return curr.getValue();	
	}

	/** Returns a boolean if the val is found in the tree.*/
	public boolean find(int x)
	{
		TreeNode<Integer> node = root;
		
		return find(root,x);	
	}

	/** Inner recursive call to find the value in the tree.*/
	private boolean find(TreeNode<Integer> node, int x)
	{	
		if(node != null)
		{	
			if(node.getValue() > x)
				return find(node.leftChild(), x);
			else if(node.getValue() < x)
				return find(node.rightChild(), x);
			else
				return true;
		}	
		else
			return false;
	}

	/** Prints the tree in pre-order.*/
	public void preOrder()
	{
		preOrder(root);
		System.out.println();
	}

	/** Inner recurisve preOrder call.*/
	private void preOrder(TreeNode<Integer> node)
	{
		// only do if node is not null
		if(node != null)
		{
			System.out.print(node.getValue() + " ");
			preOrder(node.leftChild());
			preOrder(node.rightChild());
		}
	}

	/** Prints the tree in in-order.*/
	public void inOrder()
	{
		inOrder(root);
		System.out.println();
	}

	/** Inner recurisve in-order call.*/
	private void inOrder(TreeNode<Integer> node)
	{
		// only do if node is not null
		if(node != null)
		{
			inOrder(node.leftChild());
			System.out.print(node.getValue() + " ");
			inOrder(node.rightChild());
		}
	}

	/** Prints the tree in post-order.*/
	public void postOrder()
	{
		postOrder(root);
		System.out.println();
	}

	/** Inner recurisve post-order call.*/
	private void postOrder(TreeNode<Integer> node)
	{
		// only do if node is not null
		if (node != null)
		{
			postOrder(node.leftChild());
			postOrder(node.rightChild());
			System.out.print(node.getValue() + " ");
		}
	}


	public static void main(String [] args)
	{
		/*
								5
							/		\
						 4		 10
					  /			/	\
				   1		 7	 12
									\
									 8
		*/
		int[] array = {5,4,10,1,7,12,8};
		BinSearchTree_Recursive tree =
										 new BinSearchTree_Recursive();

		for(int i=0; i < array.length; i++)
			tree.addNode(array[i]);
	
		System.out.print("InOrder Traversal: ");
		tree.inOrder();
		System.out.print("Tree height:");	
		System.out.println(tree.height());		
		System.out.print("preOrder Traversal: ");
		tree.preOrder();
		System.out.print("postOrder Traversal: ");
		tree.postOrder();
		System.out.println("7 is in tree is " + tree.find(7));
		System.out.println("2 is in tree is " + tree.find(2));
		System.out.println("Removing 1");
		tree.delete(5);
		System.out.print("InOrder Traversal: ");
		tree.inOrder();
	
		
	}	

}
