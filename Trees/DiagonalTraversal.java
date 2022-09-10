import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiagonalTraversal {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=diagonal(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}
	public static ArrayList<Integer> diagonal(Node root)
    {
         Queue<Node> q=new LinkedList<Node>();
         ArrayList<Integer> diagonal=new ArrayList<>();
         if(root == null)return diagonal;
         q.add(root);
         
         while(!q.isEmpty()){
             Node temp=q.poll();
             while(temp!=null){
                 if(temp.left!=null)
                      q.add(temp.left);
                  diagonal.add(temp.data);
                  temp=temp.right;
             }
             
         }
         return diagonal;
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
