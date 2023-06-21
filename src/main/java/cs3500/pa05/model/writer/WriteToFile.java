package cs3500.pa05.model.writer;


import com.fasterxml.jackson.databind.util.JSONPObject;
import cs3500.pa05.model.Week;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class WriteToFile {

  public void write(String bujoPath, Week week) throws IOException {

    Properties properties = new Properties();

    properties.put("week", week);

    properties.store(new FileOutputStream("week"), null);
  }
}
