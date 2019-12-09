import javax.swing.*;
import java.awt.event.*;

public class TextBox extends JFrame{

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

  public TextBox(int[] sheepHeap){
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

        charlie = alpha + beta;
        for (int i = 0; i < 15; i++){
          System.out.print(sheepHeap[i] + " ");
        }
        array_swap(sheepHeap, alpha, beta);

        jl.setText(String.valueOf(charlie));

      }
    });

    jb.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent e){
        String input1 = jt1.getText();
        String input2 = jt2.getText();

        alpha = Integer.parseInt(input1);
        beta = Integer.parseInt(input2);
        charlie = alpha + beta;
        array_swap(sheepHeap, alpha, beta);

        jl.setText(String.valueOf(charlie));
        for (int i = 0; i < 15; i++){
          System.out.print(sheepHeap[i]);


        }
      }
    });

    jp.add(jb);
    jp.add(jl);
    add(jp);

}
public static void main(String[] args){
}
}
