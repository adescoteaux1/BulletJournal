package cs3500.pa05.model;

import java.util.List;

/**
 * represents a day of the week
 */
public class Day {
  private DayOfWeek day;
  private List<Event> events;
  private List<Task> tasks;

  /**
   * @param name the day of the week
   * @param e the events on this day
   * @param t the tasks on this day
   */
  public Day(DayOfWeek name, List<Event> e, List<Task> t) {
    day = name;
    events = e;
    tasks = t;
  }

  /**
   * adds an event to the day's event list
   *
   * @param e the event to be added
   */
  public void addEvent(Event e) {
    events.add(e);
  }

  /**
   * adds a task to the day's task list
   *
   * @param t the task to be added
   */
  public void addTask(Task t) {
    tasks.add(t);
  }

  /**
   * removes an event to the day's event list
   *
   * @param e the event to be removed
   */
  public void removeEvent(Event e) {
    events.remove(e);
  }

  /**
   * removes a task to the day's task list
   *
   * @param t the task to be removed
   */
  public void removeTask(Task t) {
    tasks.remove(t);
  }

  /**
   * gets this day's event list
   *
   * @return the event list
   */
  public List<Event> getEvents() {
    return events;
  }

  /**
   * gets this day's task list
   *
   * @return the task list
   */
  public List<Task> getTasks() {
    return tasks;
  }

  /**
   * returns the day of the week
   *
   * @return the day of the week
   */
  public DayOfWeek getDayOfWeek() {
    return this.getDayOfWeek();
  }

}
