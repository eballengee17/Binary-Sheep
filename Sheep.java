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

public class Sheep extends GameObject{

  private Image sheepie;

  public Sheep(int x, int y, ID id){
    super(x, y, id);

    velX = 0;
    velY = 0;
  }

  public void tick(){
    if(x<10){
      x += velX;
    }
    else if(y<10){
      y += velY;
    }
    else if(x>0){
      x -= velX;
    }
    else if(y>0){
      y -= velY;
    }
  }

  public void render(Graphics g){
    try{
      sheepie = ImageIO.read(getClass().getResourceAsStream("/Images/sheepie.png"));
    } catch(IOException ex){
      ex.printStackTrace();
    }
    g.drawImage(sheepie, x, y, 100,100, null);
    // g.setColor(Color.white);
    // g.fillRect(x,y,32,32);
  }

}
