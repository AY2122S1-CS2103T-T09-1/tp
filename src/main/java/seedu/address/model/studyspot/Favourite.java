package seedu.address.model.studyspot;

import static java.util.Objects.requireNonNull;

/**
 * Represents if a StudySpot is a favourite in the study tracker.
 * Guarantees: immutable;
 */
public class Favourite {

    public static final String MESSAGE_CONSTRAINTS =
            "Favourite should only be true or false, and it should not be blank";

    public final boolean isFavourite;
    public final String value;

    /**
     * Constructs a {@code Favourite}.
     *
     * @param isFavourite represents if a Study Spot is a favourite.
     */
    public Favourite(boolean isFavourite) {
        requireNonNull(isFavourite);
        this.isFavourite = isFavourite;
        this.value = String.valueOf(isFavourite);
    }

    /**
     * Returns boolean that represents if a Study Spot is a favourite.
     * @return boolean
     */
    public boolean isFavourite() {
        return isFavourite;
    }

    /**
     * Returns true if a given string is a valid favourite.
     */
    public static boolean isValidFavourite(String test) {
        return test.equals("true") || test.equals("false");
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Favourite // instanceof handles nulls
                && isFavourite == ((Favourite) other).isFavourite); // state check
    }

}
