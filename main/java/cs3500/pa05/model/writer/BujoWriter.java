package cs3500.pa05.model.writer;

import cs3500.pa05.model.writer.Writer;
import java.io.IOException;
import java.util.Objects;

/**
 * represents a bujo writer
 */
public class BujoWriter implements Writer {
  private Appendable appendable;


  /**
   * initializes a bujo writer
   *
   * @param appendable the appendable to append to
   */
  public BujoWriter(Appendable appendable) {
    this.appendable = Objects.requireNonNull(appendable);
  }

  /**
   * Writes a given message.
   *
   * @param phrase the content to write
   */
  @Override
  public void write(String phrase) {
    try {
      appendable.append(phrase);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}


