package seedu.address.model.studyspot;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.amenity.Amenity;
import seedu.address.model.tag.Tag;

/**
 * Represents a StudySpot in StudyTracker
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class StudySpot {

    // Identity fields
    private final Name name;
    private final Rating rating;
    private final OperatingHours operatingHours;
    private final Favourite favourite;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Amenity> amenities = new HashSet<>();

    //Statistic fields
    private final StudiedHours studiedHours;

    /**
     * Every field must be present and not null.
     */
    public StudySpot(Name name, Rating rating, OperatingHours operatingHours, Address address,
                     StudiedHours studiedHours, Set<Tag> tags, Set<Amenity> amenities) {
        requireAllNonNull(name, rating, operatingHours, address, tags, amenities);
        this.name = name;
        this.rating = rating;
        this.operatingHours = operatingHours;
        this.address = address;
        this.studiedHours = studiedHours;
        this.tags.addAll(tags);
        this.amenities.addAll(amenities);
        this.favourite = new Favourite(false);
    }

    /**
     * Overloaded constructor with favourite specified.
     * Every field must be present and not null.
     */
    public StudySpot(Name name, Rating rating, OperatingHours operatingHours, Address address,
                     StudiedHours studiedHours, Favourite favourite, Set<Tag> tags, Set<Amenity> amenities) {
        requireAllNonNull(name, rating, operatingHours, address, tags, amenities);
        this.name = name;
        this.rating = rating;
        this.operatingHours = operatingHours;
        this.address = address;
        this.studiedHours = studiedHours;
        this.tags.addAll(tags);
        this.amenities.addAll(amenities);
        this.favourite = favourite;
    }


    public Name getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public OperatingHours getOperatingHours() {
        return operatingHours;
    }

    public StudiedHours getStudiedHours() {
        return studiedHours;
    }

    public Address getAddress() {
        return address;
    }

    public Favourite getFavourite() {
        return favourite;
    }

    public boolean isFavourite() {
        return favourite.isFavourite();
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable amenity set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Amenity> getAmenities() {
        return Collections.unmodifiableSet(amenities);
    }

    /**
     * Returns true if both study spots have the same name.
     * This defines a weaker notion of equality between two study spots.
     */
    public boolean isSameStudySpot(StudySpot otherSpot) {
        if (otherSpot == this) {
            return true;
        }

        return otherSpot != null
                && otherSpot.getName().toString().equalsIgnoreCase(getName().toString());
    }

    /**
     * Returns true if both study spots have the same identity and data fields.
     * This defines a stronger notion of equality between two study spots.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof StudySpot)) {
            return false;
        }

        StudySpot otherStudySpot = (StudySpot) other;
        return otherStudySpot.getName().equals(getName())
                && otherStudySpot.getRating().equals(getRating())
                && otherStudySpot.getOperatingHours().equals(getOperatingHours())
                && otherStudySpot.getAddress().equals(getAddress())
                && otherStudySpot.getFavourite().equals(getFavourite())
                && otherStudySpot.getTags().equals(getTags())
                && otherStudySpot.getAmenities().equals(getAmenities());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, rating, operatingHours, address, tags, amenities);
    }

    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Rating: ")
                .append(getRating());

        if (!getOperatingHours().toString().equals("-")) {
            builder
                .append("; Operating Hours: ")
                .append(getOperatingHours());
        }

        if (!getAddress().toString().equals("-")) {
            builder
                .append("; Address: ")
                .append(getAddress());
        }

        if (getFavourite().isFavourite()) {
            builder.append("; Favourite: ")
                    .append(getFavourite());
        }

        if (getStudiedHours().getHours() > 0) {
            builder.append("; Studied Hours: ")
                    .append(getStudiedHours());
        }

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        Set<Amenity> amenities = getAmenities();
        if (!amenities.isEmpty()) {
            builder.append("; Amenities: ");
            amenities.forEach(builder::append);
        }

        return builder.toString();
    }

    public boolean isSameName(Name name) {
        return this.name.isSameNameCaseInsensitive(name);
    }

}
