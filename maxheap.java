import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;


public class MaxHeap {
    private static int[] Heap;
    private int size;
    private int maxsize;
    private static int swapcallcount = 0;


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
        swapcallcount = swapcallcount + 1;
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
            System.out.print(Heap[i]);
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

    public static void array_swap(int[] arr, int index1, int index2){
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
    }

    //heap verification for winner
    static boolean isHeap(int arr[], int i, int n) {
      // If a leaf node
        System.out.println("Debug Line: checking for heap status");
        if (i > (n - 2) / 2) {
            return true;
        }

    // If an internal node and is greater than its children, and
    // same is recursively true for the children
        if (arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2]
                && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n)) {
            return true;
        }

        return false;
    }
    public static void ghettoprint(int[] randint){
      System.out.println("Debug - Ghetto Print ");

      for (int i = 0; i < randint.length; i++) {
        System.out.print(randint[i]);
        System.out.println();
      }
    }


    public static void main(String[] arg)
    {
      int userswapmax;
      userswapmax = 0;

      int useractions;
      useractions = 0;

      int[] randint = new int[15];
      int arrlen = randint.length;
      //Generates 15 Random Numbers in the range 1 -100
      for(int i = 0; i < arrlen; i++) {
        randint[i] = (int)(Math.random()*100 + 1);
      }
      MaxHeap maxHeap = new MaxHeap(15);
      for(int i = 0; i < arrlen; i++) {
        maxHeap.insert(randint[i]);
      }
        System.out.println("Debug - The Max Heap is ");

        maxHeap.print();

        System.out.println();
        System.out.println("Debug - Ideal Swap Count is: " + swapcallcount);
        System.out.println("Randomized array, shouldn't make sense");

        ghettoprint(randint);

        //Needs to be replaced by game input
        Scanner diffinput = new Scanner(System.in);
        System.out.println("Difficulty setting inputs, 0 for 10, 1 for 5, 2 for 1");
        int difficulty = diffinput.nextInt();
        if (difficulty == 0){
          userswapmax = 10 + swapcallcount;
        }
        else if(difficulty == 1){
          userswapmax = 5 + swapcallcount;
        }
        else if(difficulty == 2){
          userswapmax = 1+swapcallcount;
        }
        System.out.println("Debug - Max Actions Permitted (not currently active): " + userswapmax);
        double wpc;
        wpc = 15.0 - Math.ceil(Math.log(15.0));
        System.out.println("Debug - Worst Possible Case: " + wpc);

        while(true){
        //   //game loop basically
        //   //scan for selection input, pass to alpha and beta respectively
           Scanner alpha = new Scanner(System.in);
           System.out.println("Enter swap index alpha (or type 40 to debug exit)");
           int alpha1 = alpha.nextInt();
           //debug exit so i don't have to keep restarting terminal
           if(alpha1 == 40){
             return;
           }
           Scanner beta = new Scanner(System.in);
           System.out.println("Enter swap index beta");
           int beta1 = beta.nextInt();
           array_swap(randint, alpha1, beta1);

           ghettoprint(randint);
        //   ++useractions;
          if (isHeap(randint, 0, randint.length-1)){
            System.out.println("A winrar is you!");
            return;
          }
        //   //if useractions exceceds userswapmax, you lose
        }
    }
}
