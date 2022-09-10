import java.util.ArrayList;
import java.util.Scanner;

public class RightView {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=rightView(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}
    static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        rightViewUtil(root,list,0);
        return list;
      }
      
     static ArrayList<Integer> rightViewUtil(Node root,ArrayList<Integer> list,int level){
          if(root==null)
              return list;
              
          if(list.size()==level){
              list.add(root.data);
          }
          rightViewUtil(root.right,list,level+1);
          rightViewUtil(root.left,list,level+1);
          return list;
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
class Pair{
    int hd;
    Node node;
    
    public Pair(int hd,Node node){
        this.hd=hd;
        this.node=node;
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