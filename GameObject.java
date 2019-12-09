import java.awt.Canvas;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;

//all game objects are placed in here
public abstract class GameObject{

  protected int x, y;
  protected ID id;
  protected int index;
  protected int value;
  protected int velX, velY;

  //game object constructor --> used for all game objects
  public GameObject(int x, int y, ID id, int index, int value){
    this.x = x;
    this.y = y;
    this.id = id;
    this.index = index;
    this.value = value;
  }

  public abstract void tick();
  public abstract void render(Graphics g);

  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void setVelX(int velX){
    this.velX = velX;
  }
  public void setVelY(int velY){
    this.velY = velY;
  }
  public int getVelX(){
    return velX;
  }
  public int getVelY(){
    return velY;
  }
  public void setID(ID id){
    this.id = id;
  }
  public ID getID(){
    return this.id;
  }
  public int getIndex(){
    return this.index;
  }
  public int getValue(){
    return this.value;
  }
  public void setIndex(int index){
    this.index = index;
  }
  public void setValue(int value){
    this.value = value;
  }
}
