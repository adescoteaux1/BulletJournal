package cs3500.pa05.model;

import cs3500.pa05.model.Week;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * writes contents to a file
 */
public class WriteToFile {

  /**
   * writes contents of week to the bujo file
   *
   * @param bujoPath path of the file
   *
   * @param week object; contents will be written in the file
   *
   * @return a string of contents for the file
   * @throws IOException if there is an error
   */

  public static String write(String bujoPath, Week week) throws IOException {

    FileOutputStream f;
    ObjectOutputStream o;

    if (bujoPath.isEmpty()) {
      bujoPath = "newWeek.bujo";
      File output = new File(bujoPath);
      f = new FileOutputStream(bujoPath);
      o = new ObjectOutputStream(f);

    } else {
      f = new FileOutputStream(bujoPath);
      o = new ObjectOutputStream(f);
    }

    o.writeObject(week);
    o.close();
    f.close();
    return bujoPath;
  }
}
