package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * represents a task in the Bujo
 */
public class Task extends Action {
  private boolean isComplete;

  /**
   * constructor for task
   *
   * @param name of task
   * @param description what task is about
   * @param day when the task needs to be done
   * @param isComplete if the task is complete
   */
  public Task(@JsonProperty String name,
              @JsonProperty String description,
              @JsonProperty Day day,
              @JsonProperty boolean isComplete) {
    super(name, description, day);
    this.isComplete = isComplete;
  }

  /**
   * sets if the task is completed
   *
   * @param complete whether the task is complete
   */
  public void setIsComplete(boolean complete) {
    this.isComplete = complete;
  }

  /**
   * returns if the task is completed
   *
   * @return if the task is completed
   */
  public boolean getIsComplete() {
    return this.isComplete;
  }

}
