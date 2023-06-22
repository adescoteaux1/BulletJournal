package cs3500.pa05.view;

import cs3500.pa05.controller.BojuController;
import cs3500.pa05.model.Action;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
  private GridPane weekGrid = new GridPane();
  @FXML
  private VBox day1Actions;
  @FXML
  private VBox day2Actions;
  @FXML
  private VBox day3Actions;
  @FXML
  private VBox day4Actions;
  @FXML
  private VBox day5Actions;
  @FXML
  private VBox day6Actions;
  @FXML
  private VBox day7Actions;



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
    this.loader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
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

  /**
   * adds an action in view
   *
   * @param action that needs to be added
   */
  public void addAction(Action action) {
    DayOfWeek day = action.getDayOfWeek();
    //weekGrid.add(new Label(action.getName()), day.getValue(), 2);
  }


  /**
   * updates the quote/note area with user input
   *
   * @param userStatement is user input
   */
  public void addQuotOrNote(String userStatement) {
    quoteOrNote.setText(userStatement);
  }


  /**
   * displays the week
   *
   * @param week is current week
   */
  public void displayWeek(Week week) {
    //TODO: show week
    for (int i = 0; i < 7; i++) {
      Day d = week.getDays().get(i);
      weekGrid.add(new Label(d.getDayOfWeek().getName()), i, 1);
      addEvents(d, i);
      addTasks(d, i);
    }
  }

  private void addEvents(Day d, int i) {
    if (i == 0) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day1Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 1) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day2Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 2) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day3Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 3) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day4Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 4) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day5Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 5) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day6Actions.getChildren().add(new Button(e.getName()));
      }
    } else if (i == 6) {
      for (Event e : d.getEvents()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day7Actions.getChildren().add(new Button(e.getName()));
      }
    }
  }

  private void addTasks(Day d, int i) {
    if (i == 0) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day1Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 1) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day2Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 2) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day3Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 3) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day4Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 4) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day5Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 5) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day6Actions.getChildren().add(new Button(t.getName()));
      }
    } else if (i == 6) {
      for (Task t : d.getTasks()) {
        weekGrid.add(new VBox(new Button(d.getDayOfWeek().getName())), i, 2);
        //day7Actions.getChildren().add(new Button(t.getName()));
      }
    }
  }
}
