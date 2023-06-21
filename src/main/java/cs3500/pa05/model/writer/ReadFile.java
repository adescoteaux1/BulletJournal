package cs3500.pa05.model.writer;

import cs3500.pa05.model.Week;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {

  public Week readFile(String weekName, String bujoPath) throws IOException {
    Week week;

    Properties properties = new Properties();
    properties.load(new FileInputStream(bujoPath));
    week = (Week) properties.get(weekName);

    return week;
  }
}
