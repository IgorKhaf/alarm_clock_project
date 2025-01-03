import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock implements Runnable {

  // Fields
  private final LocalTime alarmTime;
  private final String filePath;

  // Constructor
  AlarmClock(LocalTime alarmTime, String filePath) {
    this.alarmTime = alarmTime;
    this.filePath = filePath;
  }
 
  @Override
  public void run(){
    
    while(LocalTime.now().isBefore(alarmTime)){
      try{
        Thread.sleep(1000);

        LocalTime now = LocalTime.now();

        System.out.printf("\r%02d:%02d:%02d", 
                                  now.getHour(), 
                                  now.getMinute(), 
                                  now.getSecond());
      }
      catch(InterruptedException e){
        System.out.println("Thread was interrupted.");
      }
    }
    System.out.println("\n*ALARM NOISES*");
    playSound(filePath);
  
  }

  private void playSound(String filePath) {
    File audioFile = new File(filePath);
    
    

    try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();

      Thread.sleep(3000);

    }
    catch(UnsupportedAudioFileException e) {
      System.out.println("Audio file format is not supported.");
    }
    catch(LineUnavailableException e) {
      System.out.println("Audio is unavalable");
    }
    catch(IOException e) {
      System.out.println("Error reading audio file");
    } 
    catch (InterruptedException e) {

    }

  }
  
}
