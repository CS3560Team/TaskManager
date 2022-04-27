import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {
        int option = 1;
        Scanner scanner = new Scanner(System.in);

        while(option > 0 && option < 9) {
            System.out.println("\t----------------------");
            System.out.println("\tTask Management System");
            System.out.println("\t----------------------");
            System.out.println("Task Options");
            System.out.println("1. Create Task");
            System.out.println("2. View Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Write Schedule to File");
            System.out.println("6. Read Schedule to File");
            System.out.println("7. View Schedule for month/day/year ");
            System.out.println("8. Write Schedule for month/day/year ");
            System.out.println("Press any other key to QUIT");
            System.out.print(":");
            option = scanner.nextInt();

            if(option==1){
                //TODO: Create Task
            }
            else if(option==2){
                //TODO: View Task
            }
            else if(option==3){
                //TODO: Delete Task
            }
            else if(option==4){
                //TODO: Edit Task
            }
            else if(option==5){
                //TODO: Write Schedule to File
            }
            else if(option==6){
                //TODO: Read Schedule to File
            }
            else if(option==7){
                //TODO: View Schedule for month/day/year
            }
            else if(option==8){
                //TODO: Write Schedule for month/day/year
            }

        }
    }
}
