import java.util.LinkedList;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;

//loops through all objects in the game, renders them, and updates them to screen
public class Handler{

  LinkedList<GameObject> object = new LinkedList<GameObject>();

  //tick through all of our game objects
  public void tick(){
    for(int i = 0; i < object.size(); i++){
      GameObject tempObject = object.get(i);

      tempObject.tick();
    }
  }

  //render all of our game objects
  public void render(Graphics g){
    for(int i = 0; i < object.size(); i++){
      GameObject tempObject = object.get(i);

      tempObject.render(g);
    }
  }

  //handles adding and removing object from list
  public void addObject(GameObject object){
    this.object.add(object);
  }
  public void removeObject(GameObject object){
    this.object.remove(object);
  }
}
