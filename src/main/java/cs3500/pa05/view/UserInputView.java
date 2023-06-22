package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

  public boolean validateFile(String userInput) {
    Path path = Paths.get(userInput);

    if (!Files.exists(path)) {
      return false;
    }

    String fileExtension = getFileExtension(path);
    if (!fileExtension.equalsIgnoreCase("bujo")) {
      System.out.println("Invalid file extension. Expected .bujo file.");
      return false;
    }

    return true;
  }

  private static String getFileExtension(Path path) {
    String fileName = path.getFileName().toString();
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
  }
}
