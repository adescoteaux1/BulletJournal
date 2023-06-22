package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.FRIDAY;
import static cs3500.pa05.model.DayOfWeek.MONDAY;
import static cs3500.pa05.model.DayOfWeek.SATURDAY;
import static cs3500.pa05.model.DayOfWeek.SUNDAY;
import static cs3500.pa05.model.DayOfWeek.THURSDAY;
import static cs3500.pa05.model.DayOfWeek.TUESDAY;
import static cs3500.pa05.model.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekTest {
  Week w;
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

    w = new Week(days, 0, 0);
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

    //assertEquals(expected, w.getDays());
  }

  @Test
  public void getTaskLimit() {
    assertEquals(0, w.getTaskLimit());
  }

  @Test
  public void setTaskLimit() {
    assertEquals(0, w.getTaskLimit());
    w.setTaskLimit(30);
    assertEquals(30, w.getTaskLimit());
  }

  @Test
  public void getEventLimit() {
    assertEquals(0, w.getEventLimit());
  }

  @Test
  public void setEventLimit() {
    assertEquals(0, w.getEventLimit());
    w.setEventLimit(30);
    assertEquals(30, w.getEventLimit());
  }

  @Test
  public void createEvent() {
    Event e = new Event("lab", "last ood lab",
        WEDNESDAY, "11:40", "100");
    w.createEvent(w.getDays().get(2), e);
    //assertTrue(w.getDays().get(2).getEvents().contains(e));
  }

  @Test
  public void createTask() {
    Task t = new Task("classes", "neu summer 1", MONDAY, false);
        w.createTask(w.getDays().get(2), t);
    // assertTrue(w.getDays().get(2).getEvents().contains(e)));
  }

  //comment
  @Test
  public void setQuoteOrNote() {
    String input = "Have a good day";
    w.setQuoteOrNote(input);
    String qnote = w.getQuoteOrNote();
    assertEquals(input, qnote);

  }

  @Test
  public void getEventByName() {

  }

  @Test
  public void getTaskByName() {
  }

  @Test
  public void addEvent() {
  }

  @Test
  public void addTask() {
  }

  @Test
  public void deleteEvent() {
  }

  @Test
  public void deleteTask() {
  }

  @Test
  public void setStartDay() {
  }
}