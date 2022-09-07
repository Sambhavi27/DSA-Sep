import java.util.Scanner;

public class BalancedTree {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		System.out.println("Is the tree balanced?  "+isBalanced(root));
		if(isBalancedFast(root)>0) {
			System.out.println("the tree is balanced");
		}
		else
		System.out.println("the tree is not balanced");
		
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
	
	static boolean isBalanced(Node root) {
		if(root==null) {
			return true;
		}
		boolean leftTree=isBalanced(root.left);
		boolean rightTree=isBalanced(root.right);
		boolean difference=(Math.abs(height(root.left)-height(root.right))<=1)?true:false;
		boolean ans=leftTree&&rightTree&&difference;
		return ans;
		
	}
	static int isBalancedFast(Node root) {
		
		if(root==null) {
			return 0 ;
		}
		int leftTree=isBalancedFast(root.left);
		if(leftTree==-1)
			return -1;
		int rightTree=isBalancedFast(root.right);
		if(rightTree==-1)
			return -1;
		if(Math.abs(leftTree-rightTree)>1)
			return -1;
		else
			return Math.max(leftTree, rightTree)+1;
		
	}
	static int height(Node root) {
		if(root==null)
			return 0;
		int leftLength=height(root.left);
		int rightLength=height(root.right);
		int finalLength=1+Math.max(leftLength, rightLength);
		return finalLength;
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