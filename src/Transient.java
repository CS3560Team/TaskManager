import java.util.Scanner;

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
    public Transient(String name, String type, float startTime, float duration){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Date of Activity in format YYYYMMDD: ");
        this.date = scanner.nextInt();
        while (!isDateValid(date)){
            System.out.println("ERROR: invalid date. Please try again.");
            System.out.print("Enter Date of Activity in format YYYYMMDD: ");
            this.date = scanner.nextInt();
        }
        if(taskOverlap()){
            System.out.println("ERROR: Task overlaps with already existing task. Task not created");
        }
        else if(!taskUnique()){
            System.out.println("ERROR: This task already exists in system. Task not created");
        }
        else{
            this.name = name;
            this.type = type;
            this.startTime = startTime;
            this.duration = duration;
            System.out.println("Task Successfully created");
            System.out.println();
        }

    }

    public boolean isDateValid(int date){
        return true;
        //TODO: check if date is valid
    }

    public boolean taskOverlap(){
        return false;
        //TODO: Check if task overlaps
    }

    public boolean taskUnique(){
        return true;
        //TODO: check if task is unique
    }



}
