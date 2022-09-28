import java.util.Arrays;
import java.util.List;

/**
 * A question that can have multiple answers chosen.
 */
public class MultipleChoiceQuestion implements Question {
    private final String[] candidateAnswers;

    private final String question;

    public MultipleChoiceQuestion(String question, String[] candidateAnswers) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String[] getCandidateAnswers() {
        return candidateAnswers;
    }

    @Override
    public String[] validateAnswers(String[] selectedAnswers) {
        // Only pick the user answers that intersect with the possible answers.
        List<String> candidateList = Arrays.asList(candidateAnswers);
        return Arrays.stream(selectedAnswers)
                .filter(candidateList::contains)
                .toArray(String[]::new);
    }
}
