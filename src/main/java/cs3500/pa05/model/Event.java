package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents an event in the Bujo
 */
public class Event extends Action {
  private String startTime;
  private String duration;

  /**
   * constructor for event
   *
   * @param name of event
   * @param description what the event is about
   * @param day which day the event is
   * @param startTime when the event starts
   * @param duration how long the event is
   */
  public Event(@JsonProperty("name") String name,
               @JsonProperty("description") String description,
               @JsonProperty("day") Day day,
               @JsonProperty("startTime") String startTime,
               @JsonProperty("duration") String duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }


  /**
   * sets starting time of event
   *
   * @param start when the event starts
   */
  public void setStartTime(String start) {
    this.startTime = start;
  }

  /**
   * gets starting time of event
   *
   * @return the starting time
   */
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * sets duration of event
   *
   * @param duration the length of the event
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

  /**
   * gets duration time of event
   *
   * @return the duration
   */
  public String getDuration() {
    return this.duration;
  }

}
