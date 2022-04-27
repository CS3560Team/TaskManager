import java.util.Scanner;

public class Attributes {

    public String taskType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Type of Task");
        System.out.println("T - Transient");
        System.out.println("R - Recurring");
        System.out.println("A - Anti");
        System.out.print(":");
        char option = scanner.next().charAt(0);
        System.out.println();

        if(option=='T')
            return "Transient";
        else if(option=='R')
            return "Recurring";
        else if(option=='A')
            return "Anti";
        else
            return " ";
    }

    public String taskName(String type){
        Scanner scanner = new Scanner(System.in);
        String option = " ";
        if(type.equals("Transient")){
            String[] names = {"Visit", "Shopping", "Appointment"};
            System.out.println("Choose a type of Transient Task");
            int i = 1;
            for (String s : names){
                System.out.println("-" + s);
            }
            System.out.print(":");
            option = scanner.nextLine();
        }
        else if(type.equals("Recurring")){
            String[] names = {"Class", "Study", "Sleep", "Exercise", "Work", "Meal"};
            System.out.println("Choose a type of Recurring Task");
            int i = 1;
            for (String s : names){
                System.out.println(s);
            }
            System.out.print(":");
            option = scanner.nextLine();
        }
        else if(type.equals("Anti")){
            option = "Anti";
        }
        System.out.println();
        return option;
    }

    public float startTime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*Note: Start time must be between 0-24 and starts on the nearest 15th minute. (example 7:45am = 19.75)");
        System.out.print("Enter a start time: ");
        float time = scanner.nextFloat();
        System.out.println();

        return time;
    }

    public float duration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*Note: Duration must be rounded to nearest 15th minute (example 1 hour 45 minutes = 1.75");
        System.out.print("Enter a duration: ");
        float length = scanner.nextFloat();
        System.out.println();

        return length;
    }
}
