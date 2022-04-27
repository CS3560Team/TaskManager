import java.util.Scanner;

public class Anti extends TaskManager{

    int date;

    public Anti(String name, String type, float startTime, float duration){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Date of Activity in format YYYYMMDD: ");
        this.date = scanner.nextInt();
        while (!isDateValid(date)){
            System.out.println("ERROR: invalid date. Please try again.");
            System.out.print("Enter Date of Activity in format YYYYMMDD: ");
            this.date = scanner.nextInt();
        }
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
        if(tasksExists()){
            //TODO: delete task from system
        }
        else{
            System.out.println("ERROR: Task with same attributes does not exist in system. System aborted ");
        }
    }

    public boolean isDateValid(int date){
        return true;
        //TODO: check if date is valid
    }

    public boolean tasksExists(){
        return false;
        //TODO: check if task exists with proper start and end time so task can be deleted
    }
}
