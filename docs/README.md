# User Guide

## Features 

### Feature 1 
Description of feature.

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
<br>

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
<br>

### `event`

Adds an Event task into the task list. Prints the task added and the current number of tasks in the task list.

**Command:**

`event TASK_NAME /at DATE_TIME`

**Example of usage:** 

`DATE_TIME format: dd/MM/yyyy HHmm`

`event discuss TP /at 20/09/2020 1100`

**Expected outcome:**

```
____________________________________________________________
Got it. I've added this task:
[E][✘] discuss TP (at: Sep 20 2020, 11:00AM)
Now you have 3 tasks in the list.
____________________________________________________________
```
<br>

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
<br>

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
<br>

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
<br>

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
<br>

### `bye`

Exits the Duke application.

**Command:**

`bye`

**Example of usage:** 

`bye`

**Expected outcome:**

```
Bye. Hope to see you again soon!
```
