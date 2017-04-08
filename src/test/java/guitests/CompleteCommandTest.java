//@@author A0113795Y
package guitests;

import static org.junit.Assert.assertTrue;
import static seedu.task.logic.commands.CompleteCommand.MESSAGE_COMPLETE_TASK_SUCCESS;

import org.junit.Test;

import guitests.guihandles.TaskCardHandle;
import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.testutil.TaskBuilder;
import seedu.task.testutil.TestTask;

public class CompleteCommandTest extends AddressBookGuiTest {
    TestTask[] currentList = td.getTypicalTasks();

    @Test
    public void completeSuccess() throws IllegalValueException {
        commandBox.runCommand("clear");
        for (int i = 0; i < currentList.length; i++) {
            commandBox.runCommand(currentList[i].getAddCommand());
        }

        String completeTag = "complete";
        TestTask taskToComplete = currentList[0];
        TestTask taskCompleted = new TaskBuilder(taskToComplete).withTags(completeTag).build();


        int taskListIndex = 1;
        assertCompleteSuccess(taskListIndex, taskListIndex, taskCompleted);
    }

    private void assertCompleteSuccess(int taskListIndex, int currentListIndex,
            TestTask completedTask) {

        commandBox.runCommand("complete " + taskListIndex);

        TaskCardHandle completedCard =
                taskListPanel.navigateToTask(completedTask.getDescription().toString());
        assertMatching(completedTask, completedCard);
        currentList[currentListIndex - 1] = completedTask;
        assertTrue(taskListPanel.isListMatching(currentList));
        assertResultMessage(String.format(MESSAGE_COMPLETE_TASK_SUCCESS, completedTask));
    }
}
