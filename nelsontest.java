import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class nelsontest {

  public static void main(String[] args){
    playMusic("‪C:\\Users\\Andrew\\Documents\\GitHub\\Algorithms-Project-CSCI3383\\Nelson.wav");
  }

  public static void playMusic(String filepath) {
    InputStream music;
    try{
      music = new FileInputStream(new File(filepath));
      AudioStream audios = new AudioStream(music);
      AudioPlayer.player.start(audios);
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null, "Fuck you");
    }
  }
}
