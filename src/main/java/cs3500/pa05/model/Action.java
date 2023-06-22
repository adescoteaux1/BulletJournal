package cs3500.pa05.model;


/**
 * represents an action
 */
public abstract class Action {
  private final String name;
  private final String description;
  private DayOfWeek dayOfWeek;

  /**
   * constructor for action
   *
   * @param name of the action
   * @param description of the action
   * @param dayOfWeek of when the action is
   */
  public Action(String name, String description, DayOfWeek dayOfWeek) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * gets the name of the action
   *
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * gets the description of the action
   *
   * @return description
   */
  public String getDescription() {
    return  this.description;
  }

  /**
   * gets the day of this action
   *
   * @return the day
   */
  public DayOfWeek getDayOfWeek() {
    return this.dayOfWeek;
  }

  /**
   * sets the day of an action
   *
   * @param dayOfWeek of action
   */
  public void setDayOfWeek(DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }
}
