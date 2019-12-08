import java.awt.Canvas;
import javax.swing.*;

public class Game extends Canvas implements Runnable{

  private static final long serialVersionUID = 42l;

  public static final int WIDTH = 1280, HEIGHT = 720;

  public Game(){
    new Window(WIDTH, HEIGHT, "Binary Sheep", this);
  }

  public synchronized void start(){

  }

  public void run(){

  }

  public static void main(String args[]){
    new Game();
  }
}
