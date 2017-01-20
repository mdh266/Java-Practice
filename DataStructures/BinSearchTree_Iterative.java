import java.util.*;

/**Generic binary search tree.*/
public class BinSearchTree_Iterative
{
	
	/// The root of the tree
	private TreeNode<Integer> root;	

	/** Constructor sets head to null.*/
	public BinSearchTree_Iterative()
	{
		root = null;
	}

	/** Adds a node with val to the tree. */
	public void addNode(int val)
	{
		if(root == null)
			root = new TreeNode<Integer>(val);
		else
		{
			TreeNode<Integer> curr = root;
			boolean found = false;
			TreeNode<Integer> newnode = new TreeNode<Integer>(val);
			while(!found)
			{
				if(curr.getValue() > val)
				{
					if(curr.hasLeft() == false)
					{
						curr.setLeft(newnode);
						found =  true;
					}
					else
						curr = curr.leftChild();
				}
				else if(curr.getValue() < val)
				{
					if(curr.hasRight() == false)
					{	
						curr.setRight(newnode);
						found = true;
					}
					else
						curr = curr.rightChild();	
				}
				else // already found
					break;		
			}
		}
	}

	/** Deletes the node with value val.*/	
	public void delete(int val)
	{
		TreeNode<Integer> curr = root;
		TreeNode<Integer> prev = root;
		
		if(!find(val))
			throw new NoSuchElementException("Value in the tree.");
		else
		{		
			// find the node to delete
			while(curr.getValue() != val)
			{
				// update previous node
				prev = curr;

				// update current node
				if(curr.getValue() < val)
					curr = curr.rightChild();
				else
					curr = curr.leftChild();
			}

			// deal with the case of having less than two children
			if(curr.hasLeft() == false)
			{
				if(prev.leftChild() == curr)
					prev.setLeft(curr.rightChild());
				else
					prev.setRight(curr.rightChild());
			}
			else if(curr.hasRight() == false)
			{
				if(prev.leftChild() == curr)
					prev.setLeft(curr.leftChild());
				else
					prev.setRight(curr.leftChild());
			}
			// has two children
			else
			{
				curr.setValue(min(curr.rightChild()));
				deleteMin(curr.rightChild());			
			}
	
		}
	}


	/** Deletes the minimum of the subtree with this node as the root.*/
	private void deleteMin(TreeNode<Integer> curr)
	{	
		TreeNode<Integer> prev = curr;
		while(curr.hasLeft() == true)
		{
			prev = curr;
			curr = curr.leftChild();
		}
		// now have parent node point to the right child.
		prev.setLeft(curr.rightChild());
	}


	/** Return the minimum of the subtree with this node as the root.*/
	private int min(TreeNode<Integer> curr)
	{
		while(curr.hasLeft() == true)
			curr = curr.leftChild();	
		
		return curr.getValue();
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

	/** Returns a boolean if the val is found in the tree.*/
	public boolean find(int x)
	{
		TreeNode<Integer> curr = root;
		while(curr != null)
		{	
			if(curr.getValue() > x)
				curr = curr.leftChild();

			else if(curr.getValue() < x)
				curr = curr.rightChild();
	
			else
				return true;
		}	
		return false;
	}

	/** Prints the tree in pre-order.*/
	public void preOrder()
	{	
		if(root == null)
			throw new IllegalStateException("Empty tree.");
 
		Stack<TreeNode<Integer>> stack = 
														new Stack<TreeNode<Integer>>();
	
		TreeNode<Integer> curr = root;
		// go down the left side of the tree
		while(curr != null)
		{
			stack.push(curr);
			System.out.print(curr.getValue() + " ");
			curr = curr.leftChild();
		}
		while(!stack.isEmpty())
		{
			// pop and print this node.
			curr = stack.pop();
			curr = curr.rightChild();
			
			// go down the left side of the right childs subtree
			while(curr != null)
			{
				System.out.print(curr.getValue() + " ");
				stack.push(curr);
				curr = curr.leftChild();
			}
		}
		System.out.println();
	}

	/** Prints the tree in in-order.*/
	public void inOrder()
	{
		if(root == null)
			throw new IllegalStateException("Empty tree.");
 
		Stack<TreeNode<Integer>> stack = 
														new Stack<TreeNode<Integer>>();
	
		TreeNode<Integer> curr = root;
		// go down the left side of the tree
		while(curr != null)
		{
			stack.push(curr);
			curr = curr.leftChild();
		}	
		while(!stack.isEmpty())
		{
			// pop and print this node.
			curr = stack.pop();
			System.out.print(curr.getValue() + " ");
			curr = curr.rightChild();
			// go down the left side of the right childs subtree
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.leftChild();
			}
		}
		System.out.println();
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
		BinSearchTree_Iterative tree =
										 new BinSearchTree_Iterative();

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
		System.out.println("Removing 5");
		tree.delete(5);
		System.out.print("InOrder Traversal: ");
		tree.inOrder();
	
		
	}	

}
