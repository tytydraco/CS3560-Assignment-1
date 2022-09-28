public class SingleChoiceQuestion extends Question {
    public SingleChoiceQuestion(String question, String[] candidateAnswers) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
    }

    @Override
    public String[] validateAnswers(String[] candidateAnswers) {
        // Only return the last answer submitted.
        return new String[]{candidateAnswers[candidateAnswers.length - 1]};
    }
}
