package cs3500.pa05.controller;

import cs3500.pa05.model.Action;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.JsonUtils;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.writer.BujoWriter;
import cs3500.pa05.model.writer.FileAppendable;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.writer.ReadFile;
import cs3500.pa05.model.writer.WriteToFile;
import cs3500.pa05.model.writer.Writer;
import cs3500.pa05.view.BojuView;
import cs3500.pa05.view.BojuViewImpl;
import cs3500.pa05.view.UserInputView;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BojuControllerImpl implements BojuController {
  Stage stage;
  String bujoPath;
  Week week;

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
  private Button addNote;
  private Writer writer;
  private Popup eventPopup;
  private Popup taskPopup;
  private Popup limitPopup;
  private Popup qnotePopup;
  @FXML
  private Button createTaskButton;
  @FXML
  private TextField nameInput;
  @FXML
  private TextField descriptionInput;
  @FXML
  private ChoiceBox<DayOfWeek> dayBox;
  @FXML
  private TextField startInput;
  @FXML
  private TextField durationInput;
  private BojuViewImpl bvi;
  @FXML
  private GridPane weekGrid;
  @FXML
  private Button addQnote;
  @FXML
  private Button finish;
  @FXML
  private TextField userQnote;
  @FXML
  private Button setTaskLimit;
  @FXML
  private Button setEventLimit;




  public BojuControllerImpl(Stage stage) {
    this.stage = stage;
    this.eventPopup = new Popup();
    this.taskPopup = new Popup();
    this.limitPopup = new Popup();
    this.qnotePopup = new Popup();
    bvi = new BojuViewImpl(this);
  }

  @Override
  public void run() throws IllegalStateException, IOException {
    enterTitle.setText("Enter a .boju file");

    enterButton.setOnAction(e -> {bujoPath = enterField.getText();
      stage.setScene(bvi.load());
      try {
        week = ReadFile.readBujoFile(bujoPath);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      WeekView();});
  }

  public void save() throws IOException {
    WriteToFile.write(bujoPath, week);
  }

  public void WeekView() {
    //call method to read bujo file then setup view using bujo file
    Appendable output = new FileAppendable(Paths.get(bujoPath).toFile());
    writer = new BujoWriter(output);

    //button actions
    addTask.setOnAction(e -> {
      bvi.makePopup(taskPopup, stage);
      try {
        addTask();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    addEvent.setOnAction(e -> {
      bvi.makePopup(eventPopup, stage);
      try {
        addEvent();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    setTaskLimit.setOnAction(e -> {
      bvi.makePopup(limitPopup, stage);
      try {
        setTaskLimit();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    setEventLimit.setOnAction(e -> {
      bvi.makePopup(limitPopup, stage);
      try {
        setEventLimit();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    addQnote.setOnAction(e -> {
      bvi.makePopup(qnotePopup, stage);
      try {
        addQnote();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    //removeTask.setOnAction(e -> deleteTask());
    //deEvent.setOnAction(e -> deleteEvent());
  }

  private void setTaskLimit() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("UserInput.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    enterTitle.setText("Enter the Task Limit");
    limitPopup.getContent().add((Node)s.getRoot());

    enterButton.setOnAction(e -> {
      limitPopup.hide();
      int taskLimit = Integer.parseInt(enterField.getText());
      week.setTaskLimit(taskLimit);
      WeekView();});

    limitPopup.getContent().add(enterButton);
  }

  private void setEventLimit() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("UserInput.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    enterTitle.setText("Enter the Event Limit");
    limitPopup.getContent().add((Node)s.getRoot());

    enterButton.setOnAction(e -> {
      int eventLimit = Integer.parseInt(enterField.getText());
      limitPopup.hide();
      week.setEventLimit(eventLimit);
      WeekView();});

    limitPopup.getContent().add(enterButton);
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

    enterButton.setOnAction(e -> {String eventToDelete = enterField.getText();
    week.deleteEvent(eventToDelete);
    WeekView();
    });
  }

  private void deleteTask() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter Task to delete");

    enterButton.setOnAction(e -> {String taskToDelete = enterField.getText();
    week.deleteTask(taskToDelete);
    WeekView();});
  }

  private void addEvent() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newEvent.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    eventPopup.getContent().add((Node)s.getRoot());

    enterButton.setOnAction(e -> {
      eventPopup.hide();

      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      DayOfWeek day = dayBox.getValue();
      String start = startInput.getText();
      String duration = durationInput.getText();
      Event newEvent = new Event(name, desc, day, start, duration);
      week.addEvent(newEvent);
      addAction(newEvent);
      writer.write(JsonUtils.serializeRecord(new EventJson(newEvent)).toString());
    });

    eventPopup.getContent().add(enterButton);
  }

  private void addTask() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newTask.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    taskPopup.getContent().add((Node)s.getRoot());

    enterButton.setOnAction(e -> {
      taskPopup.hide();
      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      DayOfWeek day = dayBox.getValue();
      Task newTask = new Task(name, desc, day, false);
      week.addTask(newTask);
      addAction(newTask);
      writer.write(JsonUtils.serializeRecord(new TaskJson(newTask)).toString());
    });

    taskPopup.getContent().add(enterButton);
  }

  public void addAction(Action action) {
    DayOfWeek day = action.getDayOfWeek();
    weekGrid.add(new Label(action.getName()), day.getValue(), 2);
  }

  private void addQnote() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newQnote.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    qnotePopup.getContent().add((Node)s.getRoot());

    finish.setOnAction(e -> {
      qnotePopup.hide();
      String qnote = userQnote.getText();
      bvi.addQuotOrNote(qnote);
      week.setQuoteOrNote(qnote);
      WeekView();
    });

    qnotePopup.getContent().add(finish);
  }

}
