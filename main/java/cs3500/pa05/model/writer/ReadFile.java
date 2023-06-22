package cs3500.pa05.model.writer;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ReadFile {

  public static Week readBujoFile(String bujoPath) throws IOException, ClassNotFoundException {
    Week week;

    if (bujoPath.isEmpty()) {
      System.out.println("empty");
      Day Monday = new Day(DayOfWeek.MONDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Tuesday = new Day(DayOfWeek.TUESDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Wednesday = new Day(DayOfWeek.WEDNESDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Thursday = new Day(DayOfWeek.THURSDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Friday = new Day(DayOfWeek.FRIDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Saturday = new Day(DayOfWeek.SATURDAY, new ArrayList<Event>(), new ArrayList<Task>());
      Day Sunday = new Day(DayOfWeek.SUNDAY, new ArrayList<Event>(), new ArrayList<Task>());

      ArrayList<Day> Days = new ArrayList<>(Arrays.asList(Monday, Tuesday,
          Wednesday, Thursday, Friday, Saturday,Sunday));

      Week newWeek = new Week(Days, 0, 0);
      newWeek.setTaskLimit(100);
      newWeek.setEventLimit(100);
      return newWeek;

    } else {
      FileInputStream fi = new FileInputStream(new File(bujoPath));
      ObjectInputStream oi = new ObjectInputStream(fi);

      // Read object
      week = (Week) oi.readObject();

      oi.close();
      fi.close();

      return week;
    }
  }
}
