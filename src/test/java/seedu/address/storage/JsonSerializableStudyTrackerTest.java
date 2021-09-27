package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.StudyTracker;
import seedu.address.testutil.TypicalStudySpots;

public class JsonSerializableStudyTrackerTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableStudyTrackerTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalStudySpotsStudyTracker.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidStudySpotStudyTracker.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicateStudySpotStudyTracker.json");

//    @Test
//    public void toModelType_typicalStudySpotsFile_success() throws Exception {
//        JsonSerializableStudyTracker dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
//                JsonSerializableStudyTracker.class).get();
//        StudyTracker studyTrackerFromFile = dataFromFile.toModelType();
//        StudyTracker typicalStudySpotsStudyTracker = TypicalStudySpots.getTypicalAddressBook();
//        assertEquals(studyTrackerFromFile, typicalStudySpotsStudyTracker); //todo
//    }

    @Test
    public void toModelType_invalidStudySpotFile_throwsIllegalValueException() throws Exception {
        JsonSerializableStudyTracker dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableStudyTracker.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateStudySpots_throwsIllegalValueException() throws Exception {
        JsonSerializableStudyTracker dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableStudyTracker.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableStudyTracker.MESSAGE_DUPLICATE_STUDYSPOT,
                dataFromFile::toModelType);
    }

}
