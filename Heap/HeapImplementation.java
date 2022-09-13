
public class HeapImplementation {

	static int a[]=new int[100];
	static int size=0;
	void insert(int data) {
		size=size+1;
		a[size]=data;
		int index=size;
		while(index>1) {
			int parent=index/2;
			if(a[parent]<a[index]) {
				int temp=a[parent];
				a[parent]=a[index];
				a[index]=temp;
				index=parent;
			}
			else {
				return;
			}
		}
	}
	void delete() {
		if(size==0) {
			System.out.println("No Element to delete");
			return;
		}
		a[1]=a[size];
		size=size-1;
		int index=1;
		while(index<size) {
			int left=2*index;
			int right=2*index+1;
			if(left<size&&a[index]<a[left])
			 {
				int temp=a[index];
				a[index]=a[left];
				a[left]=temp;
				index=left;
			}
			else if(right<size&&a[index]<a[right])
			 {
				int temp=a[index];
				a[index]=a[right];
				a[right]=temp;
				index=right;
			}
			else {
				return;
			}
			
		}
		
	}
	static void heapify(int[] a,int n,int i) {
		int largest=i;
		int left=2*i;
		int right=2*i+1;
		if(left<n &&a[largest]<a[left]) {
			largest=left;
		}
		if(right<n &&a[largest]<a[right]) {
			largest=right;
		}
		if(largest!=i) {
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapify(a,n,largest);
		}
	}
	public static void main(String[] args) {
		HeapImplementation heap=new HeapImplementation();
		heap.insert(50);
		heap.insert(30);
		heap.insert(40);
		heap.insert(10);
		heap.insert(5);
		heap.insert(20);
		heap.insert(30);
		heap.insert(60);
		System.out.println("Heap is:");
		for(int i=1;i<=size;i++) {
			System.out.print(a[i]+" ");
		}
		heap.delete();
		System.out.println();
		System.out.println("After Deletion");
		for(int i=1;i<=size;i++) {
			System.out.print(a[i]+ " ");
		}
		
		//Heapify
		int arr[]= {-1,54,55,53,52,50};
		int len=5;
		for(int i=len/2;i>0;i--) {
			heapify(arr,len,i);
		}
		System.out.println();
		System.out.println("After heapify");
		for(int i=1;i<=len;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
