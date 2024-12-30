import java.net.SocketTimeoutException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime alarmTime;

    try{
      System.out.print("Enter an alarm time (hh:mm:ss): ");
      String inputTime = scanner.nextLine();
  
      alarmTime = LocalTime.parse(inputTime, formatter);
      System.out.println("Alarm set for "+ alarmTime);
    }
    catch(DateTimeParseException e){
      System.out.println("Invalid format. Please use HH:MM:SS.");
    }

   

    scanner.close();
  }
}
