package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.THURSDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTest {
  Day thursday;

  @BeforeEach
  public void createDays() {
    thursday = new Day(THURSDAY, new ArrayList<>(), new ArrayList<>());
  }

  @Test
  public void testAddEvent() {
    Event newEvent = new Event("class", "last ood class",
        THURSDAY, "9:50", "100");
    List<Event> expected = new ArrayList<>();
    assertEquals(expected, thursday.getEvents());

    expected.add(newEvent);
    thursday.addEvent(newEvent);
    assertEquals(expected, thursday.getEvents());
  }

  @Test
  public void testRemoveEvent() {
    Event newEvent = new Event("class", "last ood class",
        THURSDAY, "9:50", "100");
    List<Event> expected = new ArrayList<>();
    expected.add(newEvent);
    thursday.addEvent(newEvent);
    assertEquals(expected, thursday.getEvents());

    List<Event> empty = new ArrayList<>();
    thursday.removeEvent(newEvent);
    assertEquals(empty, thursday.getEvents());

  }

  @Test
  public void testAddTask() {
    Task newTask = new Task("hw", "ood hw",
        THURSDAY, true);
    List<Task> expected = new ArrayList<>();
    assertEquals(expected, thursday.getTasks());

    expected.add(newTask);
    thursday.addTask(newTask);
    assertEquals(expected, thursday.getTasks());
  }

  @Test
  public void testRemoveTask() {
    Task newTask = new Task("hw", "ood hw",
        THURSDAY, true);
    List<Task> expected = new ArrayList<>();
    expected.add(newTask);
    thursday.addTask(newTask);
    assertEquals(expected, thursday.getTasks());

    List<Task> empty = new ArrayList<>();
    thursday.removeTask(newTask);
    assertEquals(empty, thursday.getTasks());

  }

  @Test
  public void testGetDayOfWeek() {
    assertEquals(THURSDAY, thursday.getDayOfWeek());
  }

}