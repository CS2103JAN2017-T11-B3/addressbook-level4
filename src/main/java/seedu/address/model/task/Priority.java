package seedu.address.model.task;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Task's priority number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPriority(String)}
 */
public class Priority {

    public static final String MESSAGE_PRIORITY_CONSTRAINTS = "Task priority should be between 1-3";
    

    public final String value;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Priority(String priority) throws IllegalValueException {
        assert priority != null;
        String trimmedPriority = priority.trim();
        if (!isValidPriority(trimmedPriority)) {
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
        this.value = trimmedPriority;
    }

    /**
     * Returns true if a given string is a valid task priority.
     */
    public static boolean isValidPriority(String test) {
        return (test == "1" || test == "2" || test == "3");
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Priority // instanceof handles nulls
                && this.value.equals(((Priority) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}