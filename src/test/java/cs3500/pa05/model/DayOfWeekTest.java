package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayOfWeekTest {
  @Test
  public void testGetName() {
    assertEquals("Monday", MONDAY.getName());
  }

}