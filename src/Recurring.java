import java.util.Scanner;

public class Recurring extends TaskManager{

    int startDate;
    int endDate;
    int frequency;

    public Recurring(String name, String type, float startTime, float duration){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Starting Date: ");
        this.startDate = scanner.nextInt();

        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
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
