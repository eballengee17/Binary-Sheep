import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

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

  public static void array_swap(int[] arr, int index1, int index2){
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;

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
        array_swap(sheepHeap, object.get(alpha).index, object.get(beta).index);
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
public static void main(String[] args){
}
}
