import java.awt.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Image;


public class Menu extends MouseAdapter{

  private Lose lose;
  public TextBox t;
  public static int[] sheepHeap;
  private Image menuScreen;
  private Game game;
  private Instructions instructions;
  public Handler handler;
  public static final int WIDTH = 1280, HEIGHT = 720;

  public Menu(Game game, Handler handler){
    this.game = game;
    this.handler = handler;
  }

  public static void array_swap(int[] arr, int index1, int index2){
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  public int[] createHeap(){
    int[] sheepHeap = new int[15];
    int arrlen = sheepHeap.length;
    //Generates 15 Random Numbers in the range 1 -100
    for(int i = 0; i < arrlen; i++) {
      sheepHeap[i] = (int)(Math.random()*100 + 1);
    }
    return sheepHeap;
  }
  public void mousePressed(MouseEvent e){
    int mx = e.getX();
    int my = e.getY();

    //if mouse is over play button
    if(game.gameState == STATE.Menu && mouseOver(mx, my, 460, 240, 360, 105)){
      game.gameState = STATE.Game;


      sheepHeap = createHeap();

      //add 15 Sheep
      //layer 1
      Sheep sheep0 = new Sheep(600, 50, ID.Sheep, 0, sheepHeap[0]);
      handler.addObject(sheep0);

      //layer 2
      Sheep sheep1 = new Sheep(300, 200, ID.Sheep, 1, sheepHeap[1]);
      Sheep sheep2 = new Sheep(900, 200, ID.Sheep, 2, sheepHeap[2]);
      handler.addObject(sheep1);
      handler.addObject(sheep2);

      //layer 3
      Sheep sheep3 = new Sheep(150,350, ID.Sheep, 3, sheepHeap[3]);
      Sheep sheep4 = new Sheep(450,350, ID.Sheep, 4, sheepHeap[4]);
      Sheep sheep5 = new Sheep(750,350, ID.Sheep, 5, sheepHeap[5]);
      Sheep sheep6 = new Sheep(1050,350, ID.Sheep, 6, sheepHeap[6]);
      handler.addObject(sheep3);
      handler.addObject(sheep4);
      handler.addObject(sheep5);
      handler.addObject(sheep6);

      //layer 4
      Sheep sheep7 = new Sheep(75,500, ID.Sheep, 7, sheepHeap[7]);
      Sheep sheep8 = new Sheep(225,500, ID.Sheep, 8, sheepHeap[8]);
      Sheep sheep9 = new Sheep(375,500, ID.Sheep, 9, sheepHeap[9]);
      Sheep sheep10 = new Sheep(525,500, ID.Sheep, 10, sheepHeap[10]);
      Sheep sheep11 = new Sheep(675,500, ID.Sheep, 11, sheepHeap[11]);
      Sheep sheep12 = new Sheep(825,500, ID.Sheep, 12, sheepHeap[12]);
      Sheep sheep13 = new Sheep(985,500, ID.Sheep, 13, sheepHeap[13]);
      Sheep sheep14 = new Sheep(1135,500, ID.Sheep, 14, sheepHeap[14]);
      handler.addObject(sheep7);
      handler.addObject(sheep8);
      handler.addObject(sheep9);
      handler.addObject(sheep10);
      handler.addObject(sheep11);
      handler.addObject(sheep12);
      handler.addObject(sheep13);
      handler.addObject(sheep14);

      TextBox t = new TextBox(sheepHeap, handler.object, game, handler);
      // for(int i = 0; i<15;i++){
      //   System.out.print(sheepHeap[i] + " ");
      //}
    }else if(game.gameState == STATE.Menu && mouseOver(mx, my, 460, 350, 360, 105)){
      game.gameState = STATE.Instructions;
    }
  }

  public void mouseReleased(MouseEvent e){

  }

  //checks if mouse is hovering over a button
  private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
    if(mx > x && mx < x + width){
      if(my > y && my < y + height){
        return true;
      }else return false;
    }else return false;
  }

  public void tick(){

  }

  public void render(Graphics g){
    try{
      menuScreen = ImageIO.read(getClass().getResourceAsStream("/Images/menuscreen.png"));
    } catch(IOException ex){
      ex.printStackTrace();
    }
    g.drawImage(menuScreen, 0, 0, null);
    // g.setColor(Color.white);
    // g.drawRect(460,350,360,105);
  }
}
