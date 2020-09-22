# User Guide

## Quick start

1. Ensure that you have **Java 11** or above installed in your computer.

2. Download the latest `Duke.jar` from [here](https://github.com/dozenmatter/ip/releases).

3. Copy the file to the folder you want as your *home folder* for Duke.

4. Open your command line or terminal and navigate into the file directory where you saved the Duke application.

5. Run the command ```java -jar Duke.jar``` to launch Duke. You should see the following *welcome* screen.
    ```
    Hello from
     ____        _        
    |  _ \ _   _| | _____ 
    | | | | | | | |/ / _ \
    | |_| | |_| |   <  __/
    |____/ \__,_|_|\_\___|

    Hello! I'm Duke
    What can I do for you?
    ____________________________________________________________
    ```

7. Type a command in the command line and press *Enter* to execute it.

8. Refer to the Usage below for details of each command.


## Features 

### Task List
Allows you to create your own task list by adding, removing and marking of tasks.

### Data Saving
Changes in task list is automatically saved into a local file and loaded on program start.


## Usage

### `todo`

Adds a ToDo task into the task list. The program prints the task added and the current number of tasks in the task list.

**Command:**

`todo TASK_NAME`

**Example of usage:** 

`todo eat`

**Expected outcome:**

```
____________________________________________________________
Got it. I've added this task:
[T][✘] eat
Now you have 1 tasks in the list.
____________________________________________________________
```


### `deadline`

Adds a Deadline task into the task list. The program prints the task added and the current number of tasks in the task list.

**Command:**

`deadline TASK_NAME /by DATE_TIME`

`DATE_TIME format: dd/MM/yyyy HHmm`

**Example of usage:** 

`deadline submit IP /by 16/09/2020 2359`

**Expected outcome:**

    ```
    ____________________________________________________________
    Got it. I've added this task:
    [D][✘] submit IP (by: Sep 16 2020, 11:59PM)
    Now you have 2 tasks in the list.
    ____________________________________________________________
    ```


### `event`

Adds an Event task into the task list. Prints the task added and the current number of tasks in the task list.

**Command:**

`event TASK_NAME /at DATE_TIME`

`DATE_TIME format: dd/MM/yyyy HHmm`

**Example of usage:** 

`event discuss TP /at 20/09/2020 1100`

**Expected outcome:**

    ```
    ____________________________________________________________
    Got it. I've added this task:
    [E][✘] discuss TP (at: Sep 20 2020, 11:00AM)
    Now you have 3 tasks in the list.
    ____________________________________________________________
    ```


### `list`

Displays all tasks in the task list.

**Command:**

`list`

**Example of usage:** 

`list`

**Expected outcome:**

    ```
    ____________________________________________________________
    Here are the tasks in your list:
    1. [T][✘] eat
    2. [D][✘] submit IP (by: Sep 16 2020, 11:59PM)
    3. [E][✘] discuss TP (at: Sep 20 2020, 11:00AM)
    ____________________________________________________________
    ```


### `done`

Marks a task as done in the task list.

**Command:**

`done TASK_NUMBER`

**Example of usage:** 

`done 1`

**Expected outcome:**

    ```
    ____________________________________________________________
    Nice! I've marked this task as done:
    [T][✓] eat
    ____________________________________________________________
    ```


### `delete`

Removes a task from the task list. Prints the task deleted and the current number of tasks in the task list.

**Command:**

`delete TASK_NUMBER`

**Example of usage:** 

`delete 1`

**Expected outcome:**

    ```
    ____________________________________________________________
    Noted. I've removed this task:
    [T][✓] eat
    Now you have 2 tasks in the list.
    ____________________________________________________________
    ```


### `find`

Finds a task by keyword. Prints the list of tasks found.

**Command:**

`find KEYWORD`

**Example of usage:** 

`find IP`

**Expected outcome:**

    ```
    ____________________________________________________________
    Here are the matching tasks in your list:
    1. [D][✘] submit IP (by: Sep 16 2020, 11:59PM)
    ____________________________________________________________
    ```


### `bye`

Exits the Duke application with goodbye message.

**Command:**

`bye`

**Example of usage:** 

`bye`

**Expected outcome:**

    ```
    Bye. Hope to see you again soon!
    ```
