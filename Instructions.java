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


public class Instructions extends MouseAdapter{


  private Image instructionScreen;
  private Game game;
  private Menu menu;
  private Handler handler;
  public static final int WIDTH = 1280, HEIGHT = 720;

  public Instructions(Game game, Handler handler){
    this.game = game;
    this.handler = handler;
  }

  public void mousePressed(MouseEvent e){
    int mx = e.getX();
    int my = e.getY();

    //return button
    if(game.gameState == STATE.Instructions && mouseOver(mx, my, 403,550,475,115)){
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
    try{
      instructionScreen = ImageIO.read(getClass().getResourceAsStream("/Images/instructionscreen.png"));
    } catch(IOException ex){
      ex.printStackTrace();
    }
    g.drawImage(instructionScreen, 0, 0, null);
    // g.setColor(Color.white);
    // g.drawRect(403,550,475,115);
  }
}
