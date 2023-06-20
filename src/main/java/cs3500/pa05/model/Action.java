package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents an action
 */
public abstract class Action {
  private final String name;
  private final String description;
  private Day day;

  /**
   * constructor for action
   *
   * @param name of the action
   * @param description of the action
   * @param day of when the action is
   */
  public Action(@JsonProperty String name,
                @JsonProperty String description,
                @JsonProperty Day day) {
    this.name = name;
    this.description = description;
    this.day = day;
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
  public Day getDay() {
    return this.day;
  }

  /**
   * sets the day of an action
   *
   * @param day of action
   */
  public void setDay(Day day) {
    this.day = day;
  }
}
