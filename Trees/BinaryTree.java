import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		//level order
		System.out.println("Printing the level order traversal");
		levelOrderTraversal(root);
	    //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1 
		System.out.println("Printing the inorder traversal");
	    inorder(root);
	    System.out.println("Printing the preorder traversal");
	    preorder(root);
	    System.out.println("Printing the postorder traversal");
	    postorder(root);
	}
	
	static Node buildTree(Node root) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data");
		int data=sc.nextInt();
		root=new Node(data);
		if(data==-1)
			return null;
		System.out.println("Enter data for left node");
		root.left=buildTree(root.left);
		System.out.println("Enter data for right node");
		root.right=buildTree(root.right);
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

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int value){
		this.data=value;
		this.left=null;
		this.right=null;
	}
}