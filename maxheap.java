// import java.util.Scanner;
// import java.io.Serializable;
// import java.util.*;
//
//
// // Java program to implement Max Heap\
//
// public class MaxHeap implements Serializable {
//     private int[] Heap;
//     private int size;
//     private int maxsize;
//     private int swapcount = 0;
//     private int userswapcount = 0;
//
//     // Constructor to initialize an
//     // empty max heap with given maximum
//     // capacity.
//     public MaxHeap(int maxsize)
//     {
//         this.maxsize = maxsize;
//         this.size = 0;
//         Heap = new int[this.maxsize + 1];
//         Heap[0] = Integer.MAX_VALUE;
//     }
//
//     // Returns position of parent
//     private int parent(int pos)
//     {
//         return pos / 2;
//     }
//
//     // Below two functions return left and
//     // right children.
//     private int leftChild(int pos)
//     {
//         return (2 * pos);
//     }
//     private int rightChild(int pos)
//     {
//         return (2 * pos) + 1;
//     }
//
//     // Returns true of given node is leaf
//     private boolean isLeaf(int pos)
//     {
//         if (pos >= (size / 2) && pos <= size) {
//             return true;
//         }
//         return false;
//     }
//
//     private void swap(int fpos, int spos)
//     {
//         int tmp;
//         tmp = Heap[fpos];
//         Heap[fpos] = Heap[spos];
//         Heap[spos] = tmp;
//         swapcount += 1;
//     }
//
//     // A recursive function to max heapify the given
//     // subtree. This function assumes that the left and
//     // right subtrees are already heapified, we only need
//     // to fix the root.
//     private void maxHeapify(int pos)
//     {
//         if (isLeaf(pos))
//             return;
//
//         if (Heap[pos] < Heap[leftChild(pos)] ||
//             Heap[pos] < Heap[rightChild(pos)]) {
//
//             if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
//                 swap(pos, leftChild(pos));
//                 maxHeapify(leftChild(pos));
//             }
//             else {
//                 swap(pos, rightChild(pos));
//                 maxHeapify(rightChild(pos));
//             }
//         }
//     }
//
//     // Inserts a new element to max heap
//     public void insert(int element)
//     {
//         Heap[++size] = element;
//
//         // Traverse up and fix violated property
//         int current = size;
//         while (Heap[current] > Heap[parent(current)]) {
//             swap(current, parent(current));
//             current = parent(current);
//         }
//     }
//
//     public void print()
//     {
//         for (int i = 0; i < size; i++) {
//             System.out.println(Heap[i]);
//         }
//     }
//
//     public void arrayprint(int[] a)
//     {
//       for (int i = 0; i < a.length; i++) {
//         System.out.println(a[i]);
//       }
//     }
//
//     // Remove an element from max heap
//     public int extractMax()
//     {
//         int popped = Heap[1];
//         Heap[1] = Heap[size--];
//         maxHeapify(1);
//         return popped;
//     }
//
//     public static void main(String[] arg)
//     {
//         int[] alpha;
//         Scanner diff_input = new Scanner(System.in);
//         System.out.println("Enter difficulty setting (0 for easy, 1 for med, 2 for hard)");
//         int difficulty = diff_input.nextInt();
//         //take some user input for difficulty here
//
//         if (difficulty == 0){
//           int[] unsolved = new int[7];
//           //Generates 7 Random Numbers in the range 1 -20
//           for(int i = 0; i < unsolved.length; i++) {
//             unsolved[i] = (int)(Math.random()*100 + 1);
//           }
//           //preserve unsolved and work with unsolved
//           System.out.println("Generating solved maxheap ");
//           MaxHeap solved = new MaxHeap(7);
//           for(int i = 0; i < unsolved.length; i++){
//             solved.insert(unsolved[i]);
//           }
//           for (int i = 0; i < unsolved.length; i++){
//             alpha[i] = Heap[i];
//           }
//
//
//           while(true){
//             if (Arrays.equals(Heap, unsolved)){
//                 break;
//             }
//             //scanning for user method inputs
//             //desperation section: we run the entire thing in a single java file because fuck javascript, fuck html, and fuck this, nobody knows this shit
//             //the ghetto method
//             Scanner alpha_input = new Scanner(System.in);
//             System.out.println("Enter index of node to swap");
//             Int alpha = alpha_input.nextInt();
//             Scanner beta_input = new Scanner(System.in);
//             System.out.println("Enter swap target (0 for parent, 1 for left child, 2 for right child)");
//             Int beta = beta_input.nextInt();
//             if(beta == 0){
//               Collections.swap(unsolved, alpha, parent(alpha));
//               userswapcount = userswapcount + 1;
//             }
//             else if(beta == 1){
//               Collections.swap(unsolved, alpha, leftChild(alpha));
//               userswapcount = userswapcount + 1;
//             }
//             else if(beta == 2){
//               Collections.swap(unsolved, alpha, rightChild(alpha));
//               userswapcount = userswapcount + 1;
//             }
//
//           }
//           maxHeap.print();
//         }
//         else if (difficulty == 1){
//           int[] unsolved = new int[15];
//           //Generates 7 Random Numbers in the range 1 -20
//           for(int i = 0; i < unsolved.length; i++) {
//           unsolved[i] = (int)(Math.random()*100 + 1);
//           }
//           //preserve unsolved and work with unsolved
//           System.out.println("Generating solved maxheap ");
//           MaxHeap solved = new MaxHeap(15);
//           for(int i = 0; i < unsolved.length; i++){
//             solved.insert(unsolved[i]);
//           }
//
//           while(1){
//             if (Arrays.equals(Heap, unsolved)){
//               break;
//             }
//             //scanning for user method inputs
//           }
//           maxHeap.print();
//
//         }
//
//         else if (difficulty == 2){
//           int[] unsolved = new int[31];
//           //Generates 7 Random Numbers in the range 1 -20
//           for(int i = 0; i < unsolved.length; i++) {
//           unsolved[i] = (int)(Math.random()*100 + 1);
//           }
//           //preserve unsolved and work with unsolved
//           System.out.println("Generating solved maxheap ");
//           MaxHeap solved = new MaxHeap(31);
//           for(int i = 0; i < unsolved.length; i++){
//             solved.insert(unsolved[i]);
//           }
//
//           while(1){
//             if (Arrays.equals(Heap, unsolved)){
//               break;
//             }
//             //scanning for user method inputs
//           }
//           maxHeap.print();
//
//         }
//     }
// }
import java.util.Scanner;
import java.util.Arrays;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    private int swapcallcount = 0;


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
        System.out.println();
        System.out.println("Ideal Swap Count is: " + swapcallcount);
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
      int userswapmax;
      Scanner diffinput = new Scanner(System.in);
      int difficulty = diffinput.nextInt();
      if (difficulty == 0){
        userswapmax = 10;
      }
      else if(difficulty == 1){
        userswapmax = 5;
      }
      else if(difficulty == 2){
        userswapmax = 1;
      }
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
        System.out.println("The Max Heap is ");

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
    }
}
