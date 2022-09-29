import java.util.Arrays;
import java.util.List;

/**
 * A question that can have multiple answers chosen.
 */
public class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String question, String[] candidateAnswers) {
        super(question, candidateAnswers);
    }

    @Override
    public String[] validateAnswers(String[] selectedAnswers) {
        // Only pick the user answers that intersect with the possible answers.
        List<String> candidateList = Arrays.asList(getCandidateAnswers());
        return Arrays.stream(selectedAnswers)
                .filter(candidateList::contains)
                .toArray(String[]::new);
    }
}
