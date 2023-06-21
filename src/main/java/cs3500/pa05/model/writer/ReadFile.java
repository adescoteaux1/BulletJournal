package cs3500.pa05.model.writer;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ReadFile {

  public static Week readBujoFile(String bujoPath) throws IOException {
    Week week;

    if (bujoPath.isEmpty()) {
      Day Monday = new Day(DayOfWeek.MONDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Tuesday = new Day(DayOfWeek.TUESDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Wednesday = new Day(DayOfWeek.WEDNESDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Thursday = new Day(DayOfWeek.THURSDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Friday = new Day(DayOfWeek.FRIDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Saturday = new Day(DayOfWeek.SATURDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Sunday = new Day(DayOfWeek.SUNDAY, new ArrayList<Event>(), new ArrayList<Task>());

      ArrayList<Day> Days = new ArrayList<>(Arrays.asList(Monday, Tuesday,
          Wednesday, Thursday, Friday, Saturday,Sunday));


      return new Week(Days, 100, 100);
    } else {
      Properties properties = new Properties();
      properties.load(new FileInputStream(bujoPath));
      week = (Week) properties.get("week");

      return week;
    }
  }
}
