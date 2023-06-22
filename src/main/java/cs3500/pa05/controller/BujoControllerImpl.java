package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.writer.WriteToFile;
import cs3500.pa05.view.BujoViewImpl;
import cs3500.pa05.view.UserInputView;
import cs3500.pa05.view.WelcomeView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BujoControllerImpl implements BujoController {
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
  //private Writer writer;
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
  private BujoViewImpl bvi;
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
  @FXML
  private Button save;
  @FXML
  private TextArea quoteOrNote;
  @FXML
  private ChoiceBox<DayOfWeek> startDay;
  @FXML
  private VBox day1Actions = new VBox();
  @FXML
  private VBox day2Actions = new VBox();
  @FXML
  private VBox day3Actions = new VBox();
  @FXML
  private VBox day4Actions = new VBox();
  @FXML
  private VBox day5Actions = new VBox();
  @FXML
  private VBox day6Actions = new VBox();
  @FXML
  private VBox day7Actions = new VBox();
  @FXML
  private Label day1;
  @FXML
  private Label day2;
  @FXML
  private Label day3;
  @FXML
  private Label day4;
  @FXML
  private Label day5;
  @FXML
  private Label day6;
  @FXML
  private Label day7;
  @FXML
  private Button refresh;
  @FXML
  private Button open;
  @FXML
  private Scene s;
  @FXML
  private Button newWeek;
  @FXML
  private Button eventDelete;
  @FXML
  private Button eventEdit;
  @FXML
  private Button eventClose;
  @FXML
  private Button taskDelete;
  @FXML
  private Button taskEdit;
  @FXML
  private Button taskClose;
  @FXML
  private Popup eventOptionsPopup;
  @FXML
  private Popup taskOptionsPopup;
  @FXML
  private VBox sideBar;
  private UserInputView uiv;
  private WelcomeView wv;


  /**
   * constructor for controller
   *
   * @param stage where all the scenes will be displayed
   */
  public BujoControllerImpl(Stage stage) {
    this.stage = stage;
    this.eventPopup = new Popup();
    this.taskPopup = new Popup();
    this.limitPopup = new Popup();
    this.qnotePopup = new Popup();
    eventOptionsPopup = new Popup();
    taskOptionsPopup = new Popup();
    sideBar = new VBox();
    bvi = new BujoViewImpl(this);
    uiv = new UserInputView(this);
    wv = new WelcomeView(this);
  }

  /**
   * runs the bujo application
   *
   * @throws IllegalStateException if there is an error
   * @throws IOException if runtime error occurs, class is not ofund, etc.
   */
  @Override
  public void run() throws IllegalStateException, IOException {
    //this.runSplash();
    enterTitle.setText("Enter a .boju file");
    enterButton.setOnAction(e -> {bujoPath = enterField.getText();

      if (uiv.validateFile(bujoPath)) {
        stage.setScene(bvi.load());

        //commented out for noe

        /*
        try {
          week = ReadFile.readBujoFile(bujoPath);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
          throw new RuntimeException(ex);
        } */
        try {
          List<Day> days = new ArrayList<>();
          this.week = new Week(days, 100, 100);
          WeekView();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

    });
  }

  /**
   * saves contents to a bujo file
   * @throws IOException
   */
  public void save() throws IOException {
   bujoPath = WriteToFile.write(bujoPath, week);
  }

  /**
   * view for week; button actions
   */
  public void WeekView() throws IOException {
    //call method to read bujo file then setup view using bujo file
    //Appendable output = new FileAppendable(Paths.get(bujoPath).toFile());
    //writer = new BujoWriter(output);
    week.setStartDay(startDay.getValue());

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
    save.setOnAction(e -> {
      try {
        save();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    refresh.setOnAction(e -> {
      try {
        displayWeek(week);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    open.setOnAction(e -> {
      try {
        run();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    s.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.E && e.isControlDown()) {
        addEvent.fire();
      } else if (e.getCode() == KeyCode.T && e.isControlDown()) {
        addTask.fire();
      } else if (e.getCode() == KeyCode.S && e.isControlDown()) {
        save.fire();
      } else if (e.getCode() == KeyCode.O && e.isControlDown()) {
        open.fire();
      } else if (e.getCode() == KeyCode.N && e.isControlDown()) {
        newWeek.fire();
      } else if (e.getCode() == KeyCode.DIGIT1 && e.isControlDown()) {
        setEventLimit.fire();
      } else if (e.getCode() == KeyCode.DIGIT2 && e.isControlDown()) {
        setTaskLimit.fire();
      } else if (e.getCode() == KeyCode.R && e.isControlDown()) {
        refresh.fire();
      } else if (e.getCode() == KeyCode.Q && e.isControlDown()) {
        addQnote.fire();
      }
    });

    displayWeek(week);
  }

  /*
  private void runSplash(){
    bvi.displaySplash();
    boolean userInteracted = waitForUserInteraction(2000);
    if (userInteracted) {
      bvi.displaySplash();
    } else {
      bvi.displaySplash();
    }
  }

  private static boolean waitForUserInteraction(int timeout) {
    Scanner scanner = new Scanner(System.in);

    // Check if the user clicked within the timeout duration
    long startTime = System.currentTimeMillis();
    while (System.currentTimeMillis() - startTime < timeout) {
      if (scanner.hasNextLine()) {
        scanner.nextLine(); // Discard user input
        return true; // User clicked, return true
      }
    }

    return false; // Timeout reached, return false
  } */

  /**
   * sets limit for tasks
   *
   * @throws IOException if there's an error
   */
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
      });

    limitPopup.getContent().add(enterButton);
  }

  /**
   * sets limit for events
   *
   * @throws IOException if there's an error
   */
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
      });

    limitPopup.getContent().add(enterButton);
  }
  /*

  private void Note() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter the Note");

    enterButton.setOnAction(e -> {String note = enterField.getText();});
    //call method to add note
  }

   */
/*
  private void deleteEvent() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter Event to delete");

    enterButton.setOnAction(e -> {String eventToDelete = enterField.getText();
    week.deleteEvent(eventToDelete);
      try {
        WeekView();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
  }

  private void deleteTask() {
    UserInputView uiv = new UserInputView(this);
    stage.setScene(uiv.load());
    enterTitle.setText("Enter Task to delete");

    enterButton.setOnAction(e -> {String taskToDelete = enterField.getText();
    week.deleteTask(taskToDelete);
      try {
        WeekView();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
  }

 */

  /**
   * opens popup for adding event
   *
   * @throws IOException if there's an error
   */
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
    });

    eventPopup.getContent().add(enterButton);
    displayWeek(week);
  }

  /**
   * opens a popup for adding a task
   *
   * @throws IOException if there's an error
   */
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
    });

    taskPopup.getContent().add(enterButton);
    displayWeek(week);
  }

  /**
   * adds qnote to week
   *
   * @throws IOException if error occurs
   */
  private void addQnote() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("qnotePop.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    qnotePopup.getContent().add((Node)s.getRoot());

    finish.setOnAction(e -> {
      qnotePopup.hide();
      String qnote = userQnote.getText();
      quoteOrNote.setText(qnote);

      //same
      bvi.addQuotOrNote(qnote);

      //week update
      week.setQuoteOrNote(qnote);
      try {
        WeekView();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    qnotePopup.getContent().add(finish);
    displayWeek(week);
  }

  /**
   * displays the week
   *
   * @param week is current week
   */
  public void displayWeek(Week week) throws IOException {
    week.setStartDay(startDay.getValue());

    for (int i = 0; i < 7; i++) {
      Day d = week.getDays().get(i);

      if (i == 0) {
        day1.setText(d.getDayOfWeek().getName());
      } else if (i == 1) {
        day2.setText(d.getDayOfWeek().getName());
      } else if (i == 2) {
        day3.setText(d.getDayOfWeek().getName());
      } else if (i == 3) {
        day4.setText(d.getDayOfWeek().getName());
      } else if (i == 4) {
        day5.setText(d.getDayOfWeek().getName());
      } else if (i == 5) {
        day6.setText(d.getDayOfWeek().getName());
      } else if (i == 6) {
        day7.setText(d.getDayOfWeek().getName());
      }

      clearVboxes();
      addEvents(d, i);
      addTasks(d, i);
      fillTaskQueue();
    }
  }

  /**
   * adds tasks to the task queue
   */
  private void fillTaskQueue() {
    sideBar.getChildren().clear();

    for (Day d : week.getDays()) {
      for (Task t : d.getTasks()) {
        sideBar.getChildren().add(new Label(t.getName()));
      }
    }
  }

  /**
   * adds events on the grid
   *
   * @param d day of event
   * @param i represents a event
   */
  private void addEvents(Day d, int i) throws IOException {

    if (i == 0) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day1Actions.getChildren().add(b);
      }
    } else if (i == 1) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day2Actions.getChildren().add(b);
      }
    } else if (i == 2) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day3Actions.getChildren().add(b);
      }
    } else if (i == 3) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day4Actions.getChildren().add(b);
      }
    } else if (i == 4) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day5Actions.getChildren().add(b);
      }
    } else if (i == 5) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day6Actions.getChildren().add(b);
      }
    } else if (i == 6) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          try {
            handleEventClick(e);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day7Actions.getChildren().add(b);
      }
    }
  }

  private void handleEventClick(Event event) throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("EventWindow.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    eventOptionsPopup.getContent().add((Node)s.getRoot());

    eventDelete.setOnAction(e -> {
      eventOptionsPopup.hide();
      week.deleteEvent(event.getName());

    });
    eventEdit.setOnAction(e -> {
      eventOptionsPopup.hide();
      week.deleteEvent(event.getName());
      bvi.makePopup(eventPopup, stage);
      try {
        addEvent();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    eventClose.setOnAction(e -> {
      eventOptionsPopup.hide();
    });

    eventOptionsPopup.getContent().add(eventClose);
  }


  /**
   * adds tasks on the grid
   *
   * @param d day of task
   * @param i represents a task
   */
  private void addTasks(Day d, int i) {
    if (i == 0) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day1Actions.getChildren().add(b);
      }
    } else if (i == 1) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day2Actions.getChildren().add(b);
      }
    } else if (i == 2) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day3Actions.getChildren().add(b);
      }
    } else if (i == 3) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day4Actions.getChildren().add(b);
      }
    } else if (i == 4) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day5Actions.getChildren().add(b);
      }
    } else if (i == 5) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day6Actions.getChildren().add(b);
      }
    } else if (i == 6) {
      for (Task t : d.getTasks()) {
        Button b = new Button(t.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(taskOptionsPopup, stage);
          try {
            handleTaskClick(t);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
        day7Actions.getChildren().add(b);
      }
    }
  }

  private void handleTaskClick(Task task) throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("TaskWindow.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    taskOptionsPopup.getContent().add((Node)s.getRoot());

    taskDelete.setOnAction(e -> {
      taskOptionsPopup.hide();
      week.deleteTask(task.getName());

    });
    taskEdit.setOnAction(e -> {
      taskOptionsPopup.hide();
      week.deleteTask(task.getName());
      bvi.makePopup(taskPopup, stage);
      try {
        addTask();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    taskClose.setOnAction(e -> {
      taskOptionsPopup.hide();
    });

    taskOptionsPopup.getContent().add(taskClose);
  }

  /**
   * clears vboxes in the grid
   */
  public void clearVboxes() {
    day1Actions.getChildren().clear();
    day2Actions.getChildren().clear();
    day3Actions.getChildren().clear();
    day4Actions.getChildren().clear();
    day5Actions.getChildren().clear();
    day6Actions.getChildren().clear();
    day7Actions.getChildren().clear();
  }

}
