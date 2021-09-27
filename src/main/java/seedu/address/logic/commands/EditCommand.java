package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDYSPOTS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.studyspot.Address;
import seedu.address.model.studyspot.Email;
import seedu.address.model.studyspot.Name;
import seedu.address.model.studyspot.Rating;
import seedu.address.model.studyspot.StudySpot;
import seedu.address.model.tag.Tag;


/**
 * Edits the details of an existing study spot in the study tracker.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the study spot identified "
            + "by the index number used in the displayed study spot list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_RATING + "RATING] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_RATING + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_STUDYSPOT_SUCCESS = "Edited study spot: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This study spot already exists in the study tracker.";

    private Index index;
    private Name name;
    private final EditStudySpotDescriptor editStudySpotDescriptor;

    /**
     * @param index of the study spot in the filtered study spot list to edit
     * @param editStudySpotDescriptor details to edit the study spot with
     */
    public EditCommand(Index index, EditStudySpotDescriptor editStudySpotDescriptor) {
        requireNonNull(index);
        requireNonNull(editStudySpotDescriptor);

        this.index = index;
        this.editStudySpotDescriptor = new EditStudySpotDescriptor(editStudySpotDescriptor);
    }

    /**
     * @param name of the study spot in the study spot list to edit
     * @param editStudySpotDescriptor details to edit the study spot with
     */
    public EditCommand(Name name, EditStudySpotDescriptor editStudySpotDescriptor) {
        requireNonNull(name);
        requireNonNull(editStudySpotDescriptor);

        this.name = name;
        this.editStudySpotDescriptor = editStudySpotDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<StudySpot> lastShownList = model.getFullList();

        boolean isPresent = false;
        StudySpot studySpotToEdit = null;
        for (StudySpot current: lastShownList) {
            if (current.isSameName(name)) {
                studySpotToEdit = current;
                isPresent = true;
                break;
            }
        }

        if (!isPresent) {
            throw new CommandException(Messages.MESSAGE_INVALID_EDIT_NAME);
        }



        StudySpot editedStudySpot = createEditedStudySpot(studySpotToEdit, editStudySpotDescriptor);

        if (!studySpotToEdit.isSameStudySpot(editedStudySpot) && model.hasStudySpot(editedStudySpot)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setStudySpot(studySpotToEdit, editedStudySpot);
        model.updateFilteredStudySpotList(PREDICATE_SHOW_ALL_STUDYSPOTS);
        return new CommandResult(String.format(MESSAGE_EDIT_STUDYSPOT_SUCCESS, editedStudySpot));
    }

    /**
     * Creates and returns a {@code StudySpot} with the details of {@code studySpotToEdit}
     * edited with {@code editStudySpotDescriptor}.
     */
    private static StudySpot createEditedStudySpot(StudySpot studySpotToEdit,
                                                   EditStudySpotDescriptor editStudySpotDescriptor) {
        assert studySpotToEdit != null;

        Name updatedName = editStudySpotDescriptor.getName().orElse(studySpotToEdit.getName());
        Rating updatedRating = editStudySpotDescriptor.getRating().orElse(studySpotToEdit.getRating());
        Email updatedEmail = editStudySpotDescriptor.getEmail().orElse(studySpotToEdit.getEmail());
        Address updatedAddress = editStudySpotDescriptor.getAddress().orElse(studySpotToEdit.getAddress());
        Set<Tag> updatedTags = editStudySpotDescriptor.getTags().orElse(studySpotToEdit.getTags());

        return new StudySpot(updatedName, updatedRating, updatedEmail, updatedAddress, updatedTags);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return name.isSameNameCaseInsensitive(e.name)
                && editStudySpotDescriptor.equals(e.editStudySpotDescriptor);
    }

    /**
     * Stores the details to edit the study spot with. Each non-empty field value will replace the
     * corresponding field value of the study spot.
     */
    public static class EditStudySpotDescriptor {
        private Name name;
        private Rating rating;
        private Email email;
        private Address address;
        private Set<Tag> tags;

        public EditStudySpotDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditStudySpotDescriptor(EditStudySpotDescriptor toCopy) {
            setName(toCopy.name);
            setRating(toCopy.rating);
            setEmail(toCopy.email);
            setAddress(toCopy.address);
            setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, rating, email, address, tags);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        public Optional<Rating> getRating() {
            return Optional.ofNullable(rating);
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditStudySpotDescriptor)) {
                return false;
            }

            // state check
            EditStudySpotDescriptor e = (EditStudySpotDescriptor) other;

            return getName().equals(e.getName())
                    && getRating().equals(e.getRating())
                    && getEmail().equals(e.getEmail())
                    && getAddress().equals(e.getAddress())
                    && getTags().equals(e.getTags());
        }
    }
}
