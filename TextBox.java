import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class TextBox extends JFrame{

  private static final long serialVersionUID = 42l;

  JPanel jp = new JPanel();
  JLabel jl = new JLabel();
  JTextField jt1 = new JTextField(2);
  JTextField jt2 = new JTextField(2);
  JButton jb = new JButton("Enter");

  int alpha;
  int beta;
  int charlie;
  int swapcallmax = 12;
  // double wpc = 0.0;
  // wpc = 15.0 - Math.ceil(Math.log(15.0));
  int swapcallcount = 0;

  // public static void array_swap(int[] arr, int index1, int index2, Handler handler){
  public static void array_swap(int[] arr, int index1, int index2){

    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;

    // handler.removeObject(sheep0);
    // handler.removeObject(sheep1);
    // handler.removeObject(sheep2);
    // handler.removeObject(sheep3);
    // handler.removeObject(sheep4);
    // handler.removeObject(sheep5);
    // handler.removeObject(sheep6);
    // handler.removeObject(sheep7);
    // handler.removeObject(sheep8);
    // handler.removeObject(sheep9);
    // handler.removeObject(sheep10);
    // handler.removeObject(sheep11);
    // handler.removeObject(sheep12);
    // handler.removeObject(sheep13);
    // handler.removeObject(sheep14);
    //add 15 Sheep
    //layer 1
    // Sheep sheep0 = new Sheep(600, 50, ID.Sheep, 0, sheepHeap[0]);
    // handler.addObject(sheep0);
    //
    // //layer 2
    // Sheep sheep1 = new Sheep(300, 200, ID.Sheep, 1, sheepHeap[1]);
    // Sheep sheep2 = new Sheep(900, 200, ID.Sheep, 2, sheepHeap[2]);
    // handler.addObject(sheep1);
    // handler.addObject(sheep2);
    //
    // //layer 3
    // Sheep sheep3 = new Sheep(150,350, ID.Sheep, 3, sheepHeap[3]);
    // Sheep sheep4 = new Sheep(450,350, ID.Sheep, 4, sheepHeap[4]);
    // Sheep sheep5 = new Sheep(750,350, ID.Sheep, 5, sheepHeap[5]);
    // Sheep sheep6 = new Sheep(1050,350, ID.Sheep, 6, sheepHeap[6]);
    // handler.addObject(sheep3);
    // handler.addObject(sheep4);
    // handler.addObject(sheep5);
    // handler.addObject(sheep6);
    //
    // //layer 4
    // Sheep sheep7 = new Sheep(75,500, ID.Sheep, 7, sheepHeap[7]);
    // Sheep sheep8 = new Sheep(225,500, ID.Sheep, 8, sheepHeap[8]);
    // Sheep sheep9 = new Sheep(375,500, ID.Sheep, 9, sheepHeap[9]);
    // Sheep sheep10 = new Sheep(525,500, ID.Sheep, 10, sheepHeap[10]);
    // Sheep sheep11 = new Sheep(675,500, ID.Sheep, 11, sheepHeap[11]);
    // Sheep sheep12 = new Sheep(825,500, ID.Sheep, 12, sheepHeap[12]);
    // Sheep sheep13 = new Sheep(985,500, ID.Sheep, 13, sheepHeap[13]);
    // Sheep sheep14 = new Sheep(1135,500, ID.Sheep, 14, sheepHeap[14]);
    // handler.addObject(sheep7);
    // handler.addObject(sheep8);
    // handler.addObject(sheep9);
    // handler.addObject(sheep10);
    // handler.addObject(sheep11);
    // handler.addObject(sheep12);
    // handler.addObject(sheep13);
    // handler.addObject(sheep14);

  }
  public static boolean isHeap(int arr[], int i, int n) {
    // If a leaf node
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


  public TextBox(int[] sheepHeap, LinkedList<GameObject> object){
    setTitle("Binary Sheep");
    setVisible(true);
    setSize(400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


    jp.add(jt1);
    jt1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        jt2.requestFocus();
      }
    });

    jp.add(jt2);
    jt2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String input1 = jt1.getText();
        String input2 = jt2.getText();

        alpha = Integer.parseInt(input1);
        beta = Integer.parseInt(input2);

        System.out.println("Unsorted: \n");
        for (int i=0; i<15; i++){
          System.out.print(sheepHeap[i] + " ");
        }

        // charlie = alpha + beta;
        // array_swap(sheepHeap, object.get(alpha).index, object.get(beta).index, Menu.handler);
        array_swap(sheepHeap, object.get(alpha).index, object.get(beta).index);
        System.out.println("HELP");
        if(isHeap(sheepHeap, 0, 14) == true){
          System.out.println("A winrar is you!");
          return;
        }

        swapcallcount += 1;


        //sheep0.setVelX(1);

        // GameObject sheep1 = Handler.object.get(alpha);
        // GameObject sheep2 = Handler.object.get(beta);
        // sheep1.index = beta;
        // sheep2.index = alpha;
        //  jl.setText(String.valueOf(charlie));
        System.out.println("Sorted: \n");
        for (int i=0; i<15; i++){
          System.out.print(sheepHeap[i] + " ");
        }
      }
    });

    jb.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e){
        String input1 = jt1.getText();
        String input2 = jt2.getText();

        alpha = Integer.parseInt(input1);
        beta = Integer.parseInt(input2);
        charlie = alpha + beta;

        System.out.println("Unsorted: \n");
        for (int i=0; i<15; i++){
          System.out.print(sheepHeap[i] + " ");
        }
        array_swap(sheepHeap, object.get(alpha).index, object.get(beta).index);
        System.out.println("help2");

        swapcallcount += 1;
        System.out.println(swapcallcount);
        if(swapcallcount > swapcallmax){
          File Nelson = new File("Nelson.wav");
          PlaySound(Nelson);
          System.out.println("You Lose");
          return;
        }
        if(isHeap(sheepHeap, 0, 14) == true){
          System.out.println("A winrar is you!");
          return;
        }
        System.out.println("Sorted: \n");
        for (int i=0; i<15; i++){
          System.out.print(sheepHeap[i] + " ");
        }
      //  jl.setText(String.valueOf(charlie));
      }
    });

    jp.add(jb);
    //jp.add(jl);
    add(jp);

}
static void PlaySound(File Sound) {
  try {
    Clip clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(Sound));
    clip.start();

    Thread.sleep(clip.getMicrosecondLength()/1000);
  }catch (Exception e)
  {

  }
}
public static void main(String[] args){
}
}
