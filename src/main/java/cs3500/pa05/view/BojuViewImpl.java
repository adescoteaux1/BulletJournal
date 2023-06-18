package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import cs3500.pa05.model.Task;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * represents the main View class
 */
public class BojuViewImpl implements BojuView {
  private final FXMLLoader loader;

  @FXML
  private final VBox sideBar;


  /**
   * Loads an instance of a GUI layout from disk.
   *
   * @param controller is the controller
   */
  public BojuViewImpl(BojuController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
    this.loader.setController(controller);
    this.sideBar = new VBox();
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

  /**
   * displays task queue in the side bar
   *
   * @param tasks list of tasks
   */
  public void displayTaskQueue(List<Task> tasks) {
    sideBar.getChildren().clear();

    System.out.println("Task Queue:");
    for (Task task : tasks) {
      System.out.println(task.getName() + " - Complete: " + task.getIsComplete());
      Label name = new Label(task.getName());
      sideBar.getChildren().add(name);
    }
  }
}
