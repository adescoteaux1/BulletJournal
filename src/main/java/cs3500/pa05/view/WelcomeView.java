package cs3500.pa05.view;

import cs3500.pa05.controller.BujoController;
import cs3500.pa05.controller.BujoControllerImpl;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * represents the gui of the welcome screen
 */
public class WelcomeView implements BujoView {

  private final FXMLLoader loader;

  /**
   * initializes a welcome view
   *
   * @param controller the controller to use
   */
  public WelcomeView(BujoController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("splash.fxml"));
    this.loader.setController(controller);
  }

  @Override
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
