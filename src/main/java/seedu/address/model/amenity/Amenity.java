package seedu.address.model.amenity;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Arrays;

/**
 * Represents an Amenity in the study tracker.
 * Guarantees: immutable; type is valid as declared in {@link #isValidAmenityType(String)}
 */
public class Amenity {

    public static final String MESSAGE_CONSTRAINTS = "Amenities should only be of the types: %s.";
    public static final String[] VALID_TYPES = {"wifi", "charger", "food", "aircon"};

    public final String amenityType;

    /**
     * Constructs a {@code Amenity}.
     *
     * @param amenityType A valid amenity type.
     */
    public Amenity(String amenityType) {
        requireNonNull(amenityType);
        checkArgument(isValidAmenityType(amenityType),
                String.format(MESSAGE_CONSTRAINTS, listAllAmenityTypes(VALID_TYPES)));
        this.amenityType = amenityType;
    }

    /**
     * Returns true if a given string is a valid amenity type.
     */
    public static boolean isValidAmenityType(String test) {
        requireNonNull(test);
        return Arrays.asList(VALID_TYPES).stream().anyMatch(test::equalsIgnoreCase);
    }

    /**
     * Lists all amenity types in a single string.
     */
    public static String listAllAmenityTypes(String[] amenityTypes) {
        if (amenityTypes.length == 1) {
            return amenityTypes[0];
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < amenityTypes.length - 1; i++) {
                sb.append(amenityTypes[i]);
                sb.append(", ");
            }
            sb.append(amenityTypes[amenityTypes.length - 1]);
            return sb.toString();
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.amenity.Amenity // instanceof handles nulls
                && amenityType.equals(((seedu.address.model.amenity.Amenity) other).amenityType)); // state check
    }

    @Override
    public int hashCode() {
        return amenityType.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + amenityType + ']';
    }

}

