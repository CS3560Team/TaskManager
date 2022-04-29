
import java.io.*;
import java.nio.file.*;;
import java.util.Scanner;


public class TaskManager {
   String name;
   String type;
   float startTime;
   float duration;

   public void viewTask(String task) throws Exception{

      //Open buffer.txt and search name attributes from file to see if there is a match
      String data ="";
      data = new String(Files.readAllBytes(Paths.get("buffer.txt")));

      Scanner scanner = new Scanner(data);
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         String[] values = line.split(",");
         if(values[1].equals(task))
            System.out.println("Name:" + values[1] + "\tType:" + values[0] + "\tDate:" + values[2] + "\tStart Time:" + values[3] + "\tDuration:" + values[4] + "\n");
      }
      scanner.close();

   }

}
