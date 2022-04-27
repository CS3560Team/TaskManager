import java.util.Scanner;

public class Recurring extends TaskManager{

    int startDate;
    int endDate;
    int frequency;

    public Recurring(String name, String type, float startTime, float duration){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Starting Date: ");
        this.startDate = scanner.nextInt();
        System.out.print("Enter an Ending Date: ");
        this.endDate = scanner.nextInt();
        System.out.print("Enter a frequency (daily(1), weekly(7)): ");
        this.frequency = scanner.nextInt();

        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
        createTask(name, type, startTime, duration, startDate, endDate, frequency);
    }

    public void createTask(String name, String type, float startTime, float duration, int startDate, int endDate, int frequency){
        //TODO: CreateTask
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
