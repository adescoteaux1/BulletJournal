package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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