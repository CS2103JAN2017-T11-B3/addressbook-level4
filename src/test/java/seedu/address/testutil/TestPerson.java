package seedu.address.testutil;

import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.Description;
import seedu.address.model.task.TaskDate;
import seedu.address.model.task.Priority;
import seedu.address.model.task.ReadOnlyTask;

/**
 * A mutable person object. For testing only.
 */
public class TestPerson implements ReadOnlyTask {

    private Description description;
    private TaskDate taskDate;
    private Priority priority;
    private UniqueTagList tags;

    public TestPerson() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code personToCopy}.
     */
    public TestPerson(TestPerson personToCopy) {
        this.description = personToCopy.getDescription();
        this.priority = personToCopy.getPriority();
        this.taskDate = personToCopy.getDate();
        this.tags = personToCopy.getTags();
    }

    public void setName(Description description) {
        this.description = description;
    }

    public void setEmail(TaskDate taskDate) {
        this.taskDate = taskDate;
    }

    public void setPhone(Priority priority) {
        this.priority = priority;
    }

    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public TaskDate getDate() {
        return taskDate;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getDescription().description + " ");
        sb.append("p/" + this.getPriority().value + " ");
        sb.append("e/" + this.getDate().value + " ");
        this.getTags().asObservableList().stream().forEach(s -> sb.append("t/" + s.tagName + " "));
        return sb.toString();
    }
}
