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


public class Menu extends MouseAdapter{

  private Image menuScreen;
  private Game game;
  private Handler handler;

  public Menu(Game game, Handler handler){
    this.game = game;
    this.handler = handler;
  }

  public void mousePressed(MouseEvent e){
    int mx = e.getX();
    int my = e.getY();

    //if mouse is over play button
    if(mouseOver(mx, my, 460, 240, 105, 360)){
      game.gameState = STATE.Game;
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
    g.setColor(Color.white);
    g.drawRect(100,100,100,100);
  }
}
