import java.util.Scanner;

public class CountLeafNodes {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
	    //Leaf nodes
	    int leaves=countTotalLeafNodes(root);
	    System.out.println("Total Number of Leaf nodes are "+leaves);
	}
	
	private static int countTotalLeafNodes(Node root) {
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null) {
			return 1;
		}
		int leftcount=countTotalLeafNodes(root.left);
		int rightcount=countTotalLeafNodes(root.right);
		int total=leftcount+rightcount;
		return total;
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