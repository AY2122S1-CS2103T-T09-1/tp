package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.studyspot.Address;
import seedu.address.model.studyspot.Email;
import seedu.address.model.studyspot.Name;
import seedu.address.model.studyspot.Phone;
import seedu.address.model.studyspot.Remark;
import seedu.address.model.studyspot.StudySpot;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building StudySpot objects.
 */
public class StudySpotBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "She likes aardvarks.";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Set<Tag> tags;

    /**
     * Creates a {@code StudySpotBuilder} with the default details.
     */
    public StudySpotBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
    }

    /**
     * Initializes the StudySpotBuilder with the data of {@code personToCopy}.
     */
    public StudySpotBuilder(StudySpot personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        remark = personToCopy.getRemark();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code StudySpot} that we are building.
     */
    public StudySpotBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code StudySpot} that we are building.
     */
    public StudySpotBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code StudySpot} that we are building.
     */
    public StudySpotBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code StudySpot} that we are building.
     */
    public StudySpotBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code StudySpot} that we are building.
     */
    public StudySpotBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public StudySpotBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    public StudySpot build() {
        return new StudySpot(name, phone, email, address, remark, tags);
    }

}
