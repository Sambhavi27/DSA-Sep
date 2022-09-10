import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=inputData(root);
		
		System.out.println("Printing the level order traversal");
		levelOrderTraversal(root);
		System.out.println();
		System.out.println("Printing the inorder traversal");
	    inorder(root);
	    System.out.println();
	    System.out.println("Printing the preorder traversal");
	    preorder(root);
	    System.out.println();
	    System.out.println("Printing the postorder traversal");
	    postorder(root);
	    
	    System.out.println("Min "+minNode(root).data);
	    System.out.println("Max "+maxNode(root).data);
	    
	    System.out.println("Enter data to delete");
	    Node del=deleteFromBST(root,50);
	    System.out.println("Printing the level order traversal");
		levelOrderTraversal(root);
	}
	
	static Node deleteFromBST(Node root,int val) {
		if(root==null) {
			return root;
		}
		if(root.data==val) {
			//0 Child
			if(root.left==null&&root.right==null) {
				root=null;
				return root;
			}
			//1 Child
			if(root.left!=null&&root.right==null) {
				return root.left;
			}
			if(root.left==null&&root.right!=null) {
				return root.right;
				
			}
			//2 Child
			if(root.left!=null&&root.right!=null) {
				int mini=minNode(root.right).data;
				root.data=mini;
				root.right=deleteFromBST(root.right, mini);
				return root;
			}
			
		}
		else if(root.data>val) {
			root.left=deleteFromBST(root.left,val);
			return root;
		}
		else {
			root.right=deleteFromBST(root.right,val);
			return root;
		}
		return root;
	}
	static Node minNode(Node root) {
		Node temp=root;
		while(temp.left!=null) {
			temp=temp.left;
		}
		return temp;
	}
	static Node maxNode(Node root) {
		Node temp=root;
		while(temp.right!=null) {
			temp=temp.right;
		}
		return temp;
	}
	static Node inputData(Node root) {
		System.out.println("Input data");
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		while(data!=-1) {
			root=buildBST(root,data);
			data=sc.nextInt();
		}
		return root;
	}

	private static Node buildBST(Node root, int data) {
		if(root==null) {
			root = new Node(data);
			return root;
		}
		if(data>root.data) {
			root.right=buildBST(root.right, data);
		}
		else
			root.left=buildBST(root.left, data);
		return root;
	}
	
	static void levelOrderTraversal(Node root) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node temp=q.peek();
			q.poll();
			if(temp==null) {
				System.out.println();
				if(!q.isEmpty())
					q.add(null);
			}
			else {
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
		}
	}
	static void inorder(Node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	static void preorder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static void postorder(Node root) {
		if(root==null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
		
	}
	
}
