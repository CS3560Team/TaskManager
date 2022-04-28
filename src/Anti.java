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

    public boolean tasksExists(){
        return false;
        //TODO: check if task exists with proper start and end time so task can be deleted
    }
}
