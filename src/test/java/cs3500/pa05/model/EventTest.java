package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {
  Event event;

  @BeforeEach
  public void initEvents() {
    event = new Event("lab", "last ood lab",
        WEDNESDAY, "11:40", "100");
  }

  @Test
  public void testGetStartTime() {
    assertEquals("11:40", event.getStartTime());
  }

  @Test
  public void testSetStartTime() {
    assertEquals("11:40", event.getStartTime());
    event.setStartTime("12:00");
    assertEquals("12:00", event.getStartTime());
  }

  @Test
  public void testGetDuration() {
    assertEquals("100", event.getDuration());
  }

  @Test
  public void testSetDuration() {
    assertEquals("100", event.getDuration());
    event.setDuration("10");
    assertEquals("10", event.getDuration());
  }

  @Test
  public void testGetName() {
    assertEquals("lab", event.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("last ood lab", event.getDescription());
  }

  @Test
  public void testGetDayOfWeek() {
    assertEquals(WEDNESDAY, event.getDayOfWeek());
  }



}