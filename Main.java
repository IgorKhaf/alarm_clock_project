import java.net.SocketTimeoutException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){

    // Variables
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime alarmTime = null;
    String filePath = "alarm_sound.wav";


    while (alarmTime == null){
      try{
        System.out.print("Enter an alarm time (hh:mm:ss): ");
        String inputTime = scanner.nextLine();
    
        alarmTime = LocalTime.parse(inputTime, formatter);
        System.out.println("Alarm set 20:15for "+ alarmTime);
      }
      catch(DateTimeParseException e){
        System.out.println("Invalid format. Please use HH:MM:SS.");
      }
  
    }

    AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
    Thread alarmThread = new Thread(alarmClock);
    alarmThread.start();
   
  }
}
