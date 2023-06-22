package cs3500.pa05.model;

/**
 * represents the names for days of the week
 */
public enum DayOfWeek {

  /**
   * represents monday
   */
  MONDAY("Monday"),

  /**
   * represents tuesday
   */
  TUESDAY("Tuesday"),

  /**
   * represents wednesday
   */
  WEDNESDAY("Wednesday"),

  /**
   * represents thursday
   */
  THURSDAY("Thursday"),

  /**
   * represents friday
   */
  FRIDAY("Friday"),

  /**
   * represents saturday
   */
  SATURDAY("Saturday"),

  /**
   * represents sunday
   */
  SUNDAY("Sunday");

  private final String name;

  DayOfWeek(String name) {
    this.name = name;
  }

  /**
   * gets name of the day
   *
   * @return name
   */
  public String getName() {
    return name;
  }

}
