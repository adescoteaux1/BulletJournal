package cs3500.pa05.model;

/**
 * represents the names for days of the week
 */
public enum DayOfWeek {

  /**
   * represents monday
   */
  MONDAY(1),

  /**
   * represents tuesday
   */
  TUESDAY(2),

  /**
   * represents wednesday
   */
  WEDNESDAY(3),

  /**
   * represents thursday
   */
  THURSDAY(4),

  /**
   * represents friday
   */
  FRIDAY(5),

  /**
   * represents saturday
   */
  SATURDAY(6),

  /**
   * represents sunday
   */
  SUNDAY(0);

  private int value;

  DayOfWeek(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static DayOfWeek findDay(String day) {
    if (day.equals(MONDAY)) {
      return MONDAY;
    } else if (day.equals(TUESDAY)) {
      return TUESDAY;
    } else if (day.equals(WEDNESDAY)) {
      return WEDNESDAY;
    } else if (day.equals(THURSDAY)) {
      return THURSDAY;
    } else if (day.equals(FRIDAY)) {
      return FRIDAY;
    } else if (day.equals(SATURDAY)) {
      return SATURDAY;
    } else if (day.equals(SUNDAY)) {
      return SUNDAY;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
