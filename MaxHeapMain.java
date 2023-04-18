// Brandon Gurley
// CSC 258
// 
// Java program to implement Max Heap

// Main class
public class MaxHeapMain {
	static class MaxHeap {
		//variable declaration
		private int[] Heap;
		private int size;
		private int maxsize;
		
		public MaxHeap(int size) {
			this.maxsize = size;
			this.size= 0;
			Heap = new int[this.maxsize + 1];
			Heap[0] = Integer.MAX_VALUE;
		}
		
		// different types of elements
		private int parent(int pos)
		{
			return pos/2;
		}
		private int leftChild(int pos)
		{
			return (pos*2);
		}
		private int rightChild(int pos)
		{
			return (pos*2)+1;
		}
		
		
		// swap function
		private void swap(int fpos, int spos)
		{
			int tmp;
			tmp = Heap[fpos];
			Heap[fpos] = Heap[spos];
			Heap[spos] = tmp;
		}
		
		// In Order to move from the root to the leaf nodes
		private void downHeapify(int pos)
		{
			// check if leaf node
			if ( pos >= (size/2) && pos <= size)
					return;
			
			// check if neccessary to swap
			if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)])
			{
				
				// swaps parent with max of left and right children
				if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) 
				{
					swap(pos, leftChild(pos));
					
					// heapify called on child nodes
					downHeapify(leftChild(pos));
				}
				// heapify called on child nodes
				else
				{
					swap(pos, rightChild(pos));
					downHeapify(rightChild(pos));
				}
			}
		}
		
		// In Order to traverse from the bottom up (opposite of downHeapify)
		public void heapifyUp(int pos)
		{
			int temp = Heap[pos];
			while(pos>0 && temp > Heap[parent(pos)])
			{
				Heap[pos] = Heap[parent(pos)];
				pos = parent(pos);
			}
			Heap[pos] = temp;
		}
		
		// Function to insert elements into The Heap
		public void insert(int element)
		{
			Heap[++size] = element;
			int current = size;
			heapifyUp(current);
		}
		
		// Function to Print The Heap
		public void print () 
		{
			for (int i = 1; i <= size/2; i++)
			{
				System.out.print(+ Heap[i] +": Left - " + Heap[2*i] + " Right - " + Heap[2*i+1]);
				System.out.println();
			}
		}
		public int extractMax() 
		{
			int max = Heap[1];
			Heap[1] = Heap[size--];
			downHeapify(1);
			return max;
		}
	}
	// Main Function
	public static void main(String[] arg)
	{
		MaxHeap maxHeap = new MaxHeap(14);
		maxHeap.insert(1);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(6);
		maxHeap.insert(14);
		maxHeap.insert(7);
		
		maxHeap.print();
		System.out.println("The MaxHeap Is......  " + maxHeap.extractMax());
	
	
	
	
	}
}	