package cs3500.pa05.model;

import java.util.List;

/**
 * represents a week
 */
public class Week {

  private List<Day> days;
  private int taskLimit;
  private int eventLimit;
  private int numEvents;
  private int numTasks;

  public Week(List<Day> days, int taskLimit, int eventLimit) {
    this.days = days;
    this.taskLimit = taskLimit;
    this.eventLimit = eventLimit;
    numEvents = 0;
    numTasks = 0;
  }

  public List<Day> getDays() {
    return days;
  }

  /**
   * sets this week's task limit
   *
   * @param limit the limit
   */
  public void setTaskLimit(int limit) {
    taskLimit = limit;
  }

  /**
   * sets this week's event limit
   *
   * @param limit the limit
   */
  public void setEventLimit(int limit) {
    eventLimit = limit;
  }

  /**
   * creates a new event
   *
   * @param day the day the event is being created on
   * @param e the new event
   */
  public void createEvent(Day day, Event e) {
    if (numEvents < eventLimit) {
      day.addEvent(e);
      numEvents++;
    } else {
      //TODO: what are we doing when they exceed the limit
    }
  }

  /**
   * creates a new task
   *
   * @param day the day the task is being created on
   * @param t the new task
   */
  public void createTask(Day day, Task t) {
    if (numTasks < taskLimit) {
      day.addTask(t);
      numTasks++;
    } else {
      //TODO: what are we doing when they exceed the limit
    }
  }

}
