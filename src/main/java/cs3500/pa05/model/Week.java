package cs3500.pa05.model;

import java.util.ArrayList;
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
  private Theme selectedTheme; // default is always light
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
    selectedTheme = Theme.LIGHT;
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

  /**
   * gets the selected theme of the week
   *
   * @return the selected theme
   */
  public Theme getSelectedTheme() {
    return selectedTheme;
  }

  /**
   * sets the selected theme of the week
   *
   * @param selectedTheme is the current theme
   */
  public void setSelectedTheme(Theme selectedTheme) {
    this.selectedTheme = selectedTheme;
  }

  /**
   * sets the quote or note to a string
   *
   * @param text string quote/note should be set to
   */
  public void setQuoteOrNote(String text) {
    this.quoteOrNote = text;
  }

  /**
   * gets an event by the name; event is identified
   * by the name to pop up in the mini viewer
   *
   * @param name of the event
   *
   * @return the event
   */
  public Event getEventByName(String name) {
    for (Day day : days) {
      for (Event event : day.getEvents()) {
        if (event.getName().equals(name)) {
          return event;
        }
      }
    }
    return null; // Event not found
  }

  /**
   * gets a task by the name; task is identified
   * by the name to pop up in the mini viewer
   *
   * @param name of the task
   *
   * @return the task
   */
  public Task getTaskByName(String name) {
    for (Day day : days) {
      for (Task task : day.getTasks()) {
        if (task.getName().equals(name)) {
          return task;
        }
      }
    }
    return null; // Task not found
  }


  // edit
  /**
   * adds an event to the week
   *
   * @param e an event we want to add
   */
  public void addEvent(Event e) {
    for (Day d : days) {
      d.getDayOfWeek();
      List<Event> events = d.getEvents();
      events.add(e);
    }
  }

  /**
   * adds a task to the week
   *
   * @param t an event we want to add
   */
  public void addTask(Task t) {
    for (Day d : days) {
      d.getDayOfWeek();
      List<Task> tasks = d.getTasks();
      tasks.add(t);
    }
  }

  public void deleteEvent(String eventName){
    for (Day day : days) {
      for (Event event : day.getEvents()) {
        if (event.getName().equals(eventName)) {
          day.removeEvent(event);
          break;
        }
      }
    }
  }

  public void deleteTask(String taskName){
    for (Day day : days) {
      for (Task task : day.getTasks()) {
        if (task.getName().equals(taskName)) {
          day.removeTask(task);
          break;
        }
      }
    }
  }


  /**
   * changes the order of the days based on the given start day
   * @param day the given start day
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
