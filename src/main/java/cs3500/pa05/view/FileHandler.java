package cs3500.pa05.view;

import cs3500.pa05.model.Week;
import java.io.File;
import javafx.stage.FileChooser;

/**
 * class to handle persistence
 */
public class FileHandler {
  private Week week;

  /**
   * constructor for week
   *
   * @param week chosen week
   */
  public FileHandler(Week week) {
    this.week = week;
  }

  public void saveToFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save as .bujo File");
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter(".bujo Files", "*.bujo")
    );
    File selectedFile = fileChooser.showSaveDialog(null);

    if (selectedFile != null) {
      // Save the Week data to the selected file
      // Serialize the Week object and write it to the file
      // Update the UI or show a confirmation message
    }
  }

  public void openFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open .bujo File");
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter(".bujo Files", "*.bujo")
    );
    File selectedFile = fileChooser.showOpenDialog(null);

    if (selectedFile != null) {
      // Load the Week data from the selected file
      // Deserialize the JSON data and create a Week object
      // Update the UI with the loaded Week data
    }
  }

}
