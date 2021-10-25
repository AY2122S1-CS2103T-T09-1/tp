package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.studyspot.Favourite;
import seedu.address.model.studyspot.Name;
import seedu.address.model.studyspot.StudySpot;
import seedu.address.model.studyspot.UniqueStudySpotList;

/**
 * Wraps all data at the study-tracker level
 * Duplicates are not allowed (by .isSameStudySpot comparison)
 */
public class StudyTracker implements ReadOnlyStudyTracker {

    private final UniqueStudySpotList studySpots;
    private final UniqueStudySpotList favouriteStudySpots;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        studySpots = new UniqueStudySpotList();
        favouriteStudySpots = new UniqueStudySpotList();
    }

    public StudyTracker() {}

    /**
     * Creates an StudyTracker using the StudySpots in the {@code toBeCopied}
     */
    public StudyTracker(ReadOnlyStudyTracker toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the study spot list with {@code studySpots}.
     * {@code studySpots} must not contain duplicate study spots.
     */
    public void setStudySpots(List<StudySpot> studySpots) {
        this.studySpots.setStudySpots(studySpots);
    }

    /**
     * Replaces the contents of the study spot list with {@code studySpots}.
     * {@code studySpots} must not contain duplicate study spots.
     */
    public void setFavouriteStudySpots(List<StudySpot> studySpots) {
        this.favouriteStudySpots.setStudySpots(studySpots);
    }

    /**
     * Resets the existing data of this {@code StudyTracker} with {@code newData}.
     */
    public void resetData(ReadOnlyStudyTracker newData) {
        requireNonNull(newData);

        setStudySpots(newData.getStudySpotList());
        setFavouriteStudySpots(newData.getFavouriteStudySpotList());
    }

    //// study spot-level operations

    /**
     * Returns true if a study spot with the same identity as {@code studySpot} exists in the study tracker.
     */
    public boolean hasStudySpot(StudySpot studySpot) {
        requireNonNull(studySpot);
        return studySpots.contains(studySpot);
    }

    /**
     * Returns StudySpot with the specified {@code Name} in the study tracker.
     * Otherwise, returns null.
     *
     * @param name
     */
    public StudySpot findStudySpot(Name name) {
        StudySpot studySpot = null;
        for (StudySpot current: studySpots) {
            if (current.isSameName(name)) {
                studySpot = current;
                break;
            }
        }
        return studySpot;
    }

    /**
     * Adds a study spot to the study tracker.
     * The study spot must not already exist in the study tracker.
     */
    public void addStudySpot(StudySpot p) {
        studySpots.add(p);
    }

    /**
     * Replaces the given study spot {@code target} in the list with {@code editedStudySpot}.
     * {@code target} must exist in the study tracker.
     * The study spot identity of {@code editedStudySpot} must not
     * be the same as another existing study spot in the study tracker.
     */
    public void setStudySpot(StudySpot target, StudySpot editedStudySpot) {
        requireNonNull(editedStudySpot);

        studySpots.setStudySpot(target, editedStudySpot);
        if (editedStudySpot.isFavourite() && favouriteStudySpots.contains(target)) {
            favouriteStudySpots.setStudySpot(target, editedStudySpot);
        }
    }

    /**
     * Removes {@code key} from this {@code StudyTracker}.
     * {@code key} must exist in the study tracker.
     */
    public void removeStudySpot(StudySpot key) {
        studySpots.remove(key);
    }

    //// Favourite study spot-level operations

    /**
     * Returns true if a study spot with the same identity as {@code studySpot} is a favourite in the study tracker.
     */
    public boolean isFavouriteStudySpot(StudySpot studySpot) {
        requireNonNull(studySpot);
        return favouriteStudySpots.contains(studySpot);
    }

    /**
     * Adds the given study spot to favourites.
     * {@code study spot} must already exist in the study tracker.
     *
     * @param studySpot
     * @return Returns the updated study spot.
     */
    public StudySpot addStudySpotToFavourites(StudySpot studySpot) {
        assert(hasStudySpot(studySpot) == true);
        StudySpot favouriteStudySpot = new StudySpot(studySpot.getName(), studySpot.getRating(),
                studySpot.getOperatingHours(), studySpot.getAddress(), studySpot.getStudiedHours(),
                new Favourite(true), studySpot.getTags(), studySpot.getAmenities());
        setStudySpot(studySpot, favouriteStudySpot);
        favouriteStudySpots.add(favouriteStudySpot);
        return favouriteStudySpot;
    }

    /**
     * Removes the given study spot from favourites.
     * {@code study spot} must already exist in the study tracker.
     *
     * @param studySpot
     * @return Returns the updated study spot.
     */
    public StudySpot removeStudySpotFromFavourites(StudySpot studySpot) {
        assert(hasStudySpot(studySpot) == true);
        StudySpot unfavouriteStudySpot = new StudySpot(studySpot.getName(), studySpot.getRating(),
                studySpot.getOperatingHours(), studySpot.getAddress(), studySpot.getStudiedHours(),
                new Favourite(false), studySpot.getTags(), studySpot.getAmenities());
        setStudySpot(studySpot, unfavouriteStudySpot);
        favouriteStudySpots.remove(studySpot);
        return unfavouriteStudySpot;
    }

    //// util methods

    @Override
    public String toString() {
        return studySpots.asUnmodifiableObservableList().size() + " study spots";
        // TODO: refine later
    }

    @Override
    public ObservableList<StudySpot> getStudySpotList() {
        return studySpots.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<StudySpot> getFavouriteStudySpotList() {
        return favouriteStudySpots.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudyTracker // instanceof handles nulls
                && studySpots.equals(((StudyTracker) other).studySpots)
                && favouriteStudySpots.equals(((StudyTracker) other).favouriteStudySpots));
    }

    @Override
    public int hashCode() {
        return studySpots.hashCode();
    }

}
