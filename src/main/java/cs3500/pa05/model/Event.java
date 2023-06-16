package cs3500.pa05.model;

public class Event extends Action {
  private String startTime;
  private String duration;
  public Event(String name, String description, Day day, String startTime, String duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }


  public void setStartTime(String start) {
    this.startTime = start;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

}
