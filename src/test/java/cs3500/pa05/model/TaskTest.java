package cs3500.pa05.model;

import static cs3500.pa05.model.DayOfWeek.TUESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
  Task task;

  @BeforeEach
  public void initTask() {
    task = new Task("HW", "do HW", TUESDAY, false);
  }

  @Test
  public void testIsComplete() {
    assertEquals(false, task.getIsComplete());
  }

  @Test
  public void testSetComplete() {
    assertEquals(false, task.getIsComplete());
    task.setIsComplete(true);
    assertEquals(true, task.getIsComplete());
  }
}