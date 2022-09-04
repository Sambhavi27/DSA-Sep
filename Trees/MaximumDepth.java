import java.util.Scanner;

public class MaximumDepth {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		System.out.println(maxDepth(root));
		
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
	static int maxDepth(Node root) {
		if(root==null)
			return 0;
		int leftLength=maxDepth(root.left);
		int rightLength=maxDepth(root.right);
		int finalLength=1+Math.max(leftLength, rightLength);
		return finalLength;
	}
}
