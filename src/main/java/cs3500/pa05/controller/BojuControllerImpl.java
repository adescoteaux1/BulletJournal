package cs3500.pa05.controller;

import static cs3500.pa05.model.DayOfWeek.FRIDAY;
import static cs3500.pa05.model.DayOfWeek.MONDAY;
import static cs3500.pa05.model.DayOfWeek.SATURDAY;
import static cs3500.pa05.model.DayOfWeek.SUNDAY;
import static cs3500.pa05.model.DayOfWeek.THURSDAY;
import static cs3500.pa05.model.DayOfWeek.TUESDAY;
import static cs3500.pa05.model.DayOfWeek.WEDNESDAY;

import cs3500.pa05.model.Action;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.BujoWriter;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.FileAppendable;
import cs3500.pa05.model.Writer;
import cs3500.pa05.view.UserInputView;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Popup;
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
  private Writer writer;
  private Popup popup;
  @FXML
  private Button createTaskButton;
  @FXML
  private TextField nameInput;
  @FXML
  private TextField descriptionInput;
  @FXML
  private ChoiceBox dayBox;
  @FXML
  private TextField startInput;
  @FXML
  private TextField durationInput;



  public BojuControllerImpl(Stage stage) {
    this.stage = stage;
    this.popup = new Popup();
    dayBox = new ChoiceBox(FXCollections.observableArrayList(
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY));
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
    Appendable output = new FileAppendable(Paths.get(bujoPath).toFile());
    writer = new BujoWriter(output);

    //button actions
    addTask.setOnAction(e -> {
      try {
        addTask();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    addEvent.setOnAction(e -> {
      try {
        addEvent();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    addNote.setOnAction(e -> Note());
    changeTheme.setOnAction(e -> newTheme());
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
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter Event to delete");

    enterButton.setOnAction(e -> {String eventToDelete = enterField.getText();});
    //call method to delete event to bujo
  }

  private void deleteTask() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter Task to delete");

    enterButton.setOnAction(e -> {String taskToDelete = enterField.getText();});
    //call method to delete task to bujo

  }

  private void addEvent() throws IOException {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the new Event");

    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newEvent.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add((Node)s.getRoot());
    enterButton.setOnAction(e -> {
      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      Object day = dayBox.getSelectionModel().getSelectedItem();
      String start = startInput.getText();
      String duration = durationInput.getText();
      Action newEvent = new Event(name, desc, (Day) day, start, duration);
      writer.write(newEvent.toString());
      popup.hide();
    });

    popup.getContent().add(enterButton);

    //enterButton.setOnAction(e -> {String newEvent = enterField.getText();
      //writer.write(newEvent);});
    //call method to add event to bujo
  }

  private void addTask() throws IOException {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the new Task");

    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newTask.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    popup.getContent().add((Node)s.getRoot());
    enterButton.setOnAction(e -> {
      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      Object day = dayBox.getSelectionModel().getSelectedItem();
      Action newTask = new Task(name, desc, (Day) day, false);
      writer.write(newTask.toString());
      popup.hide();
    });

    popup.getContent().add(enterButton);
  }

  @FXML
  private void makePopup() {
    this.popup.show(this.stage);
  }
}
