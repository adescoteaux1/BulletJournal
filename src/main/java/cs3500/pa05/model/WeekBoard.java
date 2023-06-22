package cs3500.pa05.model;

/**
 * represents a board of the week
 */
public interface WeekBoard {
  /**
   * gets the events on a day
   *
   * @param day the specified day
   * @return the number of events
   */
  int getEvents(Day day);


  /**
   * gets the tasks on a day
   *
   * @param day the specified day
   * @return the number of tasks
   */
  int getTasks(Day day);
}
