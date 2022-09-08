import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoundaryTraversal {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=boundary(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}
	
	static ArrayList<Integer> boundary(Node root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		res.add(root.data);
		//1-LeftPart
		traverseLeft(root.left,res);
		
		//2-LeafNodes
		//leftSubTree
		traverseLeafNodes(root.left,res);
		
		//RightSubTree
		traverseLeafNodes(root.right,res);
		
		//3-RightPart
		traverseRight(root.right,res);
		
		return res;
	}
	
	
	
	private static void traverseRight(Node root, ArrayList<Integer> res) {
		if(root==null || root.left==null&&root.right==null) {
			return;
		}
		if(root.right!=null) {
			traverseRight(root.right, res);
		}
		else
			traverseRight(root.left, res);
		//Returning
		res.add(root.data);
			
	}

	private static void traverseLeafNodes(Node root, ArrayList<Integer> res) {
		if(root==null) {
			return;
		}
		if(root.left==null&&root.right==null) {
			res.add(root.data);
			return;
		}
			traverseLeafNodes(root.left, res);
			traverseLeafNodes(root.right, res);
		
	}

	private static void traverseLeft(Node root, ArrayList<Integer> res) {
		if(root==null || root.left==null&&root.right==null) {
			return;
		}
		res.add(root.data);
		if(root.left!=null) {
			traverseLeft(root.left, res);
		}
		else
			traverseLeft(root.right, res);
		
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