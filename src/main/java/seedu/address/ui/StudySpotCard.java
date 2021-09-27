package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.studyspot.StudySpot;

/**
 * An UI component that displays information of a {@code StudySpot}.
 */
public class StudySpotCard extends UiPart<Region> {

    private static final String FXML = "StudySpotListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on StudyTracker level 4</a>
     */

    public final StudySpot studySpot;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private Label remark;

    /**
     * Creates a {@code StudySpotCode} with the given {@code StudySpot} and index to display.
     */
    public StudySpotCard(StudySpot studySpot, int displayedIndex) {
        super(FXML);
        this.studySpot = studySpot;
        id.setText(displayedIndex + ". ");
        name.setText(studySpot.getName().fullName);
        phone.setText(studySpot.getPhone().value);
        address.setText(studySpot.getAddress().value);
        remark.setText(studySpot.getRemark().value);
        email.setText(studySpot.getEmail().value);
        studySpot.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StudySpotCard)) {
            return false;
        }

        // state check
        StudySpotCard card = (StudySpotCard) other;
        return id.getText().equals(card.id.getText())
                && studySpot.equals(card.studySpot);
    }
}
