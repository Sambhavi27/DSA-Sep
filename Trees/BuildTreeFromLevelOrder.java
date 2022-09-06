import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildTreeFromLevelOrder {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
	}

	static Node buildTree(Node root) {
		Queue<Node> q=new LinkedList<Node>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data");
		int data=sc.nextInt();
		root=new Node(data);
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.peek();
			q.poll();
			System.out.println("Enter data for left node");
			int leftData=sc.nextInt();
			if(leftData!=-1) {
				temp.left=new Node(leftData);
				q.add(temp.left);
			}
			System.out.println("Enter data for right node");
			int rightData=sc.nextInt();
			if(rightData!=-1) {
				temp.right=new Node(rightData);
				q.add(temp.right);
			}
		}
		
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