import java.util.List;

public class SingleChoiceQuestion implements Question {
    private final List<String> candidateAnswers;

    private final String question;

    public SingleChoiceQuestion(String question, List<String> candidateAnswers) {
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
        // Only return the last answer submitted.
        return List.of(candidateAnswers.get(candidateAnswers.size() - 1));
    }
}
