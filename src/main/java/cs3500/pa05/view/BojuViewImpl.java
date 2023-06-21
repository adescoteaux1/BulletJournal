package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import cs3500.pa05.model.Action;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * represents the main View class
 */
public class BojuViewImpl implements BojuView {
  private final FXMLLoader loader;

  @FXML
  private final VBox sideBar;

  @FXML
  private TextArea quoteOrNote;

  @FXML
  private Label eventOrTask;

  @FXML
  private TextField details;
  @FXML
  private GridPane weekGrid;



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
    this.quoteOrNote = new TextArea();
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

  /**
   * makes a popup
   *
   * @param popup the popup created
   * @param stage of where the popup is placed
   */
  @FXML
  public void makePopup(Popup popup, Stage stage) {
    popup.show(stage);
  }

  public void addAction(Action action) {
    DayOfWeek day = action.getDayOfWeek();
    weekGrid.add(new Label(action.getName()), day.getValue(), 2);
  }


  /**
   * updates the quote/note area with user input
   *
   * @param userStatement is user input
   */
  public void addQuotOrNote(String userStatement) {
    quoteOrNote.setText(userStatement);
  }


  public void displayWeek(Week week) {
    //TODO: show week
  }
}
