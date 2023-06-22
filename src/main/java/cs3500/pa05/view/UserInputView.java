package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * represents the ugui of the user input
 */
public class UserInputView implements BojuView {
  private final FXMLLoader loader;

  /**
   * Loads an instance of a GUI layout from disk.
   * @param controller is the controller class
   */
  public UserInputView(BojuController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("UserInput.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the scene from the GUI layout.
   *
   * @return the layout
   */
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
