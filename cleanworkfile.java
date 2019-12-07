import java.util.Scanner;

// Java program to implement Max Heap\

public class cleanworkfile {
    private int[] Heap;
    private int size;
    private int maxsize;
    public int swapcount = 0;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity.
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // Returns position of parent
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Below two functions return left and
    // right children.
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Returns true of given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
        swapcount += 1;
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] ||
            Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Inserts a new element to max heap
    public void insert(int element)
    {
        Heap[++size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size; i++) {
            System.out.println(Heap[i]);
        }
    }

    // Remove an element from max heap
    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] arg)
    {
        Scanner diff_input = new Scanner(System.in);
        System.out.println("Enter difficulty setting (0 for easy, 1 for med, 2 for hard)");
        Int difficulty = diff_input.nextLine();
        //take some user input for difficulty here
        if (difficulty == 0){
          int[] unsolved = new int[7];
          //Generates 7 Random Numbers in the range 1 -20
          for(int i = 0; i < unsolved.length; i++) {
            unsolved[i] = (int)(Math.random()*100 + 1);
          }
          //preserve unsolved and work with unsolved
          System.out.println("Generating solved maxheap ");
          MaxHeap solved = new MaxHeap(7);
          for(i = 0; i < unsolved.length; i++){
            solved.insert(unsolved[i]);
          }
          int[] alpha;
          for(i = 0; i < unsolved.length; i++){
            alpha.insert(solved[i]);
          }
          while(1){
            if (Arrays.equals(alpha, unsolved)){
              break;
            }
          }
          maxHeap.print();
        }
        else if (difficulty == 1){
          int[] unsolved = new int[15];
          //Generates 7 Random Numbers in the range 1 -20
          for(int i = 0; i < unsolved.length; i++) {
          unsolved[i] = (int)(Math.random()*100 + 1);
          }
          //preserve unsolved and work with unsolved
          System.out.println("Generating solved maxheap ");
          MaxHeap solved = new MaxHeap(15);
          for(i = 0; i < unsolved.length; i++){
            solved.insert(unsolved[i]);
          }

          maxHeap.print();

        }
        else if (difficulty == 2){
          int[] unsolved = new int[31];
          //Generates 7 Random Numbers in the range 1 -20
          for(int i = 0; i < unsolved.length; i++) {
          unsolved[i] = (int)(Math.random()*100 + 1);
          }
          //preserve unsolved and work with unsolved
          System.out.println("Generating solved maxheap ");
          MaxHeap solved = new MaxHeap(31);
          for(i = 0; i < unsolved.length; i++){
            solved.insert(unsolved[i]);
          }

          maxHeap.print();

        }
    }
}
