package cs3500.pa05.controller;

import cs3500.pa05.view.BojuViewImpl;
import cs3500.pa05.view.UserInputView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class BojuControllerImpl implements BojuController {
  Stage stage;
  String bujoPath;

  @FXML
  private Label enterTitle;
  @FXML
  private TextField enterField;
  @FXML
  private Button enterButton;
  @FXML
  private Button addTask;
  @FXML
  private Button addEvent;
  @FXML
  private ToggleButton changeTheme;
  @FXML
  private Button addNote;



  public BojuControllerImpl(Stage stage) {
    this.stage = stage;
  }

  @Override
  public void run() throws IllegalStateException, IOException {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter a .bujo file");

    enterButton.setOnAction(e -> {bujoPath = enterField.getText();
    WeekView();});


  }

  public void WeekView() {
    //call method to read bujo file then setup view using bujo file


    //button actions

    //addTask.setOnAction(e -> addTask());
    //addEvent.setOnAction(e -> addEvent());
    //addNote.setOnAction(e -> Note());
    //changeTheme.setOnAction(e -> newTheme());
    //removeTask.setOnAction(e -> deleteTask());
    //removeEvent.setOnAction(e -> deleteEvent());
  }

  private void newTheme() {
    //To-Do
  }

  private void Note() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the Note");

    enterButton.setOnAction(e -> {String note = enterField.getText();});
    //call method to add note
  }

  private void deleteEvent() {
    //To-Do
  }

  private void deleteTask() {
    //To-Do

  }

  private void addEvent() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the new Event");

    enterButton.setOnAction(e -> {String newEvent = enterField.getText();});
    //call method to add event to bujo
  }

  private void addTask() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the new Task");

    enterButton.setOnAction(e -> {String newTask = enterField.getText();});
    //call method to add task to bujo
  }
}
