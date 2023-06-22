package cs3500.pa05.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Week;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * reads a file
 */
public class ReadFile {

  /**
   * reads the week bujo file
   *
   * @param bujoPath the path of the bujo file
   *
   * @return a week
   * @throws IOException if an error occurs
   * @throws ClassNotFoundException if class is not found
   */
  public static Week readBujoFile(String bujoPath) throws IOException, ClassNotFoundException {
    Week week;

    if (bujoPath.isEmpty()) {
      Day monday = new Day(DayOfWeek.MONDAY, new ArrayList<>(), new ArrayList<>());
      Day tuesday = new Day(DayOfWeek.TUESDAY, new ArrayList<>(), new ArrayList<>());
      Day wednesday = new Day(DayOfWeek.WEDNESDAY, new ArrayList<>(), new ArrayList<>());
      Day thursday = new Day(DayOfWeek.THURSDAY, new ArrayList<>(), new ArrayList<>());
      Day friday = new Day(DayOfWeek.FRIDAY, new ArrayList<>(), new ArrayList<>());
      Day saturday = new Day(DayOfWeek.SATURDAY, new ArrayList<>(), new ArrayList<>());
      Day sunday = new Day(DayOfWeek.SUNDAY, new ArrayList<>(), new ArrayList<>());

      ArrayList<Day> days = new ArrayList<>(Arrays.asList(monday, tuesday,
          wednesday, thursday, friday, saturday, sunday));

      Week newWeek = new Week(days, 0, 0);
      newWeek.setTaskLimit(100);
      newWeek.setEventLimit(100);
      return newWeek;

    } else {
      FileInputStream fi = new FileInputStream(bujoPath);
      ObjectInputStream oi = new ObjectInputStream(fi);

      // Read object
      week = (Week) oi.readObject();

      oi.close();
      fi.close();

      return week;
    }
  }
}
