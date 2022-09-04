import java.util.Scanner;

public class MirrorTree {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		System.out.println(isSymmetric(root));
		
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
	static boolean isSymmetric(Node root) {
		if(root==null)
			return true;
		return checkMirror(root.left,root.right);
	}
	
	static boolean checkMirror(Node root1,Node root2) {
		//base case
		if(root1==null&&root2==null)
			return true;
		if(root1==null&&root2!=null)
			return false;
		if(root1!=null&&root2==null)
			return false;			
		if(root1.data!=root2.data)
			return false;
		
		
		//Recursive calls
		boolean ans1=checkMirror(root1.left,root2.right);
		boolean ans2=checkMirror(root1.right,root2.left);
		boolean ans=ans1 && ans2;
		return ans;
	}
}
