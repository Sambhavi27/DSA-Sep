import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ZigZagTraversal {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=zigZag(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}
	
	static ArrayList<Integer> zigZag(Node root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		boolean leftToRight=true;
		while(!q.isEmpty()) {
			int size=q.size();
			int ans[]=new int[size];
			for(int i=0;i<size;i++) {
				Node front=q.peek();
				q.poll();
			
				int index=leftToRight?i:size-i-1;
				
				ans[index]=front.data;
				
				if(front.left!=null) {
					q.add(front.left);
				}
				if(front.right!=null) {
					q.add(front.right);
				}
				
			}
			leftToRight=!leftToRight;
			for(int j=0;j<size;j++) {
				res.add(ans[j]);
			}
		}
		return res;
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
