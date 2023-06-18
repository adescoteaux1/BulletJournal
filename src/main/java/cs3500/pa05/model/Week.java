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

  /**
   * constructor for Week
   *
   * @param days days of the week
   * @param taskLimit upper bound on number of tasks
   * @param eventLimit upper bound on number of events
   */

  public Week(List<Day> days, int taskLimit, int eventLimit) {
    this.days = days;
    this.taskLimit = taskLimit;
    this.eventLimit = eventLimit;
    numEvents = 0;
    numTasks = 0;
  }

  /**
   * returns the days
   *
   * @return teh days
   */
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
      System.out.println("Extending event limit."); //delete for MVC?
      setEventLimit(numEvents);
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
      System.out.println("Extending event limit."); //delete for MVC?
      setTaskLimit(numTasks);
    }
  }

}
