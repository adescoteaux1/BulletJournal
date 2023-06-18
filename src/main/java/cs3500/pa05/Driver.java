package cs3500.pa05;

import cs3500.pa05.controller.BojuController;
import cs3500.pa05.controller.BojuControllerImpl;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * main Driver class to execute the program
 */
public class Driver extends Application {

  /**
   * Entry point for a bullet journal
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }

  /**
   * Starts the GUI for a game of Whack-A-Mole.
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    // add a title to the stage
    stage.setTitle("Weekly Bujo");

    BojuController bojuController = new BojuControllerImpl(stage);

    // instantiate a simple Whack-a-Mole GUI view
    try {

      // fetch the view's controller
      bojuController.run();

      // render the stage
      stage.show();
    } catch (IllegalStateException | IOException e) {
      System.err.println("Unable to load GUI.");
    }
  }
}
