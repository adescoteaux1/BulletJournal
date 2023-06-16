package cs3500.pa05.model;

public class Task extends Action {
  private boolean isComplete;
  public Task(String name, String description, Day day, boolean isComplete) {
    super(name, description, day);
    this.isComplete = isComplete;
  }

  public void setIsComplete(boolean complete) {
    this.isComplete = complete;
  }

}
