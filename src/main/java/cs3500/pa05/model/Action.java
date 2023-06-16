package cs3500.pa05.model;

/**
 * represents a task or event
 */
public abstract class Action {
  private final String name;
  private final String description;
  private Day day;
  private boolean isComplete;
  private String startTime;
  private String duration;

  public Action(String name, String description, Day day, boolean isComplete,
                String startTime, String duration) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.isComplete = isComplete;
    this.startTime = startTime;
    this.duration = duration;
  }

  // edit this
  /**
   * task constructor
   *
   * @param name of task
   * @param description of task
   * @param day of when the task is
   * @param isComplete if the task is finished
   */
  public Action(String name, String description, Day day, boolean isComplete) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.isComplete = isComplete;
  }

  //edit this

  /**
   * event constructor
   *
   * @param name of event
   * @param description of event
   * @param day of when the event us
   * @param startTime of the event
   * @param duration of the event
   */
  public Action(String name, String description, Day day, String startTime, String duration) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return  this.description;
  }

  public void setDay(Day day1) {
    this.day = day1;
  }

  public void setIsComplete(boolean complete) {
    this.isComplete = complete;
  }

  public void setStartTime(String start) {
    this.startTime = start;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }
}
