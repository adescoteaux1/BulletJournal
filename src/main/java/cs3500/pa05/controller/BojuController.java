package cs3500.pa05.controller;

import java.io.IOException;

/**
 * interface for controller
 */
public interface BojuController {

  /**
   * runs the program
   *
   * @throws IllegalStateException thrown if there's an error
   * @throws IOException thrown if there's an error
   */
  void run() throws IllegalStateException, IOException;
}
