import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class TextBox extends JFrame{

  private static final long serialVersionUID = 42l;

  private Handler handler;
  private Game game;
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


  public TextBox(int[] sheepHeap, LinkedList<GameObject> object, Game game, Handler handler){

    this.game = game;
    this.handler = handler;

    setTitle("Binary Sheep");
    setVisible(true);
    setSize(400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    File SheepBaa = new File("Sheep.wav");
    File Nelson = new File("Nelson.wav");

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
        System.out.println("alpha");
        PlaySound(SheepBaa);

        if(isHeap(sheepHeap, 0, 14) == true){
          System.out.println("A winrar is you!");
          return;
        }

        swapcallcount += 1;
        if(swapcallcount > swapcallmax){
          System.out.println("You Lose");
          game.gameState = STATE.Lose;
          PlaySound(Nelson);
        }
        System.out.println();
        System.out.println(swapcallcount);


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

        System.out.println("Preswap: \n");
        for (int i=0; i<15; i++){
          System.out.print(sheepHeap[i] + " ");
        }
        array_swap(sheepHeap, object.get(alpha).index, object.get(beta).index);
        System.out.println("Beta");
        PlaySound(SheepBaa);

        swapcallcount += 1;
        System.out.println();
        System.out.println(swapcallcount);
        if(swapcallcount > swapcallmax){
          System.out.println("You Lose");
          game.gameState = STATE.Lose;
          PlaySound(Nelson);
        }
        if(isHeap(sheepHeap, 0, 14) == true){
          System.out.println("A winrar is you!");
          return;
        }
        System.out.println("Postswap: \n");
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
