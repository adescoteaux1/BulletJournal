[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

Week GUI View (Temporary):
![WeekGUI.png](WeekGUI.png)




NOTE: all the images listed below are also manually in the project
      (this is in case the png images below don't show up)
Final Week GUI:
![img.png](img.png)

Additional UI Images: 
![img_1.png](img_1.png)
![img_2.png](img_2.png)

Program Pitch: 
The Bujo Bullet Journal App is the perfect app for those looking to add a personalized and
fun approach to organizing and time management! With this new app users are presented with a
neat, organized panel showcasing all events and tasks listed below each day. Tasks and events
can be added, edit, and deleted depending on user preference. All actions (task or events) get a 
name, optional description, and day to which the action is assigned. Start and end time can be 
adjusted for events, and completion status can be marked for tasks. All tasks will be depicted in the 
BuJo's Task Queue to act as a to-do list for the user. The BuJo app contains a light purple-lilac
theme, easy on the eyes, and perfect for creating a positive environment around the user's weekly
actions. With this BuJo app, people can lay out their weekly schedule with a few easy clicks and save
it in new .bujo files for later use!



SOLID Principles
Single Responsibility Principle: The UserInputView class is located in the View folder of this project.
This class, like all view classes, implements teh BujoView interface. This class is only responsible for 
loading the first scene the program displays once executed. This class has one responsibility: to load 
the correct fxml file and make sure the user's input in the scene that appears is a valid input, it
has no other responsibility or function, therefore following the single responsibility principle.

Open/Close Principle: The BujoViewImpl class implements the interface BuJoView and displays the scenes
for the BuJo application. This class is closed for modification, as it contains methods that showcase
the GUIs for a week and popups. Because this class implements the BoJuView interface, it is extendable
when new functionality needs to be added. For example, in this prpject when displaying the welcome 
screen or displaying the user input screen was needed, code inside the BuJoViewImpl class did not need 
to be altered. Instead, new classes were created for these two new functionalities, both of which 
implemented the same BoJuView interface. This made it possible for all 3 view classes to implement the
load() method slightly differently to display the correct scene for the program. If a new functionality
needed to be added in the future, it would be easy to create a new view for that functionality.

Liskov Substitution Principle: The Event and Task classes extend the Action class. Therefore, an Event 
or Task is by definition an Action through extension. The two classes share the same 3 fields of name,
description , and dayOfWeek. This way if at any point Action needs to be instantiated, it can be
instantiated as an Event or Task, depending on the program requirements. This instantiation was not 
used much in our program, since most of the time it was easier to create a new Event or new Task, however
by following the Liskov pprinciple, if any extensions are added where the instantiation of an Action is
required, it would be possible.

Interface Segregation Principle: All of our classes that implement a view or display something implement 
the BuJoView interface. This makes it so that all the code in each of the classes don't have to rely on 
methods they don't use. Each class can implement the method declared in the BuJoVeiew interface, load(). 
By implemeting this interface, classes in the view folder that absolutely need the load() method can implement 
this interface, and any classes that wouldn't need this method would not have to rely on the interface.

Dependency Inversion Principle: The Event and Task classes use abstraction and are an extension of the 
Action class. This makes it so Event and Task share similar elements, but also different ones that are
personalized to the specific class. Action contains a few getter methods, which can be implemented for both
Event or Task. Individually, Event has specific methods for an Event that manage fields it does not share 
with Task; the same can be said for Task. This shows that there are no high-level modules that not depend 
on low-level modules, but rather the classes Event and Task depend on the same abstraction from the Action 
class.


Extensions and More: 
This program can be extend to add additional features such as a splash screen. A new class in the view 
folder can be created. This class should implement the BuJoView interface and load a new fxml file displaying
a Welcome screen; this screen would act as the splash screen. In this class, a method that registers user
interaction can be created; this method should return a boolean. This way, for the run() method in the
BuJoControllerImpl class, the splash screen can be loaded for a set amount of time before changing the 
scene and following the rest of the application. To implement this successfully, additional changes in Driver
would be required to load the current view GUI.