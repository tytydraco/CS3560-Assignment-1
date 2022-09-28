import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SingleChoiceQuestion extends Question {
    public SingleChoiceQuestion(String question, String[] candidateAnswers) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String[] validateAnswers(String[] selectedAnswers) {
        List<String> candidateList = Arrays.asList(candidateAnswers);

        // Reverse the order to get the last valid value.
        final List<String> reversedAnswers = Arrays.asList(selectedAnswers);
        Collections.reverse(reversedAnswers);

        // Only return the last valid answer submitted.
        final Optional<String> firstValid = reversedAnswers.stream().filter(candidateList::contains).findFirst();
        return new String[]{firstValid.orElse("N/A")};
    }
}
