//@@author A0164212U
package seedu.task.model.task;

import seedu.task.commons.exceptions.IllegalValueException;

/**
 * Represents a Task's frequency in the ToDo list.
 * Guarantees: immutable; is valid as declared in {@link #isValidFrequency(String)}
 */
public class RecurringFrequency {

    public static final String MESSAGE_DESCRIPTION_CONSTRAINTS =
            "Frequency must be a number followerd by h, d, m (no spaces)";

    public static final String FREQUENCY_VALIDATION_REGEX = "^[0-9]+[hdmHDM]";
    public static final String NULL_FREQUENCY = "0";

    public final String frequency;

    public static final int HOUR_LIMIT = 168; //one week
    public static final int DAY_LIMIT = 60; //two months
    public static final int MONTH_LIMIT = 12; //one year

    /**
     * Validates given frequency.
     *
     * @throws IllegalValueException if given frequency string is invalid.
     */
    public RecurringFrequency(String frequency) throws IllegalValueException {
        if (frequency != null) {
            String trimmedFrequency = frequency.trim();
            if (!isValidDescription(trimmedFrequency)) {
                throw new IllegalValueException(MESSAGE_DESCRIPTION_CONSTRAINTS);
            }
            this.frequency = trimmedFrequency;
        } else {
            this.frequency = NULL_FREQUENCY;
        }
    }

    /**
     * Returns true if a given string is a valid frequency.
     */
    public static boolean isValidDescription(String test) {
        return test.matches(FREQUENCY_VALIDATION_REGEX) || test.equals(NULL_FREQUENCY);
    }

    @Override
    public String toString() {
        return frequency;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RecurringFrequency // instanceof handles nulls
                        && this.frequency.equals(((RecurringFrequency) other).frequency)); // state check
    }

    @Override
    public int hashCode() {
        return frequency.hashCode();
    }

    public int getFrequencyNumber() {
        String numberOnlyString = frequency.replaceAll("[^0-9]", "");
        int numberOnly = Integer.parseInt(numberOnlyString);
        return numberOnly;
    }

    public String getFrequencyCharacter() {
        String characterOnly = frequency.replaceAll("[^A-Za-z]", "");
        return characterOnly;
    }
}
