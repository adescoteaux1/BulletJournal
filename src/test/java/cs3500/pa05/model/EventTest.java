package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.MONDAY;
import static cs3500.pa05.model.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {
  Event e;
  @BeforeEach
  public void initEvents() {
    e = new Event("lab", "last ood lab",
        WEDNESDAY, "11:40", "100");
  }

  @Test
  public void testGetStartTime() {
    assertEquals("11:40", e.getStartTime());
  }

  @Test
  public void testSetStartTime() {
    assertEquals("11:40", e.getStartTime());
    e.setStartTime("12:00");
    assertEquals("12:00", e.getStartTime());
  }

  @Test
  public void testGetDuration() {
    assertEquals("100", e.getDuration());
  }

  @Test
  public void testSetDuration() {
    assertEquals("100", e.getDuration());
    e.setDuration("10");
    assertEquals("10", e.getDuration());
  }

  @Test
  public void testGetName() {
    assertEquals("lab", e.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("last ood lab", e.getDescription());
  }

  @Test
  public void testGetDayOfWeek() {
    assertEquals(WEDNESDAY, e.getDayOfWeek());
  }

  @Test
  public void testSetDayOfWeek() {
    assertEquals(WEDNESDAY, e.getDayOfWeek());
    e.setDayOfWeek(MONDAY);
    assertEquals(MONDAY, e.getDayOfWeek());
  }


}