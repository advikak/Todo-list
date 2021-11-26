# Student To-do List

## A to-do list designed for students

**Who will use it?**
\
This application is made for students trying to stay organized. 
It will serve as a reminder to do certain tasks such as completing
assignments, attending tutorials, or whatever the user would like
to put down.

**Applicaton functions:**
- View task list
- Delete and add items to list
- View completed/incomplete tasks

**Why is this project of interest?**
\
As university students, we have loads of assignments, tests to 
study for, clubs to attend. The clutter of tasks we need to complete
can sometimes get very messy and difficult to keep track of. This 
application will aim to get rid of this clutter and keep a list of
your tasks organized.

## User Stories
**As a user, I want to be able to...**
- Create and add a task to my list
- View my todo list
- Remove a task from my todo list
- Mark a task as done on my list
- View list of completed tasks
- Have the option to save my todo list when quiting the app
- Have the option to load my todo list when starting the app

##Phase 4: Task 2
**Example of event log in console:**

Thu Nov 25 15:39:11 PST 2021\
Added a task: task 1\
Thu Nov 25 15:39:13 PST 2021\
Removed a task: task 1\
Thu Nov 25 15:39:20 PST 2021\
Added a task: task 2\
Thu Nov 25 15:39:20 PST 2021\
Loaded the list

## Phase 4: Task 3
**Reflection** \
There's less cohesion in my display class and my applicaton class, as it has 
many functionalities such as setting up the display, add/removing tasks and 
save/load functionality. 

- Create private nested classes for the different functions
- Create different classes for them
- Remove assocation between Display and todolist and have the todolistmodel have a 
getTodo method.
- Create an abstract class with methods useful to both the application/display class
