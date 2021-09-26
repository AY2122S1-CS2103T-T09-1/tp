package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.studyspot.*;
import seedu.address.model.studyspot.Rating;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link StudySpot}.
 */
class JsonAdaptedStudySpot {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "StudySpot's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedStudySpot} with the given study spot details.
     */
    @JsonCreator
    public JsonAdaptedStudySpot(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("address") String address,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code StudySpot} into this class for Jackson use.
     */
    public JsonAdaptedStudySpot(StudySpot source) {
        name = source.getName().fullName;
        phone = source.getRating().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted study spot object into the model's {@code StudySpot} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted study spot.
     */
    public StudySpot toModelType() throws IllegalValueException {
        final List<Tag> studySpotTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            studySpotTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Rating.class.getSimpleName()));
        }
        if (!Rating.isValidRating(phone)) {
            throw new IllegalValueException(Rating.MESSAGE_CONSTRAINTS);
        }
        final Rating modelRating = new Rating(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final Set<Tag> modelTags = new HashSet<>(studySpotTags);
        return new StudySpot(modelName, modelRating, modelEmail, modelAddress, modelTags);
    }

}
