import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=verticalOrder(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}

	static ArrayList <Integer> verticalOrder(Node root)
    {
       Queue<Pair> q=new ArrayDeque<Pair>();
       Map<Integer,ArrayList<Integer>> map=new TreeMap<Integer,ArrayList<Integer>>();
       
       q.add(new Pair(0,root));
       
       while(!q.isEmpty()){
           Pair cur=q.poll();
           if(map.containsKey(cur.hd)){
               map.get(cur.hd).add(cur.node.data);
           }
           else{
               ArrayList<Integer> temp=new ArrayList<>();
               temp.add(cur.node.data);
               map.put(cur.hd,temp);
           }
           if(cur.node.left!=null){
               q.add(new Pair(cur.hd-1,cur.node.left));
           }
           if(cur.node.right!=null){
               q.add(new Pair(cur.hd+1,cur.node.right));
           }
       }
       ArrayList<Integer> ans=new ArrayList<>();
       for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
           ans.addAll(entry.getValue());
       }
       return ans;
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