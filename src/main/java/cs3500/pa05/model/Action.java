package cs3500.pa05.model;

/**
 * represents an ation
 */
public abstract class Action {
  private final String name;
  private final String description;
  private Day day;

  public Action(String name, String description, Day day) {
    this.name = name;
    this.description = description;
    this.day = day;
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
}
