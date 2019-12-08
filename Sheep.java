import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;

public class Sheep extends GameObject{

  public Sheep(int x, int y, ID id){
    super(x, y, id);

    // velX = 1;
    // velY = 3;
  }

  public void tick(){
    x += velX;
    y += velY;
  }

  public void render(Graphics g){
    g.setColor(Color.white);
    g.fillRect(x,y,32,32);
  }

}
