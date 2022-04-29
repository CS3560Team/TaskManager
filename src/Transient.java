import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;;

public class Transient extends TaskManager{

    //unique to transient class, date is a variable for the date on which the activity is to occur
    int date;

    /**
     * Constructor for Transient, inherits from TaskManager which has following attributes
     * @param name - name of task
     * @param type - type of task
     * @param startTime - starting time of task
     * @param duration - duration of task
     */
    public Transient(String name, String type, float startTime, float duration) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Date of Activity in format YYYYMMDD: ");
        this.date = scanner.nextInt();
        while (!isDateValid(date)){
            System.out.println("ERROR: invalid date. Please try again.");
            System.out.print("Enter Date of Activity in format YYYYMMDD: ");
            this.date = scanner.nextInt();
        }
        if(taskOverlap(startTime, duration, this.date)){
            System.out.println("Error in taskoverlap function");
            System.out.println("ERROR: Task overlaps with already existing task. Task not created");
            System.exit(0);
        }
        if(!taskUnique(name)){
            System.out.println("ERROR: This task already exists in system. Task not created");
        }
        else{
            this.name = name;
            this.type = type;
            this.startTime = startTime;
            this.duration = duration;
            createTask(name, type, startTime, duration, date);
        }

    }

    public void createTask(String name, String type, float startTime, float duration, int date){
        //Create task if everything is successful. Add it to file called buffer.txt where
        //all activities will stay until they are added to schedule
        try {
            FileWriter myWriter = new FileWriter("buffer.txt", true);
            myWriter.write("\n" + this.type + "," + this.name + "," + this.date + "," + this.startTime + "," + this.duration);
            myWriter.close();
            System.out.println("Task Created");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean isDateValid(int date){
        //Checks if date is an integer and there for a valid date
        if(date%1!=0)
            return false;

        //Make date a string and parse string to get the months, if months < 0 or months > 12 then it is not
        //a valid month and should return false
        String dateStr = String.valueOf(date);
        String str = new StringBuilder().append(dateStr.charAt(4)).append(dateStr.charAt(5)).toString();
        int month = Integer.parseInt(str);
        if(month < 0 || month > 12)
            return false;

        //Here we parse the date for day and years. We then check the months with 31 days, then the months
        //with 30 days, then february on leap years, and finally February on non leap years
        String str2 = new StringBuilder().append(dateStr.charAt(6)).append(dateStr.charAt(7)).toString();
        int day = Integer.parseInt(str2);
        String str3 = new StringBuilder().append(dateStr.charAt(0)).append(dateStr.charAt(1)).append(dateStr.charAt(2)).append(dateStr.charAt(3)).toString();
        int year = Integer.parseInt(str3);
        if(day < 0)
            return false;

        if(month==1 || month ==3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            if(day > 31)
                return false;
        }
        else if(month==4 || month == 6 || month == 9 || month == 11) {
            if (day > 30)
                return false;
        }
        else if(month==2 && year % 4 == 0) {
            if (day > 29)
                return false;
        }
        else if(month==2){
            if(day>28)
                return false;
        }

        return true;

    }

    public boolean taskOverlap(float startTime, float duration, int date) throws Exception{
        String data ="";
        data = new String(Files.readAllBytes(Paths.get("buffer.txt")));

        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] values = line.split(",");
            if (Integer.valueOf(values[2]) == date) {
                float rangeStart = Float.valueOf(values[3]);
                float rangeEnd = Float.valueOf(values[3]) + Float.valueOf(values[4]);
                if (startTime > rangeStart || startTime < rangeEnd)
                    return true;
                else if (startTime < rangeStart && startTime + duration > rangeEnd)
                    return true;
            }

        }
        scanner.close();
        return false;
    }

    public boolean taskUnique(String name) throws IOException {
        String data ="";
        data = new String(Files.readAllBytes(Paths.get("buffer.txt")));

        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] values = line.split(",");
            if (values[1].equals(name)) {
                return false;
            }

        }
        scanner.close();
        return true;
    }



}
