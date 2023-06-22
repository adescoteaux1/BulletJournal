package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.TUESDAY;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
  Task t;
  @BeforeEach
  public void initTask() {
    t = new Task("HW", "do HW", TUESDAY, false);
  }
  @Test
  public void testIsComplete() {
    assertEquals(false, t.getIsComplete());
  }

  @Test
  public void testSetComplete() {
    assertEquals(false, t.getIsComplete());
    t.setIsComplete(true);
    assertEquals(true, t.getIsComplete());
  }
}