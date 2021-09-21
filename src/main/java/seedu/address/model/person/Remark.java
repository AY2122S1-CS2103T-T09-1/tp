package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remarks in the address book.
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS = "Remarks can take any values, and it should not be blank";

    /*
     * The first character of the remarks must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code remarks}.
     *
     * @param remarks A valid remarks.
     */
    public Remark(String remarks) {
        requireNonNull(remarks);
        value = remarks;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
