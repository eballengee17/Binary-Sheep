// Java program to implement Max Heap
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

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
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
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
        int difficulty;
        int treeSize;

        if (difficulty == 0){
          treesize = 7;
        }
        else if(difficulty == 1){
          treesize = 15;
        }
        else if(difficulty == 2){
          treesize = 31;
        }
        int maxR = 100;
        int minR= 1;
        int rangeR = maxR - minR + 1;

        int[] randomgen = new int[treeSize];
        System.out.println("Generated random size 15 max heap");
        for (int i = 0; i < treeSize; i++) {
          randomgen[i] = (int)(Math.random() * rangeR) + minR;
        }
        MaxHeap maxHeap = new MaxHeap(treeSize);
        for (int j = 0; j < treeSize ; j++) {
          maxHeap.insert(randomgen[j]);
        }
        //can now use randomgen as our scrambled list
        //left arrow --> left child
        //right arrow --> right child
        //up arrow --> parent
        int selectionvar = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Debug statement: Searching for arrow inputs");
        // while(1) {
        //   char input = System.console().readLine();
        //   if() //input is up {
        //     selectionvar = parent(selectionvar);
        //   }
        //   else if() { //input is right
        //     selectionvar = rightChild(selectionvar)
        //   }
        //   else if () { //input is left
        //     selectionvar = leftChild(selectionvar)
        //   }
        //   else if () { //selected
        //     alpha = selectionvar;
        //   }
        //
        // }
        maxHeap.print();


    }
}
