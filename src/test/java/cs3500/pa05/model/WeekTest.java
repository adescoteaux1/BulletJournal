package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.FRIDAY;
import static cs3500.pa05.model.DayOfWeek.MONDAY;
import static cs3500.pa05.model.DayOfWeek.SATURDAY;
import static cs3500.pa05.model.DayOfWeek.SUNDAY;
import static cs3500.pa05.model.DayOfWeek.THURSDAY;
import static cs3500.pa05.model.DayOfWeek.TUESDAY;
import static cs3500.pa05.model.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekTest {
  Week week;

  @BeforeEach
  public void initWeek() {
    List<Day> days = new ArrayList<>();
    days.add(new Day(MONDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(TUESDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(WEDNESDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(THURSDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(FRIDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(SATURDAY, new ArrayList<>(), new ArrayList<>()));
    days.add(new Day(SUNDAY, new ArrayList<>(), new ArrayList<>()));

    week = new Week(days, 0, 0);
  }

  @Test
  public void getDays() {
    List<Day> expected = new ArrayList<>();
    expected.add(new Day(MONDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(TUESDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(WEDNESDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(THURSDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(FRIDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(SATURDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(SUNDAY, new ArrayList<>(), new ArrayList<>()));

    assertEquals(expected.size(), week.getDays().size());

    List<DayOfWeek> days = new ArrayList<>();
    for (Day d : week.getDays()) {
      days.add(d.getDayOfWeek());
    }

    List<DayOfWeek> expectedDays = new ArrayList<>();
    expectedDays.add(MONDAY);
    expectedDays.add(TUESDAY);
    expectedDays.add(WEDNESDAY);
    expectedDays.add(THURSDAY);
    expectedDays.add(FRIDAY);
    expectedDays.add(SATURDAY);
    expectedDays.add(SUNDAY);

    assertEquals(expectedDays, days);

  }

  @Test
  public void getTaskLimit() {
    assertEquals(0, week.getTaskLimit());
  }

  @Test
  public void setTaskLimit() {
    assertEquals(0, week.getTaskLimit());
    week.setTaskLimit(30);
    assertEquals(30, week.getTaskLimit());
  }

  @Test
  public void getEventLimit() {
    assertEquals(0, week.getEventLimit());
  }

  @Test
  public void setEventLimit() {
    assertEquals(0, week.getEventLimit());
    week.setEventLimit(30);
    assertEquals(30, week.getEventLimit());
  }


  //comment
  @Test
  public void setQuoteOrNote() {
    String input = "Have a good day";
    week.setQuoteOrNote(input);
    String qnote = week.getQuoteOrNote();
    assertEquals(input, qnote);

  }


  @Test
  public void addTasks() {
    assertEquals(0, week.getNumTasks());
    week.addTask(new Task("n", "n", MONDAY, true));
    assertEquals(1, week.getNumTasks());
    week.setTaskLimit(0);
    week.setTaskNum(1);
    week.addTask(new Task("n", "n", MONDAY, true));
    assertEquals(1, week.getNumTasks());
  }

  @Test
  public void addEvents() {
    assertEquals(0, week.getNumEvents());
    week.addEvent(new Event("n", "n", MONDAY, "4", "5"));
    assertEquals(1, week.getNumEvents());
    week.setEventLimit(0);
    week.setEventNum(1);
    week.addEvent(new Event("n", "n", MONDAY, "4", "5"));
    assertEquals(1, week.getNumEvents());
  }

  @Test
  public void setTaskNum() {
    assertEquals(0, week.getNumTasks());
    week.setTaskNum(5);
    assertEquals(5, week.getNumTasks());
  }

  @Test
  public void setEventtNum() {
    assertEquals(0, week.getNumEvents());
    week.setEventNum(5);
    assertEquals(5, week.getNumEvents());
  }

  @Test
  public void deleteEvents() {
    week.addEvent(new Event("n", "n", MONDAY, "4", "5"));
    assertEquals(1, week.getNumEvents());
    week.deleteEvent("n");
    assertEquals(0, week.getNumEvents());
  }

  @Test
  public void deleteTasks() {
    week.addTask(new Task("n", "n", MONDAY, false));
    assertEquals(1, week.getNumTasks());
    week.deleteTask("n");
    assertEquals(0, week.getNumTasks());
  }

  @Test
  public void testSetStartDay() {
    List<Day> expected = new ArrayList<>();
    expected.add(new Day(MONDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(TUESDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(WEDNESDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(THURSDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(FRIDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(SATURDAY, new ArrayList<>(), new ArrayList<>()));
    expected.add(new Day(SUNDAY, new ArrayList<>(), new ArrayList<>()));

    Day originalStartDay = week.getDays().get(0);

    week.setStartDay(TUESDAY);

    Day changedStartDay = week.getDays().get(0);

    assertEquals(expected.size(), week.getDays().size());
    assertNotEquals(originalStartDay.getDayOfWeek(), changedStartDay.getDayOfWeek());

    List<DayOfWeek> days = new ArrayList<>();
    for (Day d : week.getDays()) {
      days.add(d.getDayOfWeek());
    }

    List<DayOfWeek> expectedDays = new ArrayList<>();

    expectedDays.add(TUESDAY);
    expectedDays.add(WEDNESDAY);
    expectedDays.add(THURSDAY);
    expectedDays.add(FRIDAY);
    expectedDays.add(SATURDAY);
    expectedDays.add(SUNDAY);
    expectedDays.add(MONDAY);

    assertEquals(expectedDays, days);

  }
}