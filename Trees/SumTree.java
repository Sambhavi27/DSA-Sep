import java.util.Scanner;

public class SumTree {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		int ans=isSumTree(root);
		if(isLeaf(root)==1||ans!=-1&&ans==2*root.data) {
			System.out.println("the tree is sumtree");
		}
		else
		System.out.println("the tree is not sumtree");
		
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
	
	
	static int isSumTree(Node root) {
		
		if(root==null) {
			return 0 ;
		}
		int leftTree=isSumTree(root.left);
		if(leftTree==-1)
			return -1;
		int rightTree=isSumTree(root.right);
		if(rightTree==-1)
			return -1;
		if(isLeaf(root)==1 ||root.data==(leftTree+rightTree))
			return leftTree+rightTree+root.data;
		else
			return -1;
		
	}
	static int isLeaf(Node node)
	{
	    if(node == null)
	        return 0;
	    if(node.left == null && node.right == null)
	        return 1;
	    return 0;
	}
}
