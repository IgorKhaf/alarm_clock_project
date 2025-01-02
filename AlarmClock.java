import java.time.LocalTime;

public class AlarmClock implements Runnable {

  // Fields
  private final LocalTime alarmTime;

  // Constructor
  AlarmClock(LocalTime alarmTime) {
    this.alarmTime = alarmTime;
  }
 
  @Override
  public void run(){
    LocalTime now = LocalTime.now();
    System.out.println(now);
  }
  
}
