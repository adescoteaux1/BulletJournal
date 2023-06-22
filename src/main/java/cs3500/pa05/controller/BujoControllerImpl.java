package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayOfWeek;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.ReadFile;
import cs3500.pa05.model.WriteToFile;
import cs3500.pa05.view.BujoViewImpl;
import cs3500.pa05.view.UserInputView;
import cs3500.pa05.view.WelcomeView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * represents a bujo controller implementation
 */
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
  private final Popup eventPopup;
  private final Popup taskPopup;
  private final Popup limitPopup;
  private final Popup qnotePopup;
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
  @FXML
  private Popup openPopup;
  private UserInputView uiv;
  private WelcomeView wv;
  @FXML
  private Button status;
  @FXML
  private VBox eventInfo = new VBox();
  @FXML
  private VBox taskInfo = new VBox();


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
    this.openPopup = new Popup();
    sideBar = new VBox();
    bvi = new BujoViewImpl(this);
    uiv = new UserInputView(this);
    wv = new WelcomeView(this);
  }

  /**
   * runs the bujo application
   *
   * @throws IllegalStateException if there is an error
   */
  @Override
  public void run() throws IllegalStateException {

    enterTitle.setText("Enter a .bujo file");
    enterButton.setOnAction(e -> {
      bujoPath = enterField.getText();

      if (uiv.validateFile(bujoPath)) {
        stage.setScene(bvi.load());

        try {
          week = ReadFile.readBujoFile(bujoPath);
          weekView();
        } catch (IOException | ClassNotFoundException ex) {
          throw new RuntimeException(ex);
        }
      }

    });
  }

  /**
   * saves contents to a bujo file
   *
   * @throws IOException if the file can't be written to
   *
   */
  public void save() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("UserInput.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    enterTitle.setText("Enter file name to save");
    openPopup.getContent().add(s.getRoot());

    enterButton.setOnAction(e -> {
      bujoPath = enterField.getText();
      openPopup.hide();
      try {
        bujoPath = WriteToFile.write(bujoPath, week);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }


    });

    openPopup.getContent().add(enterButton);
  }

  /**
   * view for week; button actions
   *
   * @throws IOException if there is an error in updating
   */
  public void weekView() throws IOException {
    //call method to read bujo file then setup view using bujo file
    week.setStartDay(startDay.getValue());

    //button actions
    addTask.setOnAction(e -> {
      if (week.getTaskLimit() <= week.getNumTasks()) {
        System.out.println("hit task limit");
      } else {
        bvi.makePopup(taskPopup, stage);
        try {
          addTask();
          week.setTaskNum(week.getNumTasks() + 1);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    addEvent.setOnAction(e -> {
      if (week.getEventLimit() <= week.getNumEvents()) {
        System.out.println("hit event limit");

      } else {
        bvi.makePopup(eventPopup, stage);
        try {
          addEvent();
          week.setEventNum(week.getNumEvents() + 1);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
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
        bvi.makePopup(openPopup, stage);
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
        bvi.makePopup(openPopup, stage);
        open();
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
    newWeek.setOnAction(e -> {
      try {
        week = ReadFile.readBujoFile("");
        bvi = new BujoViewImpl(this);
        stage.setScene(bvi.load());
        weekView();
      } catch (IOException | ClassNotFoundException ex) {
        throw new RuntimeException(ex);
      }
    });

    displayWeek(week);
  }

  /**
   * opens the beginning scene to enter a file path
   *
   * @throws IllegalStateException if there is an error
   * @throws IOException if there is an error
   */
  public void open() throws IllegalStateException, IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("UserInput.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    enterTitle.setText("Enter a .bujo file");
    openPopup.getContent().add(s.getRoot());

    enterButton.setOnAction(e -> {
      bujoPath = enterField.getText();
      openPopup.hide();
      try {
        week = ReadFile.readBujoFile(bujoPath);
        displayWeek(week);
      } catch (IOException | ClassNotFoundException ex) {
        throw new RuntimeException(ex);
      }

    });

    openPopup.getContent().add(enterButton);
  }

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
    limitPopup.getContent().add(s.getRoot());

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
    limitPopup.getContent().add(s.getRoot());

    enterButton.setOnAction(e -> {
      int eventLimit = Integer.parseInt(enterField.getText());
      limitPopup.hide();
      week.setEventLimit(eventLimit);
    });

    limitPopup.getContent().add(enterButton);
  }

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
    eventPopup.getContent().add(s.getRoot());

    enterButton.setOnAction(e -> {
      eventPopup.hide();

      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      DayOfWeek day = dayBox.getValue();
      String start = startInput.getText();
      String duration = durationInput.getText();
      Event newEvent = new Event(name, desc, day, start, duration);
      week.addEvent(newEvent);
      try {
        weekView();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    eventPopup.getContent().add(enterButton);
    displayWeek(week);
  }

  /**
   * opens a popup for adding a task and adds task
   *
   * @throws IOException if there's an error
   */
  private void addTask() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("newTask.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    taskPopup.getContent().add(s.getRoot());

    enterButton.setOnAction(e -> {
      String name = nameInput.getText();
      String desc = descriptionInput.getText();
      DayOfWeek day = dayBox.getValue();

      Task newTask = new Task(name, desc, day, false);

      status.setOnAction(event -> {
        newTask.setIsComplete(!newTask.getIsComplete());
      });

      taskPopup.hide();

      week.addTask(newTask);
      try {
        weekView();
        displayWeek(week);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

    });

    taskPopup.getContent().add(enterButton);
    displayWeek(week);
  }

  /**
   * adds qnote to the week
   *
   * @throws IOException if error occurs
   */
  private void addQnote() throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("qnotePop.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    qnotePopup.getContent().add(s.getRoot());

    finish.setOnAction(e -> {
      qnotePopup.hide();
      String qnote = userQnote.getText();

      //same

      //week update
      week.setQuoteOrNote(qnote);
      quoteOrNote.setText(week.getQuoteOrNote());
      try {
        weekView();
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
   * @throws IOException if there is an error in the week view
   */
  public void displayWeek(Week week) throws IOException {
    week.setStartDay(startDay.getValue());
    clearVboxes();

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
      } else {
        day7.setText(d.getDayOfWeek().getName());
      }


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
        if (t.getIsComplete()) {
          sideBar.getChildren().add(new Label(t.getName() + " - Complete"));
        } else {
          sideBar.getChildren().add(new Label(t.getName() + " - Not Complete"));
        }
      }
    }
  }

  /**
   * adds events on the grid
   *
   * @param d day of event
   * @param i represents a event
   */
  private void addEvents(Day d, int i) {

    if (i == 0) {
      for (Event e : d.getEvents()) {
        Button b = new Button(e.getName());
        b.setOnAction(ev -> {
          bvi.makePopup(eventOptionsPopup, stage);
          miniEventView(e);
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
          miniEventView(e);
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
          miniEventView(e);
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
          miniEventView(e);
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
          miniEventView(e);
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
          miniEventView(e);
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
          miniEventView(e);
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

  private void miniEventView(Event e) {
    eventInfo.getChildren().add(new Label("Name: " + e.getName()));
    eventInfo.getChildren().add(new Label("Description: " + e.getDescription()));
    eventInfo.getChildren().add(new Label("Day: " + e.getDayOfWeek().getName()));
    eventInfo.getChildren().add(new Label("Start Time: " + e.getStartTime()));
    eventInfo.getChildren().add(new Label("Duration: " + e.getDuration()));
  }

  private void miniTaskView(Task e) {
    taskInfo.getChildren().add(new Label("Name: " + e.getName()));
    taskInfo.getChildren().add(new Label("Description: " + e.getDescription()));
    taskInfo.getChildren().add(new Label("Day: " + e.getDayOfWeek().getName()));
    taskInfo.getChildren().add(new Label("Complete: " + e.getIsComplete()));
  }

  private void handleEventClick(Event event) throws IOException {
    FXMLLoader loader = new FXMLLoader(
        getClass().getClassLoader().getResource("EventWindow.fxml"));
    loader.setController(this);
    Scene s = loader.load();
    miniEventView(event);
    eventOptionsPopup.getContent().add(s.getRoot());

    eventDelete.setOnAction(e -> {
      eventOptionsPopup.hide();
      week.deleteEvent(event.getName());
      try {
        displayWeek(week);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

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
    eventClose.setOnAction(e -> eventOptionsPopup.hide());

    eventOptionsPopup.getContent().add(eventClose);
    displayWeek(week);
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
    miniTaskView(task);
    taskOptionsPopup.getContent().add(s.getRoot());

    taskDelete.setOnAction(e -> {
      taskOptionsPopup.hide();
      week.deleteTask(task.getName());
      try {
        displayWeek(week);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }

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
    taskClose.setOnAction(e -> taskOptionsPopup.hide());

    taskOptionsPopup.getContent().add(taskClose);
    displayWeek(week);
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
