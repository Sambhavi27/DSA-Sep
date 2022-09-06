import java.util.Scanner;

public class DiameterOfTree {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		System.out.println("Diameter( using height function) = "+diameter(root));
		System.out.println("Diameter(without using height function) = "+diameterFast(root));
		
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
	
	static int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int op1=diameter(root.left);
		int op2=diameter(root.right);
		int op3=height(root.left)+height(root.right)+1;
		int ans=Math.max(op1,Math.max(op2, op3));
		return ans;
		
	}
	static int diameterFast(Node root) {
		int result[]=solve(root);
		return result[0];
	}
	static int[] solve(Node root) {
		if(root==null) {
			int arr[]= {0,0};
			return arr ;
		}
		int leftdiameter[]=solve(root.left);
		int rightdiameter[]=solve(root.right);
		int op1=leftdiameter[0];
		int op2=rightdiameter[0];
		int op3=leftdiameter[1]+rightdiameter[1]+1;
		int ans[]= {0,0};
		ans[0]=Math.max(op1,Math.max(op2, op3));
		ans[1]=Math.max(leftdiameter[1],rightdiameter[1])+1;
		return ans;
		
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