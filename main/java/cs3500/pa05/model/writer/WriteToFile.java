package cs3500.pa05.model.writer;


import com.fasterxml.jackson.databind.util.JSONPObject;
import cs3500.pa05.model.Week;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;


public class WriteToFile {

  public static String write(String bujoPath, Week week) throws IOException {

    FileOutputStream f;
    ObjectOutputStream o;

    Properties properties = new Properties();
    properties.put("week", week);

    if (bujoPath.isEmpty()) {
      bujoPath = "newWeek.bujo";
      File output = new File(bujoPath);
      f = new FileOutputStream(new File(bujoPath));
      o = new ObjectOutputStream(f);

    } else {
      f = new FileOutputStream(new File(bujoPath));
      o = new ObjectOutputStream(f);
    }

    o.writeObject(week);
    o.close();
    f.close();
    return bujoPath;
  }
}
