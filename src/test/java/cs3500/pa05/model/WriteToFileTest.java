package cs3500.pa05.model;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class WriteToFileTest {
  @Test
  public void testWriteWithEmptyPath() {
    try {
      Week week = new Week(new ArrayList<Day>(), 10, 10);
      String filePath = WriteToFile.write("", week);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}