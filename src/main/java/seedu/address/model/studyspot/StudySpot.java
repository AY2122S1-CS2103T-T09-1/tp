package seedu.address.model.studyspot;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a StudySpot in StudyTracker
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class StudySpot {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Remark remark;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public StudySpot(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags, remark);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.remark = remark;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Remark getRemark() {
        return remark;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
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
                && otherSpot.getName().equals(getName());
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
                && otherStudySpot.getPhone().equals(getPhone())
                && otherStudySpot.getEmail().equals(getEmail())
                && otherStudySpot.getAddress().equals(getAddress())
                && otherStudySpot.getRemark().equals(getRemark())
                && otherStudySpot.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Remark: ")
                .append(getRemark());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
