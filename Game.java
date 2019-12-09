import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Math;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game extends Canvas implements Runnable{

  private static final long serialVersionUID = 42l;

  public static final int WIDTH = 1280, HEIGHT = 720;


  private Image gameScreen;
  private Thread thread;
  private boolean running = false;
  private Handler handler;
  private Menu menu;
  private Instructions instructions;
  private Lose lose;
  //heap verification for winner (array, 0 , array length - 1)

//Array created
//===========================================================
  // public int[] createHeap(){
  //   int[] sheepHeap = new int[15];
  //   int arrlen = sheepHeap.length;
  //   //Generates 15 Random Numbers in the range 1 -100
  //   for(int i = 0; i < arrlen; i++) {
  //     sheepHeap[i] = (int)(Math.random()*100 + 1);
  //   }
  //   return sheepHeap;
  // }
//===========================================================
  //initialize game state at menuscreen
  public STATE gameState = STATE.Menu;

  public Game(){
    handler = new Handler();
    menu = new Menu(this, handler);

    instructions = new Instructions(this, handler);
    this.addMouseListener(menu);
    this.addMouseListener(instructions);

    lose = new Lose(this, handler);
    this.addMouseListener(lose);
    new Window(WIDTH, HEIGHT, "Binary Sheep", this);


    // if(gameState == STATE.Game){
    //   //need to add 15 sheep to make a tree
    // }

  }

  public synchronized void start(){
    thread = new Thread(this);
    thread.start();
    running = true;
  }

  public synchronized void stop(){
    try{
      thread.join();
      running = false;
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void run(){
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;

    while(running){
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      while(delta >= 1){
        tick();
        delta--;
      }
      if(running)
        render();
      frames++;

      if(System.currentTimeMillis() - timer > 1000){
        timer += 1000;
        // System.out.println("FPS: " + frames);
        frames = 0;
      }
    }
    stop();
  }

  private void tick(){


    if(gameState == STATE.Game){
      handler.tick();
    }else if(gameState == STATE.Menu){
      menu.tick();
    }else if(gameState == STATE.Lose){
      lose.tick();
    }
  }

  private void render(){
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null){
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();

    g.setColor(Color.white);
    g.fillRect(0,0,WIDTH,HEIGHT);



    try{
      gameScreen = ImageIO.read(getClass().getResourceAsStream("/Images/field.png"));
    } catch(IOException ex){
      ex.printStackTrace();
    }
    g.drawImage(gameScreen, 0, 0, WIDTH, HEIGHT, null);
    // g.setColor(Color.white);
    // g.drawRect(460,350,360,105);

    if(gameState == STATE.Game){
      //render game state
      //render all game objects after canvas is rendered
      handler.render(g);
    }else if(gameState == STATE.Menu){
      menu.render(g);
    }else if(gameState == STATE.Instructions){
      instructions.render(g);
    }else if(gameState == STATE.Lose){
      lose.render(g);
    }

    g.dispose();
    bs.show();
  }



  public static void main(String args[]){
    new Game();
  }
}
