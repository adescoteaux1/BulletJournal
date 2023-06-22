package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class ReadFileTest {
  @Test
  public void testReadBujoFileWithEmptyPath() {
    try {
      Week week = ReadFile.readBujoFile("");
      assertNotNull(week);

      // Assert the properties of the created week object
      assertEquals(100, week.getTaskLimit());
      assertEquals(100, week.getEventLimit());
      assertEquals(7, week.getDays().size());

      // Assert the properties of each day in the week
      for (Day day : week.getDays()) {
        assertNotNull(day);
        assertTrue(day.getTasks().isEmpty());
        assertTrue(day.getEvents().isEmpty());
      }
    } catch (IOException | ClassNotFoundException e) {
      fail("Exception thrown: " + e.getMessage());
    }
  }

}