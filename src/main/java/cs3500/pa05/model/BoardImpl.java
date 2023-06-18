package cs3500.pa05.model;

public class BoardImpl implements WeekBoard {
  private final Week week;

  /**
   * constructor for BoardImpl
   *
   * @param week represents a week
   */
  public BoardImpl(Week week) {
    this.week = week;
  }

  @Override
  public int getEvents(Day day) {
    return 0;
  }

  @Override
  public int getTasks(Day day) {
    return 0;
  }
}
