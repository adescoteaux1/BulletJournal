package cs3500.pa05.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * represents a week
 */
public class Week implements Serializable {

  private List<Day> days;
  private int taskLimit;
  private int eventLimit;
  private int numEvents;
  private int numTasks;
  private String quoteOrNote;

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
    quoteOrNote = "";
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
   * sets this week's number of tasks
   *
   * @param input an integer
   */
  public void setTaskNum(int input) {
    numTasks = input;
  }

  /**
   * sets this week's number of events
   *
   * @param input an integer
   */
  public void setEventNum(int input) {
    numEvents = input;
  }

  /**
   * gets this week's task limit
   */
  public int getTaskLimit() {
    return taskLimit;
  }

  /**
   * gets this week's event limit
   */
  public int getEventLimit() {
    return eventLimit;
  }

  /**
   * gets the number of tasks that have been set
   *
   * @return an integer
   */
  public int getNumTasks() {
    return this.numTasks;
  }

  /**
   * gets the number of events that have been set
   *
   * @return an integer
   */
  public int getNumEvents() {
    return this.numEvents;
  }

  /**
   * sets the quote or note to a string
   *
   * @param text string quote/note should be set to
   */
  public void setQuoteOrNote(String text) {
    this.quoteOrNote = text;
  }

  public String getQuoteOrNote() {
    return this.quoteOrNote;
  }


  /**
   * adds an event to the week
   *
   * @param e an event we want to add
   */
  public void addEvent(Event e) {
    if (numEvents <= eventLimit) {
      for (Day d : days) {
        if (d.getDayOfWeek().getName().equals(e.getDayOfWeek().getName())) {
          d.addEvent(e);
        }
      }
      numEvents++;
    } else {
      System.out.println("Extending event limit."); //delete for MVC?
    }
  }

  /**
   * adds a task to the week
   *
   * @param t an event we want to add
   */
  public void addTask(Task t) {
    if (numTasks <= taskLimit) {
      for (Day d : days) {
        if (d.getDayOfWeek().equals(t.getDayOfWeek())) {
          d.addTask(t);
        }
      }
      numTasks++;
    } else {
      System.out.println("Extending task limit.");
    }
  }

  /**
   * deletes an event
   *
   * @param eventName name of event
   */
  public void deleteEvent(String eventName) {
    for (Day day : days) {
      for (Event event : day.getEvents()) {
        if (event.getName().equals(eventName)) {
          day.removeEvent(event);
          setEventNum(getNumEvents() - 1);
          break;
        }
      }
    }
  }

  /**
   * deletes a task
   *
   * @param taskName nam of task
   *
   */
  public void deleteTask(String taskName) {
    for (Day day : days) {
      for (Task task : day.getTasks()) {
        if (task.getName().equals(taskName)) {
          day.removeTask(task);
          setTaskNum(getNumTasks() - 1);
          break;
        }
      }
    }
  }


  /**
   * changes the order of the days based on the given start day
   *
   * @param day the given start day
   *
   */
  public void setStartDay(DayOfWeek day) {
    List<Day> newDays;
    int shiftedAmount = 0;
    for (int i = 0; i < days.size(); i++) {
      if (days.get(i).getDayOfWeek().equals(day)) {
        shiftedAmount = i;
      }
    }

    newDays = new ArrayList<>(days.subList(shiftedAmount, days.size()));
    newDays.addAll(days.subList(0, shiftedAmount));

    days = newDays;
  }
}
