package cs3500.pa05.model.writer;

/**
 * Handles writing outputs.
 */
public interface Writer {
  /**
   * Writes a given message.
   *
   * @param value the content to write
   */
  void write(String value);
}
