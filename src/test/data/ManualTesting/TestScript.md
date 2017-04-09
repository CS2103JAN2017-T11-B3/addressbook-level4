# Task Manager - Test Script

By : `Team CS2103JAN2017-T11-B3`  &nbsp;&nbsp;&nbsp;&nbsp; Since: `Jan 2017`

---

## 1. Start the application

1. Open the application

	Response:
	> * A welcome message will be shown in the message box. <br>
	> * Tasks that are scheduled on that day are shown in the "Task List Panel" on the left side of the window. <br>

2. Loading the sample data: `load taskmanager.xml`

	Response:
	> * The "Task List Panel" on the left is updated. <br>

3. List all tasks: `list`
	
	Response:
	> * All tasks in the Task Manager are shown in the "Task List Panel" on the left side of the window. <br>
	> * Use the scroll bar to view all tasks.
	> * The tasks are sorted in: <br>
			a. Complete-ness <br>
			b. Priority <br>
			c. Start date <br>
			d. End date <br>
			e. Alphabetical order of description <br>

4. Find a task: `find 11/04/2017`
 
	Response:
	> * All tasks that will be due on April 13, 2017 are shown in the "Task List Panel". <br>
	> * The message box will display the number of tasks displayed.

5. Viewing help: `help`

	Response:
	> * A new window which contains the full user guide of this application will be shown on the screen. <br>

## 2. Testing for `add` command

1. Add a normal task: `add Cook for mom sd/12/04/2017 ed/12/04/2017 p/1`
	
	Response:
	> * `New task added: Cook for mom Priority: 1 Start Timing: 12/04/2017 End Timing: 12/04/2017 Tags:` message is shown in the message box. <br>
	> * In the "Task List Panel", the corresponding task card is added. (Index: 8)

2. Adding a floating task (without end date): `add BBQ`

	Response:
	> * `New task added: bbq Priority: 3 Start Timing: floating End Timing: floating Tags:` message is shown in the message box. <br>

3. Adding a recurring task: `add Practice coding p/2 sd/10/04/2017 ed/10/04/2017 r/3d`

	Response:
	> * `New task added: Practice coding Priority: 2 Start Timing: 10/04/2017 End Timing: 10/04/2017 Tags:` message is shown in the message box. <br>
	> * In the "Task List Panel", the task "Practice code" is at index 26.
	> * A pink tag is labelled `Recurring Task: 3d` to indicate the recurring frequency is every 3 days.

4. Adding a task with timing (HH:MM): `add Eat McSpicy ed/01:00 10/04/2017 t/food`

	Response:
	> * Message `New task added: Eat McSpicy Priority: 3 Start Timing: floating End Timing: 01:00 10/04/2017 Tags: [food]` is shown in the message box. <br>

5. Adding a task with end date before start date: `add end before start sd/13/04/2017 ed/12/04/2017`

	Response:
	> * Error message `The start and end times are not in chronological order` is shown in the message box. <br>
	> * The command box turns to red to show that an error occurs.

6. Adding a task with priority level out of range: `add priority out of range p/4`

	Response:
	> * Error message `Task priority should be between 1-3` is shown in the message box. <br>
	> * The command box remains red to show that an error occurs.

7. Adding a task with invalid date: `add invalid date sd/40/13/2011`

	Response:
	> * Error message `Task timing should be in the format HH:mm dd/MM/yyyy OR dd/MM/yyyy Can use only HH:mm if today is the default date` is shown in the message box. <br>
	> * The command box remains red to show that an error occurs.

8. Adding a task without description: `add sd/11/04/2017`

	Response:
	> * Error message is shown and the help guide on proper usage of `add` command is shown. <br>
	> * The description field of the task is mandatory.

9. Adding a task with invalid timing: `add invalid timing sd/25:35 11/04/2017 ed/13:70 12/04/2017`

	Response:
	> * Error message `Task timing should be in the format HH:mm dd/MM/yyyy OR dd/MM/yyyy Can use only HH:mm if today is the default date` is shown in the message box. <br>
	> * The command box remains red to show that an error occurs

## 3. Testing for `find` command

1. Finding a task by key words: `find mOM`

	Response:
	> * The task "Cook for mom" and "Get Flowers for Mom" are listed in the "Task List Panel". <br>
	> * Message `2 tasks listed!` is shown in the message box. <br>
	> * The finding is case-insensitive

2. Find a task by fragments of key words: `find om`

	Response:
	> * No task is found. <br>
	> * Message `0 tasks listed!` is shown in the message box. <br>
	> * The finding can only search for the full words

3. Find a task by date: `find 12/04/2017`

	Response:
	> * Five tasks are listed on the left side of the screen. <br>
	> * The finding will search for both start date and end date.

4. Find a task by time: `find 14:00`

	Response:
	> * The task "cs3226 tutorial" is listed in the "Task List Panel". <br>
	> * The finding will search for both start date timing and end date timing.

## 4. Testing for `edit` command

1. Edit the description of task "Get a Bone for my Dog": `find bone` `edit 1 Buy bone`

	Response:
	> * The task "Get a Bone for my Dog" is listed in the "Task List Panel". <br>
	> * The task's description to "Buy bone". <br>
	> * Successful message `Edited Task: Buy bone Priority: 1 Start Timing: 27/03/2017 End Timing: 27/03/2017 Tags: [family]` is shown in the message box.

2. Edit a single occurrence of a recurring task: `list` `editthis 2 sd/02/01/2017 ed/02/01/2017`

	Response:
	> * All tasks are listed in the "Task List Panel". <br>
	> * The recurring task "Pay Electric Bill"'s first occurrence is extracted out as a new task and modified accordingly. <br>
	> * The result could be validated by using `find electric`.

## 5. Testing for `delete` command

1. Delete a normal task: `find submit` `delete 1`

	Response:
	> * The task "Submit 2103 Project" is listed in the "Task List Panel". <br>
	> * The task is deleted with successful message `Deleted Task: Submit 2103 Project Priority: 1 Start Timing: floating End Timing: 11:59 10/04/2017 Tags: ` in the message box.

2. Delete a single occurrence of a recurring task: `list` `deletethis 3`

	Response:
	> * All tasks are listed in the "Task List Panel". <br>
	> * The recurring task "cs3226 tutorial"'s first occurrence is extracted out and deleted. <br>
	> * The result could be validated by using `list` again.

## 6. Testing for `complete` command

1. Complete a non-recurring task: `find Cook for mom` `complete 1`

	Response:
	> * The task "Cook for mom" is listed in the "Task List Panel" firstly. <br>
	> * The task "Cook for mom" is marked as completed with a green tag with label "complete" <br>
	> * The task can be found at the bottom of the "Task List Panel".

2. Complete a recurring task: `find cs3226 tutorial` `complete 1`

	Response:
	> * The recurring task "cs3226 tutorial" is listed in the "Task List Panel" at index 1. <br>
	> * The recurring task's occurrence is updated to the next one. <br>
	> * The completed occurrence of the recurring task will be shown as a new completed normal task at the bottom of the "Task List Panel".

3. The index of the task to be completed could not be found: "find cs3226 tutorial" `complete 6`

	Response:
	> * The recurring task "cs3226 tutorial" and the completed occurrence of the same task are shown in the "Task List Panel". <br>
	> * Error message `The task index provided is invalid` is shown in the message box. <br>
	> * The command box turns to red to show that an error occurs.

## 7. Testing for `prioritize` command

1. Prioritize a normal task successfully: `find flowers` `prioritize 1 2`

	Response:
	> * The task "Get Flowers for Mom" is listed in the "Task List Panel" firstly. <br>
	> * The task "Get Flowers for Mom"'s priority level is updated from 1 to 2. <br>
	> * The find command will put the task to top of the list for validation.

2. Prioritize a recurring task successfully: `find cs3226` `prioritize 1 3`

	Response:
	> * The recurring task "cs3226 tutorial" is firstly listed in the "Task List Panel". <br>
	> * Prioritiy level of all occurrences of "cs3226 tutorial" will be updated from 1 to 3. <br>
	> * Validation could be done using `find` command to search for every single occurrences.

3. Keying in an invalid priority level: `find flower` `prioritize 1 4`

	Response:
	> * The task "Get Flowers for Mom" is listed in the "Task List Panel" firstly. <br>
	> * Error message `Task priority should be between 1-3` is shown in the message box.

4. Keying in an invalid task index: `find flower` `prioritize 0 2`

	Response:
	> * The task "Get Flowers for Mom" is listed in the "Task List Panel" firstly. <br>
	> * Error message describing the correct usage of `prioritize` command is shown in the message box.

## 8. Testing for `undo` and `redo`

1. Undo the previous change: `undo`

	Response:
	> * The previous change on the priority level of the recurring task "cs3226 tutorial" from 1 to 3 is reverted. <br>
	> * Use `find cs3226` to validate the result.

2. Redo the previous undo: `redo`

	Response:
	> * The previous undo on changing the priority level of the recurring task "cs3226 tutorial" from 3 to 1 is reverted.<br>
	> * Use `find cs3226` to validated the result.

3. Redo when there is nothing to redo: `redo`

	Response:
	> * Error message `Nothing to redo!` is shown in the message box. <br>

4. Undo twice, followed by completing a task, redo: `undo` `undo` `complete 2` `redo`

	Response:
	> * Two undos are made <br>
	> * The task "CS3226 Demo" is marked as complete. <br>
	> * Error message `Nothing to redo!` is shown in the message box.

5. Restart application, then undo and redo: `exit` Open the application `undo` `redo`

	Response:
	> * The application is closed. <br>
	> * The application is opened. <br>
	> * Error message `Nothing to undo!` is shown in the message box. <br>
	> * Error message `Nothing to redo!` is shown in the message box.

## 9. Testing for `clear` command

1. Clear the task manager: `clear` `undo`

	Response:
	> * The task manager is cleared with successful message `Task Manager has been cleared!` shown in the message box. <br>
	> * The full list is restored.

## 10. Testing for `save` command

1. Save the current list to a new path: `save newPath.xml`

	Response:
	> * Successful message `Tasks saved in location: newPath.xml` is shown in the message box.

## 11. Switch view in calender

1. Change the view of the calender to next month: key in `01/05/2017` in the input box in calender panel and click `Enter`

	Response:
	> * The calender view is switched to May from April with the first grid (top left) being 30th Apr.
