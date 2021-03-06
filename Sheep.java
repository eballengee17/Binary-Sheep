import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Font;

public class Sheep extends GameObject{

  private Image sheepie;
  private Font font;

  public Sheep(int x, int y, ID id, int index, int value){
    super(x, y, id, index, value);

    velX = 1;
    velY = 0;
  }

  public void tick(){
    // x += velX;
    value = Menu.sheepHeap[index];
    // value = value;
  }

  public void render(Graphics g){
    try{
      sheepie = ImageIO.read(getClass().getResourceAsStream("/Images/sheepie.png"));
    } catch(IOException ex){
      ex.printStackTrace();
    }
    g.drawImage(sheepie, x, y, 100,100, null);
    g.setFont(new Font("Corbel", Font.PLAIN, 18));

    g.setColor(Color.red);
    g.drawString(Integer.toString(index), x + 48, y + 100);

    g.setFont(new Font("Corbel", Font.PLAIN, 24));
    g.setColor(Color.black);
    if(value > 9){
      g.drawString(Integer.toString(value), x + 40 , y + 60);
    }else{
      g.drawString(Integer.toString(value), x + 45 , y + 60);
    }
    // g.setColor(Color.white);
    // g.fillRect(x,y,32,32);
  }


}
