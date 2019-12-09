import javax.swing.*;

public class TextBox extends JFrame{

  JPanel jp = new JPanel();
  JLabel jl = new JLabel();
  JTextField jt = new JTextField(2);

  public TextBox(){
    setTitle("Tutorial");
    setVisible(true);
    setSize(400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    frame.add(jt);
    add(jp);
  }


public static void main(String[] args){
}

}
