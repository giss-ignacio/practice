import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InterviewExercisesTest {

    @Test
    public void printCompoundWordsTest() {
        List<String> words = Arrays.asList("rockstar", "rock", "star", "rocks", "tar", "highway", "high", "way");
        InterviewExercises.printCompoundWords("rockstar", words);
        //InterviewExercises.printCompoundWords("srocktar", words);
    }
}
