package cs3500.pa05.view;

import cs3500.pa05.controller.BojuControllerImpl;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class WelcomeView implements BojuView{

  private FXMLLoader loader;

  public WelcomeView(BojuControllerImpl controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("splash.fxml"));
    this.loader.setController(controller);
  }

  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
