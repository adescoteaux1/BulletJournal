package cs3500.pa05.model.writer;

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
   * @param bujoPath the path of the bujo file
   *
   * @return a week
   * @throws IOException if an error occurs
   * @throws ClassNotFoundException if class is not found
   */
  public static Week readBujoFile(String bujoPath) throws IOException, ClassNotFoundException {
    Week week;

    if (bujoPath.isEmpty()) {
      System.out.println("empty");
      Day Monday = new Day(DayOfWeek.MONDAY, new ArrayList<>(), new ArrayList<>());
      Day Tuesday = new Day(DayOfWeek.TUESDAY, new ArrayList<>(), new ArrayList<>());
      Day Wednesday = new Day(DayOfWeek.WEDNESDAY, new ArrayList<>(), new ArrayList<>());
      Day Thursday = new Day(DayOfWeek.THURSDAY, new ArrayList<>(), new ArrayList<>());
      Day Friday = new Day(DayOfWeek.FRIDAY, new ArrayList<>(), new ArrayList<>());
      Day Saturday = new Day(DayOfWeek.SATURDAY, new ArrayList<>(), new ArrayList<>());
      Day Sunday = new Day(DayOfWeek.SUNDAY, new ArrayList<>(), new ArrayList<>());

      ArrayList<Day> Days = new ArrayList<>(Arrays.asList(Monday, Tuesday,
          Wednesday, Thursday, Friday, Saturday,Sunday));

      Week newWeek = new Week(Days, 0, 0);
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
