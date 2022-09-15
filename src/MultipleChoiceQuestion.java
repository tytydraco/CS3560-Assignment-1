import java.util.List;
import java.util.stream.Collectors;

/**
 * A question that can have multiple answers chosen.
 */
public class MultipleChoiceQuestion implements Question {
    private final List<String> candidateAnswers;

    private final String question;

    public MultipleChoiceQuestion(String question, List<String> candidateAnswers) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    @Override
    public List<String> validateAnswers(List<String> candidateAnswers) {
        // Only pick the user answers that intersect with the possible answers.
        return candidateAnswers
                .stream()
                .filter(candidateAnswers::contains)
                .collect(Collectors.toList());
    }
}
