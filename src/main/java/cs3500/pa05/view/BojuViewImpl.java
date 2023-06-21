package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
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
  private Button addQnote;

  @FXML
  private Label eventOrTask;

  @FXML
  private TextField details;






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
   * Sets the quote or note in the view
   *
   * @param text the quote or note text
   */
  public void setQuoteOrNote(String text) {
    quoteOrNote.equals(text);
  }

  //these methods are to simulate a mini viewer -> might need edits
  public void openEventWindow(Event event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("event.fxml"));
      Parent root = loader.load();

      //EventWindowController controller = loader.getController();
      //controller.setEvent(event);

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Event Details");
      eventOrTask.setText("Selected Event: " + event.getName());
      details.setText(event.getDescription() + "\n Start Time: "
      + event.getStartTime() + "\n Duration: " + event.getDuration());
      stage.setScene(new Scene(root));
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openTaskWindow(Task task) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("TaskWindow.fxml"));
      Parent root = loader.load();

      //TaskWindowController controller = loader.getController();
      //controller.setTask(task);

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Task Details");
      eventOrTask.setText("Selected Task: " + task.getName());
      details.setText(task.getDescription() + "\n Status: "
          + task.getIsComplete());
      stage.setScene(new Scene(root));
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void makePopup(Popup popup, Stage stage) {
    popup.show(stage);
  }


  /**
   * updates the quote/note area with user input
   * @param userStatement
   */
  public void addQuotOrNote(String userStatement) {
    Stage stage = new Stage();
    stage.setTitle("Text Area Button Example");
    quoteOrNote.setText(userStatement);
  }




}
