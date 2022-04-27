public class Recurring extends TaskManager{

    int startDate;
    int endDate;
    int frequency;

    public Recurring(String name, String type, float startTime, float duration){
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
    }
}
