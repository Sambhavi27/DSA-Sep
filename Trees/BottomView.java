import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class BottomView {

	public static void main(String[] args) {
		Node root=null;
		//creating a Tree
		root=buildTree(root);
		ArrayList<Integer> result=bottomView(root);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
	}
    static ArrayList<Integer> bottomView(Node root)
    {
    	Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair cur=q.poll();
           
            map.put(cur.hd,cur.node.data);
            
            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
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