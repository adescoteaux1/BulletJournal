package cs3500.pa05.controller;

import cs3500.pa05.view.BojuView;
import cs3500.pa05.view.BojuViewImpl;
import cs3500.pa05.view.MainMenuGui;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BojuControllerImpl implements BojuController {
  Stage stage;

  @FXML
  private Button newTask;
  @FXML
  private Button newEvent;
  @FXML
  private Button removeTask;
  @FXML
  private Button removeEvent;
  @FXML
  private Button viewWeek;
  @FXML
  private Button changeTheme;


  public BojuControllerImpl(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() throws IllegalStateException, IOException {
    BojuView bv = new BojuViewImpl(this);
    MainMenuGui mm = new MainMenuGui(this);
    stage.setScene(mm.load());
    mainMenu();
  }

  public void mainMenu() {
    newTask.setOnAction(e -> addTask());
    newEvent.setOnAction(e -> addEvent());
    removeTask.setOnAction(e -> deleteTask());
    removeEvent.setOnAction(e -> deleteEvent());
    viewWeek.setOnAction(e -> bulletJournal());
    changeTheme.setOnAction(e -> newTheme());
  }

  private void newTheme() {
    //To-Do
  }

  private void bulletJournal() {
    //To-Do
  }

  private void deleteEvent() {
    //To-Do
  }

  private void deleteTask() {
    //To-Do

  }

  private void addEvent() {
    //To-Do
  }

  private void addTask() {
    //To-Do
  }
}
