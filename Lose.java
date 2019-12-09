import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Image;


public class Lose extends MouseAdapter{


  private Instructions instructions;
  private Game game;
  private Menu menu;
  private Handler handler;
  public static final int WIDTH = 1280, HEIGHT = 720;

  public Lose(Game game, Handler handler){
    this.game = game;
    this.handler = handler;
  }

  public void mousePressed(MouseEvent e){
    int mx = e.getX();
    int my = e.getY();

    //return button
    if(game.gameState == STATE.Lose && mouseOver(mx, my, 403,550,475,115)){
      game.gameState = STATE.Menu;
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

    g.setColor(Color.green);
    g.drawRect(403,550,475,115);
  }
}
