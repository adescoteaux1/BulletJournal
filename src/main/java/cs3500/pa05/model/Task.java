package cs3500.pa05.model;

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
   * @param dayOfWeek when the task needs to be done
   * @param isComplete if the task is complete
   */
  public Task(String name, String description, DayOfWeek dayOfWeek, boolean isComplete) {
    super(name, description, dayOfWeek);
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
