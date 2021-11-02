package seedu.address.model.studyspot;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a StudySpot's rating in the study tracker.
 * Guarantees: immutable; is valid as declared in {@link #isValidRating(String)}
 */
public class Rating {


    public static final String MESSAGE_CONSTRAINTS =
            "Ratings should only contain numbers, and it should only be a digit from 1 to 5";
    public static final String VALIDATION_REGEX = "^[0-5]$";
    public final String value;

    /**
     * Constructs a {@code Rating}.
     *
     * @param rating A valid rating number.
     */
    public Rating(String rating) {
        requireNonNull(rating);
        checkArgument(isValidRating(rating), MESSAGE_CONSTRAINTS);
        value = rating;
    }

    /**
     * Returns true if a given string is a valid rating.
     */
    public static boolean isValidRating(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Rating // instanceof handles nulls
                && value.equals(((Rating) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
