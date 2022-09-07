import java.util.Scanner;

public class IdenticalTrees {

	public static void main(String[] args) {
		Node root1=null;
		Node root2=null;
		//creating a Tree
		root1=buildTree(root1);
		System.out.println("For second tree");
		root2=buildTree(root2);
		System.out.println("Are the trees identical?  "+isIdentical(root1, root2));
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
	
	static boolean isIdentical(Node r1,Node r2) {
		if(r1==null&&r2==null) {
			return true;
		}
		if(r1==null&&r2!=null) {
			return false;
		}
		if(r1!=null&&r2==null) {
			return false;
		}
		
		boolean leftTree=isIdentical(r1.left,r2.left);
		boolean rightTree=isIdentical(r1.right,r2.right);
		boolean current=(r1.data==r2.data)?true:false;
		boolean ans=leftTree&&rightTree&&current;
		return ans;
		
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