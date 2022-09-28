public class SingleChoiceQuestion implements Question {
    private final String[] candidateAnswers;

    private final String question;

    public SingleChoiceQuestion(String question, String[] candidateAnswers) {
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
    public String[] validateAnswers(String[] candidateAnswers) {
        // Only return the last answer submitted.
        return new String[]{candidateAnswers[candidateAnswers.length - 1]};
    }
}
